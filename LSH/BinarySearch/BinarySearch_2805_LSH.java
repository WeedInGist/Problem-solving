// BOJ - 나무 자르기(2805번)
// BinarySearch

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch_2805_LSH {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        long m = Integer.parseInt(data[1]);
        long[] arr = new long[n];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        long left = 1;
        long right = 1_000_000_000;
        long ans = 0;
        while (left <= right){
            long mid = (left+right)/2;

            long cnt = 0;
            for(int i=0;i<n;i++){
                long diff = arr[i] -mid;
                if(diff > 0){
                    cnt += diff;
                }
            }

            if(cnt >= m){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);

    }
}
