// BOJ - 암호 코드 (2011번)
// DP

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_2011_LSH {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if(input.charAt(0) == '0'){
            System.out.println(0);
        } else {
            long[] dp = new long[input.length()+1];

            dp[0] = 1;
            dp[1] = 1;
            boolean check = false;
            for(int i=2;i<=input.length();i++){
                int pre = input.charAt(i-2) -'0';
                int current = input.charAt(i-1) -'0';

                if(current == 0){
                    if(pre == 1 || pre ==2) dp[i] = dp[i-2] % 1000000;
                    else{
                        check = true;
                        break;
                    }
                } else {
                    if(pre == 0){
                        dp[i] = dp[i-1] % 1000000;
                    } else {
                        int number = (pre*10 + current);
                        if(1<= number && number <= 26){
                            dp[i] = (dp[i-2]+dp[i-1]) % 1000000;
                        } else{
                            dp[i] = dp[i-1] % 1000000;
                        }
                    }
                }

            }

            if(check){
                System.out.println(0);
            } else {
                System.out.println(dp[input.length()] % 1000000);
            }

        }

    }
}
