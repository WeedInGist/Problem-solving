// BOJ - 인구이동(16234번)
// BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_16234_LSH {
    public static int n, l, r;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static class Node {
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        n = Integer.parseInt(data[0]);
        l = Integer.parseInt(data[1]);
        r = Integer.parseInt(data[2]);
        map = new int[n][n];
        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int ans = 0;
        while (true){
            visited = new boolean[n][n];
            boolean check = false;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int cnt = 0;
                   if(!visited[i][j]){
                       cnt = bfs(i, j);
                       if(cnt > 1){
                           check = true;
                       }
                   }

                }
            }

            if(!check){
                break;
            } else {
                ans++;
            }

        }

        System.out.println(ans);

    }

    public static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(x, y));
        Queue<Node> q2 = new LinkedList<>();
        q2.add(new Node(x, y));
        int cnt = 1;
        int sum = map[x][y];
        while (!q.isEmpty()){
            Node node = q.poll();
            for(int d=0;d<4;d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];
                if(0 <= nx && nx < n && 0 <= ny && ny < n){
                    if(!visited[nx][ny]){
                        int diff = Math.abs(map[node.x][node.y]-map[nx][ny]);
                        if(diff >= l && diff <= r){
                            cnt++;
                            sum += map[nx][ny];
                            visited[nx][ny] = true;
                            q.offer(new Node(nx, ny));
                            q2.offer(new Node(nx, ny));
                        }
                    }
                }
            }
        }

        while (!q2.isEmpty()){
            Node node = q2.poll();
            map[node.x][node.y] = (sum/cnt);
        }

        return cnt;
    }




}
