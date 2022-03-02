package Algo_study.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2293 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }    
        Arrays.sort(arr);
        int[] d = new int[k+1];
        d[0] = 1;
        // for(int i =0 ; i < n; i++)
        // {
        //     d[arr[i]] = 1;
        // }
        for(int i = 0; i < n; i++)
        {
            for(int j = arr[i]; j <= k; j++)
            {
                d[j] += d[j-arr[i]];
            }
        }
        System.out.print(d[n]);

    }
}
