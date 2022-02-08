// BOJ - 섬의 개수(4963번)
// DFS 풀이
import java.io.*;


public class dfs_4963_LSH {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true){
            String[] str = br.readLine().split(" ");
            h = Integer.parseInt(str[0]);
            w = Integer.parseInt(str[1]);

            if(w == 0 && h == 0){
                break;
            }
            if(w == 1 && h==1){
                int d = Integer.parseInt(br.readLine());
                if(d == 0){
                    bw.write(String.valueOf("0\n"));
                } else {
                    bw.write(String.valueOf("1\n"));
                }
                continue;
            }

            map = new int[w][h];
            visited = new boolean[w][h];

            for(int i=0;i<w;i++){
                String[] data = br.readLine().split(" ");
                for (int j=0;j<h;j++){
                    map[i][j] = Integer.parseInt(data[j]);
                }
            }

            int cnt = 0;
            for(int i=0;i<w;i++){
                for (int j=0;j<h;j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            bw.write(String.valueOf(cnt+"\n"));

        }

        bw.flush();
        bw.close();
    }


    public static void dfs(int i, int j){
        visited[i][j] = true;

        for(int d=0;d<8;d++){
            int nx = i + dx[d];
            int ny = j + dy[d];
            if(0<=nx && nx < w && 0 <= ny && ny < h){
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }

    }
}
