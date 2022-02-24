// BOJ - 보석 상자(2792번)
// BinarySearch

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch_2792_LSH {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        long[] arr = new long[m];
        long max_value = 0;
        for(int i=0;i<m;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max_value = Math.max(max_value, arr[i]);
        }


        long left = 1;
        long right = max_value;
        long ans = 0;

        while (left <= right){
            long mid = (left+right) / 2;
            int student = 0;

            for(int i=0;i<m;i++){
                student += arr[i] / mid;
                if(arr[i] % mid != 0){
                    student += 1;
                }
            }

            if(student <= n ){
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }

        }

        System.out.println(ans);


    }
}
