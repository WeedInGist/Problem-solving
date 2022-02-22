// BOJ - 랜선 자르기(1654번)
// BinarySearch
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch_1654_LSH {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int k = Integer.parseInt(data[0]);
        int n = Integer.parseInt(data[1]);

        long[] arr = new long[k];
        long max_value = 0;
        for(int i=0;i<k;i++){
            int num = Integer.parseInt(br.readLine());
            max_value = Math.max(max_value, num);
            arr[i] = num;
        }

        long left = 1;
        long right = max_value;
        long ans = 0;
        while (left<= right){
            long mid = (left+right)/2;
            long cnt = 0;
            for(int i=0;i<k;i++){
                cnt += (arr[i] / mid);
            }

            if(cnt >= n){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        System.out.println(ans);
    }
}
