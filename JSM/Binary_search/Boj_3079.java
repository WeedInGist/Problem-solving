package Algo_study.Binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_3079 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        long[] arr = new long[n];
        for(int i = 0 ; i < n; i++)
        {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        long low = 1;
        long high = arr[n-1] * m; 
        long result = 1;
        while(low <= high)
        {
            long mid = (low + high)/2;
            long count = 0;

            for(int j = 0 ; j < n ; j++)
            {  
                count += mid/arr[j];
            }
                //mid 시간까지 빠짐없이 돌린 
            if(count >= m)
            {
                result = mid;
                high = mid-1;
            }
            else if(count <m)
            {
                low = mid +1;
            }
        }
        System.out.print(result);
    }
}
