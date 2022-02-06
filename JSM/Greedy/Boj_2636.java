package Algo_study.Greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Point2{
    int row, col;
    Point2(int x, int y)
    {
        row = x;
        col = y;
    }
}


public class Boj_2636
{   
    static boolean ismelted()
    {
        for(int i = 0 ; i < row; i++)
        {
            for(int j = 0 ; j < col; j++)
            {
                if(map[i][j] == 1)
                {
                    return false;
                }
            }
        }
        return true;
    }
    static void show()
    {
        for(int i = 0 ; i < row; i++)
        {
            for(int j = 0 ; j < col; j++)
            {
                System.out.print(map[i][j]);

            }
            System.out.println();
        }
    }
    static void showOutside()
    {
        for(int i = 0 ; i < row; i++)
        {
            for(int j = 0 ; j < col; j++)
            {
                if(outside[i][j] == true)
                    System.out.print("1");
                else
                    System.out.print("0");

            }
            System.out.println();
        }
    }
    static void showVisited()
    {
        for(int i = 0 ; i < row; i++)
        {
            for(int j = 0 ; j < col; j++)
            {
                if(visited[i][j] == true)
                    System.out.print("1");
                else
                    System.out.print("0");

            }
            System.out.println();
        }
    }
    static int melting()
    {
        int count = 0;
        initialization(0,0);
        for(int i = 0; i < row; i++)
        {
            for(int j = 0 ; j < col; j++)
            {
                if(map[i][j] == 1)
                    for(int k = 0 ; k < 4 ;k++)
                    {
                            int next_r = i+dy[k];
                            int next_c = j+dx[k];
                            if(next_r >=0 && next_r < row && next_c >=0 && next_c < col)
                            {
                                if(outside[next_r][next_c] == true)
                                {
                                    map[i][j] = 0;
                                    count++;
                                    break;
                                }
                            }
                    }
            }
        }
        return count;
    }
    static int visit = 0;
    static boolean[][] visited;
    static void initialization(int row1, int col1)
    {
        // if(!(row1 >= 0 && row1 < row && col1 >=0 && col1 < col))
        //     return;
        if(map[row1][col1] == 1)
            return;
        if(visited[row1][col1] == false)
        {
                if(map[row1][col1] == 0)
                {   
                    for(int i = 0 ; i < 4; i++)
                    {
                        int next_r = row1+dy[i];
                        int next_c = col1+dx[i];
                        if(next_r < row && next_r >=0 && next_c < col && next_c>=0)
                        {
                            if(outside[next_r][next_c] == true)
                            outside[row1][col1] = true;
                        }
                    }
                }
                visited[row1][col1] = true;         
            }
            visit++;
        else
            return;
        for(int i = 0 ; i < 4; i++)
        {
            int next_r = row1+dy[i];
            int next_c = col1+dx[i];
            if(next_r < row && next_r >=0 && next_c < col && next_c>=0)
            {
                // System.out.println(next_r+" "+next_c);
                initialization(next_r, next_c);
            }   
        }
    }
    
    static int[][] map;
    static boolean[][] outside;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,-1,0,1};
    static int row;
    static int col;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        map = new int[row][col];
        outside = new boolean[row][col];
        visited = new boolean[row][col];
        outside[0][0] = true;
        // visited[0][0] = true;
        for(int i = 0 ; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                map[i][j] = sc.nextInt();
                // if(map[i][j] == 1)
                // {
                //     outside[i][j] = false;
                // }
            }
        }
        int count = 0;
        int ans = 0;
        while(ismelted() != true)
        {
            visited = new boolean[row][col];
            count++;
            ans = melting();
            // showOutside();
            // System.out.println("TLqkf");
        }
        // initialization(0, 0);
        // showOutside();
        System.out.println(count);
        System.out.println(ans);
    }
    
}