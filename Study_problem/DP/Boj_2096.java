package Algo_study.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2096 {
    static int[] directions = {-1,0,1};
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n+1][3];
        for(int i = 1 ; i < n+1; i++)
        {
            for(int j = 0 ; j < 3; j++)
            {
                map[i][j] = sc.nextInt();
            }
        }
        int[][] d = new int[n+1][3];
        for(int i = 1; i < n+1; i++)
        {
           Arrays.fill(d[i], Integer.MIN_VALUE);
        }
        d[1][0] = map[1][0];
        d[1][1] = map[1][1];
        d[1][2] = map[1][2];
        for(int i = 2; i <=n; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                for(int k = 0; k < 3; k++)
                {
                    int next_c = j + directions[k];
                    if(next_c >= 0 && next_c < 3)
                    {
                        d[i][j] = Math.max(d[i][j], d[i-1][next_c]+map[i][j]);
                    }
                }
 
            }
        }
        // for(int i = 1; i < n+1; i++)
        // {
        //     for(int j = 0; j < 3; j++)
        //     {
        //         System.out.print(d[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int max = Math.max(d[n][0], d[n][1]);
        max = Math.max(max, d[n][2]);
        for(int i = 1; i < n+1; i++)
        {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }
        d[1][0] = map[1][0];
        d[1][1] = map[1][1];
        d[1][2] = map[1][2];

        for(int i = 2; i <=n; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                for(int k = 0; k < 3; k++)
                {
                    int next_c = j + directions[k];
                    if(next_c >= 0 && next_c < 3)
                    {
                        d[i][j] = Math.min(d[i][j], d[i-1][next_c]+map[i][j]);
                    }
                }

            }
        }
        int min = Math.min(d[n][0], d[n][1]);
        min = Math.min(min, d[n][2]);
        // for(int i = 1; i < n+1; i++)
        // {
        //     for(int j = 0; j < 3; j++)
        //     {
        //         System.out.print(d[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        System.out.println(max+" "+min);
    }
}
