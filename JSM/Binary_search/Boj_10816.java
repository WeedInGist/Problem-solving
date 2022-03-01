package Algo_study.Binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_10816  {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[(int)n];
        String[] s = br.readLine().split(" "); 
        for(int i = 0; i < n; i++)
        {
            arr[i] = Long.parseLong(s[i]);
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        long[] temp = new long[(int)m];
        int upper_bound = -1;
        int lower_bound = -1;
        s = br.readLine().split(" ");
        for(int i = 0 ; i < m ; i++)
        {
            temp[i] = Long.parseLong(s[i]);
        }
        for(int i = 0 ; i < m; i++)
        {
            long target = temp[i];
            
            int left = 0;
            int right = n-1;
            // 상한인가 하한인가?
            // 하한임.
            while(left <= right)
            {
                int mid = (left + right)/2;
                if(arr[mid] < target)
                {
                    left = mid + 1;
                }
                else if(arr[mid] >= target)
                {
                    right = mid -1;
                }
            }
            lower_bound = left;
            left = 0 ;
            right = n - 1;
            while(left <= right)
            {
                int mid = (left + right)/2;
                if(arr[mid] <= target)
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid -1;
                }
            }
            upper_bound = right;
            sb.append((upper_bound-lower_bound+1)+" ");
        }
        System.out.println(sb);
        
        
    }
}
