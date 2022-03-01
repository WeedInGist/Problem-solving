package Algo_study.Binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1477 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n];
        int[] diff = new int[n+1];
        if(n != 0)
        {
            for(int i = 0; i < n; i++)
            {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for(int i=1; i< n; i++)
            {
                diff[i] = arr[i]-arr[i-1];
            }
            diff[0] = arr[0];
            diff[n] = l - arr[n-1];
        }
        if(n == 0)
        {
            diff[0] = l;
        }
        int low = 1;
        int high = l;
        int result = 0;
        while(low <= high)
        {
            // System.out.println(low+" "+high);
            int mid = (low + high)/2;
            int count = 0;
            for(int i = 0; i < n+1; i++)
            {
                if(diff[i] > mid)
                {
                    if(diff[i] % mid !=0)
                    {
                        count += (diff[i]/mid);
                    }
                    else
                    {
                        count += diff[i]/mid-1;
                    }
                }
            }
            if(count > m)
            {
                low = mid +1;
            }
            else if(count <= m)
            {
                high = mid-1;
            }
        }
        System.out.println(low);
    }
}
