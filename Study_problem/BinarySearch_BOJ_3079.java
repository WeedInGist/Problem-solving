// BOJ - 입국심사(3079번)
// BinarySearch
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BinarySearch_BOJ_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N과 M 그리고 각 입국 심사대에서 걸리는 시간을 arr 배열에 데이터를 입력받음
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int[] arr = new int[n];
        // 그리고 가장 입국 심사대에서 오래 걸리는 시간을 max_value 로 구함
        int max_value = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max_value = Math.max(max_value, arr[i]);
        }
        // 이진 탐색 : 시간을 중심으로 탐색
        // 해당 시간일 때 최대 몇 명의 사람을 입국 심사대에서 통과 시킬 수 있나 ?
        // 만약 mid 초일 때 m명 이상의 사람을 해당 시간에 입국 심사대에서 보낼 수 있으면 -> 시간 탐색을 0 ~ mid-1로 탐색 범위 변경
        // 만약 mid 초일 때 m-1 이하의 사람을 해당 시간에 입국 심사대에서 보낼 수 있으면 -> 시간 탐색을 mid+1 ~ right로 탐색 범위 변경
        // 왜 right가 밑의 값이냐 ? 어차피 최대 시간초는 최대 오래걸리는 입국 심사대에서 걸리는 시간(Tk) * 심사 받으려는 사람 수(M) 
        // M은 문제에서 주어진 1,000,000,000의 범위임..
      
        long left = 0L;
        long right = (max_value) * 1000000000L;

        long ans = 0L;
        while (left<= right){
            long mid = (left+right) / 2;
            // mid초 일 때 각 입국 심사대에서 보낼 수 있는 수를 카운트 해줌
            long cnt = 0;
            for(int i=0;i<n;i++){
                cnt += (mid / arr[i]);

            }
            // 비교 후 탐색 범위 변경
            if(cnt >= m){
                ans = mid;
                right = mid-1;
            }  else if (cnt < m){
                left = mid +1;

            }
        }


        System.out.println(ans);





    }
}
