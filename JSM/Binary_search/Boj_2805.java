package Algo_study.Binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2805 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        long[] arr = new long[n];
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        long low = 0;
        long high = arr[n-1];
        long result = 0;
        while(low <= high)
        {
            long mid = (low+high)/2;
            long sum = 0;
            for(int i = 0 ; i < n; i++)
            {
                if(arr[i]-mid >= 0)
                {
                    sum += arr[i]-mid;
                }
            }
            if(sum >= m)
            {
                result = mid;
                low = mid + 1;
            }
            else
            {
                high = mid -1;
            }
        }
        System.out.println(result);
    }
}
