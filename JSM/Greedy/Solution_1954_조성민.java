package Algo_study.Greedy;

import java.util.Scanner;

public class Solution {
    static int start = 1;
    static int[][] arr;
    static int n;
    static void snail(int cur_r, int cur_c, int size)
    {
        if(size <= 0)
            return;
        for(int col = cur_c; col < cur_c+size; col++)
        {
            arr[cur_r][col] = start++;
        }
        for(int row = cur_r+1; row < cur_r+size; row++)
        {
            arr[row][cur_c+size-1] = start++;
        }
        for(int col = cur_c+size-2; col >= cur_c; col--)
        {
            arr[cur_r+size-1][col] = start++;
        }
        for(int row = cur_r+size-2; row > cur_r; row--)
        {
            arr[row][cur_c] = start++;
        }
        snail(cur_r+1, cur_c+1, size-2);   
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0 ; i < T; i++)
        {
            start =1;
            n = sc.nextInt();
            arr = new int[n][n];
            snail(0,0,n);
            System.out.println("#"+(i+1));
            for(int a=0; a<n; a++)
            {
                for(int b = 0; b<n ; b++)
                {
                    System.out.print(arr[a][b]+" ");
                }
                System.out.println();
            }

        }
    }
}
