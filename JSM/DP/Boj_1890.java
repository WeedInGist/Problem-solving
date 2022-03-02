package Algo_study.Dynamic_Programming;

import java.util.Scanner;

public class Boj_1890 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                map[i][j] = sc.nextInt();
            }
        }
        long[][] d = new long[n][n];
        d[0][0] = 1;
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0 ; j < n; j++)
            { 
                //&& i != n-1 && j != n-1
                if(d[i][j] != 0)
                {
                    if(i == n-1 && j == n-1)
                    {
                        continue;
                    }
                    int next_r = i + map[i][j];
                    int next_c = j + map[i][j];
                    if(next_r < n)
                    {
                        d[next_r][j] += d[i][j];
                    }
                    if(next_c < n)
                    {
                        d[i][next_c] += d[i][j];
                    }
                    // System.out.println(i+" "+j+" "+d[n-1][n-1]);
                }
            }
        }
        // for(int i = 0 ; i < n; i++)
        // {
        //     for(int j = 0 ; j < n; j++)
        //     {
        //         System.out.print(d[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        System.out.println(d[n-1][n-1]);
    }
}
