package Algo_study.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1520 {
    public static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int count = 1;
    public static int dfs(int[][] map, int[][] d, int row, int col)
    {
        if(row == map.length-1 && col == map[0].length-1)
        {
            return 1;
        }
        if(d[row][col] != -1)
        {
            return d[row][col];
        }
        else
        {
            d[row][col] = 0;
            for(int i = 0 ; i < 4; i++)
            {
                int next_r = row + directions[i][0];
                int next_c = col + directions[i][1];
                if(next_r >=0 && next_r < map.length && next_c >= 0 && next_c < map[0].length)
                {
                    if(map[row][col] > map[next_r][next_c])
                    {
                        if(d[next_r][next_c] != -1)
                        {
                            // System.out.println("활용");
                            d[row][col] += d[next_r][next_c];
                        }
                        else
                        {
                            d[row][col] += dfs(map,d,next_r,next_c);
                        }
                    }
                }
            }
        }
        return d[row][col];
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int row = Integer.parseInt(s[0]);
        int col = Integer.parseInt(s[1]);
        int[][] map = new int[row][col];
        int[][] d = new int[row][col];
        for(int i = 0 ; i < row; i++)
        {
            s = br.readLine().split(" ");
            for(int j = 0; j < col; j++)
            {
                map[i][j] = Integer.parseInt(s[j]);
                d[i][j] = -1;
            }
        }
        int ans = dfs(map,d,0,0);
        // for(int i = 0 ; i < row; i++)
        // {
        //     for(int j = 0; j < col; j++)
        //     {
        //         System.out.print(d[i][j]+" ");
        //     }
        //     System.out.println();
        // }  
        System.out.println(ans);
    }
}
