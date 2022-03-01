package Algo_study.Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cheese
{
    int x,y;
    Cheese(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Boj_2638 {
    static int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visited;
    static Queue<Cheese> ans = new LinkedList<Cheese>();
    static Queue<Cheese> queue = new LinkedList<Cheese>();
    static int BFS(int[][] map, int row, int col)
    {
        if(visited[row][col] == true || map[row][col] == 0 || map[row][col] == 2)
        {
            return 0;
        }
        visited[row][col] = true;
        queue.add(new Cheese(row, col));
        while(queue.isEmpty() == false)
        {
            Cheese now = queue.poll();
            int count =0;
            for(int i = 0 ; i < 4; i++)
            {
                int next_r = now.x + directions[i][0];
                int next_c = now.y + directions[i][1];
                if(next_r >=0 && next_r < map.length && next_c >= 0 && next_c < map[0].length)
                {
                    if(map[next_r][next_c] == 2)
                        count++;
                    else if(visited[next_r][next_c] == false)
                    {
                        visited[next_r][next_c] = true;
                        queue.add(new Cheese(next_r, next_c));

                    }
                }
            }
            if(count >= 2)
            {
                ans.add(now);
            }
        }
        if(ans.isEmpty() == true)
        {
            return 0;
        }
        while(ans.isEmpty() == false)
        {
            Cheese now = ans.poll();
            map[now.x][now.y] = 2;
        }
        return 1;
    }
    public static void DFS_cheese(int[][] map, int row, int col)
    {
        if(visited[row][col] == true)
        {
            return;
        }
        else
        {
            visited[row][col] = true;
            map[row][col] = 2;
            for(int i = 0 ; i < 4; i++)
            {
                int next_r = row + directions[i][0];
                int next_c = col + directions[i][1];
                if(next_r >=0 && next_r < map.length && next_c >= 0 && next_c < map[0].length)
                {
                    // 필요 없지만
                    if(visited[next_r][next_c] == false)
                    {
                        if(map[next_r][next_c] == 0 || map[next_r][next_c] == 2)
                        {
                            DFS_cheese(map, next_r, next_c);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] map = new int[row][col];
        for(int i = 0; i < row; i++)
        {
            for(int j = 0 ; j < col ; j++)
            {
                map[i][j] = sc.nextInt();
            }
        }
        int time = 0;
        visited = new boolean[row][col];
        while(true)
        {
            int possible = 0;
            for(int i = 0; i < map.length; i++)
            {
                for(int j = 0; j < map[0].length ; j++)
                {
                    visited[i][j] = false;
                }
            }
            DFS_cheese(map,0,0);
            for(int i = 0; i < map.length; i++)
            {
                for(int j = 0; j < map[0].length ; j++)
                {
                    visited[i][j] = false;
                }
            }
            for(int i = 0; i < row; i++)
            {
                for(int j = 0; j < col ; j++)
                {
                    possible += BFS(map, i , j);
                }
            }
            // for(int i = 0; i < map.length; i++)
            // {
            //     for(int j = 0; j < map[0].length ; j++)
            //     {
            //         System.out.print(map[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            if(possible > 0)
            {
                time++;
            }
            else
                break;
        }
        System.out.println(time);
    }
}
