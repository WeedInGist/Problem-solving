package Algo_study.Search;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Chamber
{
    int row,col;
    Chamber(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}

public class Main_3109_조성민 {
    static int[][] directions = {{1,1},{0,1},{-1,1}};
    static boolean[][] visited;
    static LinkedList<Chamber> visited_list = new LinkedList<Chamber>();
    public static int DFS(char[][] map, int row, int col)
    {
        if(map[row][col] == 'X' || visited[row][col] == true)
        {
            return 0;
        }
        // System.out.println("현재 내가 보고 있는 장소 "+row+" "+col);
        int arrive = 0;
        visited[row][col] = true;
        if(col == map[0].length-1)
        {
            // for(Chamber visited_chamber : visited_list)
            // {
            //     visited[visited_chamber.row][visited_chamber.col] = true;
            // }
            return 1;
        }

        for(int i = 0 ; i < 3; i++)
        {
            int next_r = row + directions[i][0];
            int next_c = col + directions[i][1];
            if(next_r >=0 && next_r < map.length && next_c >=0 && next_c < map[0].length)
            {
                if(visited[next_r][next_c] == false && map[next_r][next_c] == '.')
                {   
                    // Chamber a = new Chamber(next_r, next_c);
                    // visited_list.add(a);
                    // visited[next_r][next_c] = true;
                    arrive += DFS(map, next_r, next_c); 
                    // visited_list.removeLast();
                    if(arrive == 1)
                    {
                        return 1;
                    }
                }               
            }
        }
        return 0;

    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] map = new char[row][col];
        visited = new boolean[row][col];
        for(int i = 0 ; i < row; i++)
        {
            map[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        for(int i = row-1; i>=0; i--)
        {
            ans += DFS(map, i, 0);
        }
        System.out.print(ans);
        // System.out.println();
        // for(int i = 0 ; i < row; i++)
        // {
        //     for(int j = 0 ; j < col; j++)
        //     {
        //         System.out.print(visited[i][j]+" ");
        //     }
        //     System.out.println();
        // }


    }

}
