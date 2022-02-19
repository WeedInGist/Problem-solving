// BOJ - 아기상어(16236번)
// BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bfs_16236_LSH {
    public static int n;
    public static int[][] map;
    public static int time;
    public static int baby_x, baby_y, baby_size;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int dis;
        public Node(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            if(this.dis == o.dis){
              if(this.x == o.x){
                  return this.y - o.y;
              } else {
                  return this.x - o.x;
              }
            } else{
                return this.dis - o.dis;
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0;i<n;i++){
            String[] data = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(data[j]);
                if(map[i][j] == 9){
                    baby_x = i;
                    baby_y = j;
                    map[i][j] = 0;
                }
            }
        }
        baby_size = 2;
        time = 0;
        int eat_cnt = 0;
        while (true){
            // 먹을 수 있는 물고기..
            boolean check = bfs();
            if(!check){
                break;
            }
            eat_cnt++;

            if(eat_cnt == baby_size){
                baby_size++;
                eat_cnt = 0;
            }
        }

        System.out.println(time);
    }

    public static boolean bfs(){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        visited[baby_x][baby_y] = true;
        ArrayList<Node> eat_list = new ArrayList<>();
        queue.offer(new Node(baby_x, baby_y, 0));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            for(int d=0;d<4;d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if(0<= nx && nx < n && 0 <= ny && ny < n){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        if(map[nx][ny] <= baby_size){
                            queue.offer(new Node(nx, ny, node.dis+1));
                            if(map[nx][ny] != 0 && map[nx][ny] < baby_size){
                                eat_list.add(new Node(nx, ny, node.dis+1));
                            }
                        }
                    }
                }
            }
        }

        if(eat_list.size() == 0){
            return false;
        }
        Collections.sort(eat_list);
        time += (eat_list.get(0).dis);
        baby_x = eat_list.get(0).x;
        baby_y = eat_list.get(0).y;
        map[eat_list.get(0).x][eat_list.get(0).y] = 0;

        return true;
    }
}
