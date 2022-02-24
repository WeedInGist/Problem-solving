// BinarySearch_boj_2792_JJC

import java.io.*;
import java.util.*;

public class BinarySearch_boj_2792_JJC {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] gem = new int[M];
        for (int i = 0; i < M; i++) {
            gem[i] = Integer.parseInt(br.readLine());
        } // 입력끝.

        Arrays.sort(gem); 
        int start = 1; // 0개 씩나누어 줄수는 없으며 최소 한개씩 나누어 줄 수 있다.
        int end = gem[M - 1]; // 최대 나누어 줄수 있는 개수는 가장 개수가 많은 보석의 개수만큼이다.
        int min = Integer.MAX_VALUE; 

        while (start <= end) { // 이진 탐색 시작.
            int mid = (start + end) / 2;
            int temp = divide(gem, mid); // mid개씩 나누어 줬을때 나오는 묶음 개수
            if (temp <= N) { // 묶음 개수가 사람들의 수보다 적으면 성공적으로 나눠 줄 수 있다.(질투심이 최소가 아닐 수도 있다.)
                min = Math.min(min, mid); // 성공적으로 나누어 줬을 때들의 최솟값을 구해준다.
                end = mid - 1; 
            } else {
                start = mid + 1; 
            }
        }

        System.out.println(min); //츨력 끝
        br.close();
    }

    static int divide(int[] arr, int n) { // n개씩 나누어 준다면 몇묶음이 나오는지 계산한다.
        int count = 0;
        for (int i = 0; i < M; i++) {
            count += arr[i] / n; 
            if (arr[i] % n != 0) // 한 종류의 보석을 n개로 나누었을때 나머지가 있으면 한 묶음을 추가로 센다.
                count++;
        }
        return count;
    }
}