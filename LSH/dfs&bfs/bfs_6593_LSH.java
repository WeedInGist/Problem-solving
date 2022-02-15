// BOJ - 상범 빌딩(6593번)
// BFS(3차원 탐색)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_6593_LSH {
    public static char[][][] map;
    public static int l, r, c;
    public static int start_f, start_x, start_y, end_f, end_x, end_y;
    public static int[][][] visited;
    public static int[] df = {-1, 1, 0, 0, 0, 0};
    public static int[] dx = {0, 0, -1, 1, 0, 0};
    public static int[] dy = {0, 0, 0, 0, -1 ,1};
    public static class Node{
        int f;
        int x;
        int y;
        public Node(int f, int x, int y){
            this.x = x;
            this.y = y;
            this.f = f;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String[] data = br.readLine().split(" ");
            l = Integer.parseInt(data[0]);
            r = Integer.parseInt(data[1]);
            c = Integer.parseInt(data[2]);
            if(l == 0 && r == 0 && c == 0){
                break;
            }

            map = new char[l][r][c];
            start_f = 0;
            start_x = 0;
            start_y = 0;
            end_f = 0;
            end_x = 0;
            end_y = 0;
            visited = new int[l][r][c];

            for(int i=0;i<l;i++){
                for(int j=0;j<r;j++){
                    String input = br.readLine();
                    for(int k=0;k<c;k++){
                        map[i][j][k] = input.charAt(k);
                        if(map[i][j][k] == 'S'){
                            start_f = i;
                            start_x = j;
                            start_y = k;
                        }

                        if(map[i][j][k] == 'E'){
                            end_f = i;
                            end_x = j;
                            end_y = k;
                        }
                    }
                }
                br.readLine();
            }

            bfs(start_f, start_x, start_y);
            if(visited[end_f][end_x][end_y] == 0){
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %d minute(s).\n", visited[end_f][end_x][end_y]-1);

            }
        }
    }

    public static void bfs(int s_f, int s_x, int s_y){
        Queue<Node> q = new LinkedList<>();
        visited[s_f][s_x][s_y] = 1;
        q.offer(new Node(s_f, s_x, s_y));
        while (!q.isEmpty()){
            Node node = q.poll();
            for(int d=0;d<6;d++){
                int nf = node.f + df[d];
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];
                if(0<=nf && nf < l && 0 <= nx && nx < r && 0 <= ny && ny < c){
                    if(visited[nf][nx][ny] == 0 && map[nf][nx][ny] != '#'){
                        visited[nf][nx][ny] = visited[node.f][node.x][node.y] +1;
                        q.offer(new Node(nf, nx, ny));
                    }
                }
            }
        }
    }
}
