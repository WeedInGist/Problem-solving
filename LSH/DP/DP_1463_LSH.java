// BOJ - 1로 만들기(1463번)
// DP

import java.util.Scanner;

public class DP_1463_LSH {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] dp = new int[1000001];

        for(int i=0;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4;i<=n;i++){
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if(i % 3 ==0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
            dp[i] = Math.min(dp[i], dp[i-1] + 1);


        }


        System.out.println(dp[n]);

    }
}
