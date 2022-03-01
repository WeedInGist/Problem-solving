package Algo_study.Binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2110 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        long low = 1;
        long high = arr[n-1];
        long result = 0;
        while( low <= high)
        {
            long mid = (low+high)/2;
            int count = 1;
            long total = 0;
            long last_install = arr[0];
            for(int i = 1; i < n; i++)
            {
                if(arr[i]-last_install >= mid)
                {
                    count++;
                    last_install = arr[i];
                }
                if(arr[i]-arr[i-1] < mid)
                {

                }
            }
            if( count > c)
            {
                low = mid + 1;
            }
            else if( count < c)
            {
                high = mid -1;
            }
            else if( count == c)
            {
                result = mid;
                low = mid +1;
            }
        } 
        System.out.println(high);
    }
}
