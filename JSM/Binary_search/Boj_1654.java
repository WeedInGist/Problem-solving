package Algo_study.Binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1654 {
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] arr = new long[k];
        for(int i = 0 ; i < k; i++)
        {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        long low = 0;
        long high = arr[k-1];
        long mid = 0;
        long result = 0;
        while(low <= high)
        {
            // System.out.println(low+" "+high);
            mid = (low+high)/2;
            if(mid == 0)
            {
                mid = 1;
            }
            long count = 0;
            for(int i = 0 ; i < k; i++)
            {
                count += arr[i]/mid;
            }
            if(count >= n)
            {
                result = mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        System.out.println(result);
    }
}
