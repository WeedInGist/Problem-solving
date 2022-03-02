package Algo_study.Dynamic_Programming;

import java.util.Scanner;

public class Boj_9095
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();

        for(int t = 1; t <= test_case; t++)
        {
            int n = sc.nextInt();
            int[] d = new int[12];
            d[0] = 0;
            d[1] = 1;
            d[2] = 2;
            d[3] = 4;
            for(int i = 4; i < n+1; i++)
            {
                d[i] = d[i-1] + d[i-2] + d[i-3];
            }
            System.out.println(d[n]);
        }        
    }
}