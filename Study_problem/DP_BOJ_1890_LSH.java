// BOJ - 점프(1890)
// DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_BOJ_1890_LSH {
    public static void main(String[] args) throws IOException {
        // 입력 받는 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // map에 게임판 적힌 수 저장
        int[][] map = new int[n][n];
        // dp에 해당 위치에서 지나가는 경우의 수 카운트
        long[][] dp = new long[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 시작점은 지나가는 경우 1
        dp[0][0] = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] == 0) continue;
                // 현재 게임판에 적힌 숫자 + 현재 열 => 가로이동 가능 ?
                if(map[i][j]+j < n){
                    int col = map[i][j] + j;
                    // 지나갈 수 경우의 수 1 증가
                    dp[i][col] += dp[i][j];
                }
                // 현재 게임판에 적힌 숫자 + 현재 행 => 세로이동 가능 ?
                if(map[i][j]+i < n){
                    int row = map[i][j] + i;
                    // 지나갈 수 경우의 수 1 증가
                    dp[row][j] += dp[i][j];
                }
            }
        }


        System.out.println(dp[n-1][n-1]);

    }


}
