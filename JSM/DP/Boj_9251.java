package Algo_study.Dynamic_Programming;

import java.util.Scanner;

public class Boj_9251 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        char[] a = sc.nextLine().toCharArray();
        char[] b = sc.nextLine().toCharArray();
        int[][] d = new int[a.length+1][b.length+1];
        int max = 0;
        for(int i = 1; i < a.length + 1; i++)
        {
            for(int j = 1; j < b.length + 1; j++)
            {
                if(a[i-1] == b[j-1])
                {
                    d[i][j] = d[i-1][j-1] + 1;
                }
                else
                    d[i][j] = Math.max(d[i][j-1], d[i-1][j]);
                if(max < d[i][j])
                {
                    max = d[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
