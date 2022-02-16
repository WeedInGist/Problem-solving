// BOJ - 스타트와 링크(14889번)
// DFS 풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int[][] map;
    public static int ans;
    public static int sum;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sum = 0;
        map = new int[n][n];
        for(int i=0;i<n;i++){
            String[] data = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(data[j]);
                sum += map[i][j];
            }
        }
        visited = new boolean[n];
        ans = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int start, int depth){
        if(depth == n/2){
            int temp = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(visited[i]){
                        temp += map[i][j];
                    }
                    if(visited[j]){
                        temp += map[i][j];
                    }
                }
            }

            ans = Math.min(ans, Math.abs(sum-temp));
            return;
        }

        for(int i=start;i<n;i++){
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }
}
