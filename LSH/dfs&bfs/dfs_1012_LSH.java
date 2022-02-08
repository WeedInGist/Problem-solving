// BOJ - 유기농 배추(1012번)
// DFS 풀이
import java.io.*;

public class dfs_1012_LSH {
    static int[][] map;
    static boolean[][] visited;
    static int n, m, k;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=t;test_case++){
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            k = Integer.parseInt(str[2]);
            map = new int[n][m];
            visited = new boolean[n][m];
            int cnt = 0;

            for(int i=0;i<k;i++){
                String[] data = br.readLine().split(" ");
                int x = Integer.parseInt(data[0]);
                int y = Integer.parseInt(data[1]);
                map[x][y] = 1;
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            bw.write(String.valueOf(cnt+"\n"));

        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(0<=nx && nx < n && 0 <= ny && ny < m){
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }
}
