package Algo_study.Dynamic_Programming;

import java.util.Scanner;

public class Boj_1904 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        if(n == 1)
        {
            System.out.println(1);
            return;
        }
        d[1] = 1;
        d[2] = 2;
        for(int i = 3; i <= n; i++)
        {
            d[i] = (d[i-1]+ d[i-2])%15746;
        }
        System.out.println(d[n]);
    }
}
