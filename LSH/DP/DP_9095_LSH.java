// BOJ - 1,2,3 더하기(9095번)
// DP

import java.util.Scanner;

public class DP_9095_LSH {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int TC = scan.nextInt();
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=10;i++){
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]);
        }

        for(int t=0;t<TC;t++){
            int n = scan.nextInt();
            System.out.println(dp[n]);
        }
    }
}
