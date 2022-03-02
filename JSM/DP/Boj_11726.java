package Algo_study.Dynamic_Programming;

import java.util.Scanner;

public class Boj_11726 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[1001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 3;
        for(int i = 4; i <= n ; i++)
        {
            d[i] = (d[i-1] + d[i-2]) % 10007;
        }
        System.out.println(d[n]);
    }
}
