// BOJ - 캐슬 디펜스(17135번)
// 구현(dfs+bfs)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class implementation_17135_LSH {
    public static int map[][];
    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int distance;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }


        @Override
        public int compareTo(Node o) {
            if(this.distance == o.distance){
                return this.y - o.y;
            }
            return this.distance - o.distance;
        }
    }
    public static int n, m, d;
    public static ArrayList<Node> list;
    public static ArrayList<int[]> combi_list;
    public static int cnt, ans;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        cnt = 0;
        ans = 0;
        map = new int[n+1][m];
        list = new ArrayList<>();
        combi_list = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    cnt++;
                }
            }
        }

        for(int i=0;i<m;i++){
            list.add(new Node(n, i));
        }

        dfs(new int[3], 0, 0);

        for(int[] c:combi_list){
            int[][] map_copy = new int[n+1][m];
            for(int i=0;i<n+1;i++){
                for(int j=0;j<m;j++){
                    map_copy[i][j] = map[i][j];
                }
            }
            ArrayList<Node> attack = new ArrayList<>();

            for(int i:c){
                int x = list.get(i).x;
                int y = list.get(i).y;
                attack.add(new Node(x, y));
                map_copy[x][y] = -1;

            }

            int sum = 0;
            int kill = 0;

            outer: while (true){
                if(sum >= cnt){
                    ans = Math.max(ans, kill);
                    break outer;
                }
                // 공격 몬스터 리스트
                ArrayList<Node> monster = new ArrayList<>();
                // 공격
                for(Node a:attack){
                    Node node = bfs(a.x, a.y, map_copy);

                    if(node == null) continue ;
                    monster.add(new Node(node.x, node.y));
                }

                for(Node mon:monster){
                    if(map_copy[mon.x][mon.y] == 1){
                        kill++;
                        sum++;
                        map_copy[mon.x][mon.y] = 0;
                    }
                }


                for(int i=0;i<m;i++){
                    if(map_copy[n-1][i] == 1){
                        sum++;
                        map_copy[n-1][i] = 0;
                    }
                }

                // 내려가기
                for(int j=0;j<m;j++){
                    for(int i=n-1;i>=1;i--){
                        if(map_copy[i-1][j] == 1){
                            map_copy[i][j] = 1;
                            map_copy[i-1][j] = 0;
                        }
                    }
                }




            }
        }

        System.out.println(ans);


    }

    public static Node bfs(int x, int y, int[][] map_copy){
        boolean[][] visited = new boolean[n+1][m];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));

        while (!q.isEmpty()){
            Node node = q.poll();
            if(map_copy[node.x][node.y] == 1 && node.distance <= d){
                pq.add(new Node(node.x, node.y, node.distance));
            }


            for(int k=0;k<4;k++){
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];
                if(0<= nx && nx < n && 0 <= ny && ny < m){
                    if(!visited[nx][ny] && map_copy[nx][ny] != -1){
                        int dis = node.distance;
                        q.offer(new Node(nx, ny, dis+1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return pq.poll();

    }

    public static void dfs(int[] arr, int depth, int start){
        if(depth == 3){
            int[] arr_copy = arr.clone();
            combi_list.add(arr_copy);
            return;
        }

        for(int i=start;i<m;i++){
            arr[depth] = i;
            dfs(arr, depth+1, i+1);
        }
    }


}
