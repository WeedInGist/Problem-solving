package Algo_study.Binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2470 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        long[] arr = new long[n];
        for(int i = 0 ; i < n; i++)
        {
            arr[i] = Long.parseLong(s[i]);
        }
        Arrays.sort(arr);
        int low = 0;
        int high = n-1;
        while(low <= high)
        {
            long mid = arr[(int)low] + arr[(int)high];
            if(mid > 0)
            {
                high /= 2;
            }
            if( mid < 0)
            {
                low *= 2;
            }
        }

    }
}
