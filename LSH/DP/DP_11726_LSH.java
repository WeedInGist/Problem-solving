// BOJ - 2xn 타일링(11726번)
// DP

import java.util.Scanner;

public class DP_11726_LSH {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2]) % 10007;

        }
        System.out.println(dp[n]);
    }
}
