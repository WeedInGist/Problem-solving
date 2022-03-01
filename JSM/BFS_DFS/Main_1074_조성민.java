package Algo_study.Search;

import java.util.Scanner;

public class Main_1074_조성민 {
    static void z_function(int[][] map, int row, int col, int size)
    {
        if(size == 2)
        {
            map[row][col] = count++;
            map[row][col+1] = count++;
            map[row+1][col] = count++;
            map[row+1][col+1] = count++;
            return;
        }
        z_function(map, row, col, size/2);
        z_function(map, row, col+size/2, size/2);
        z_function(map, row+size/2, col, size/2);
        z_function(map, row+size/2, col+size/2, size/2);
        
    }
    static void z_function2(int row, int col, int size, int r, int c)
    {
        if(size == 2)
        {
            int[][] ma = new int[2][2];
            ma[0][0]= count++;
            ma[0][1]= count++;
            ma[1][0]= count++;
            ma[1][1]= count++;
            System.out.println(ma[r][c]);
            return;
        }
        if(size/2 >r && size/2 > c)
        {
            z_function2(row, col, size/2, r, c);

        }
        else if(c >= size/2 && r < size/2)
        {
            count += size*size/4;
            z_function2(row, col+size/2, size/2, r, c-size/2);
        }
        else if(r>=size/2 && c < size/2)
        {
            count += size*size/4*2;
            z_function2(row+size/2, col, size/2, r-size/2, c);
        }
        else if(r>=size/2 && c >=size/2)
        {
            count += size*size/4*3;
            z_function2(row+size/2, col+size/2, size/2, r-size/2, c-size/2);
        }
        
    }
    static int n,r,c;
    static int count = 0;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        // int[][] map = new int[1<<n][1<<n];
        // int col = 1<<n;
        int size = 1<<n;
        z_function2(0, 0, size, r,c);
        // for(int i = 0; i < map.length; i++)
        // {
        //     for(int j =0; j < map[0].length; j++)
        //     {
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.print(map[r][c]);
    }
}
