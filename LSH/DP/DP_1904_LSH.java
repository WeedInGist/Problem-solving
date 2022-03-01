// BOJ - 병사 배치하기(1904번)
// DP

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            arr[n-i-1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = 1;
        }
        int max = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(n-max);


    }
}
