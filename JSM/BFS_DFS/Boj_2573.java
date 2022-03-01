package Algo_study.Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Ice
{
    int x,y;
    Ice(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class Boj_2573 {
    static boolean[][] visited;
    static int group = 0;
    public static void BFS(int[][] map, int row, int col)
    {
        if(visited[row][col] == true)
        {
            return;
        }
        else if(map[row][col] != 0)
        {
            group++;
            visited[row][col] = true;
            Queue<Ice> queue = new LinkedList<>();
            queue.add(new Ice(row,col));
            while(queue.isEmpty() == false)
            {
                Ice now = queue.poll();
                for(int k = 0; k<4; k++)
                {
                    int next_r = now.x + directions[k][0];
                    int next_c = now.y + directions[k][1];
                    if(next_r >=0 && next_r < map.length && next_c >=0 && next_c < map[0].length)
                    {
                        if(map[next_r][next_c] != 0)
                        {
                            if(visited[next_r][next_c] == false)
                            {
                                visited[next_r][next_c] = true;
                                queue.add(new Ice(next_r, next_c));
                            }
                        }
                            
                    }
                }
            }
        }
    }
    static int[][] directions = {{-1,0},{0,1},{0,-1},{1,0}};
    public static int[][] melting(int[][] map)
    {
        int[][] temp = new int[map.length][map[0].length];
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[0].length; j++)
            {
                temp[i][j] = map[i][j];
                if(map[i][j] != 0)
                {
                    for(int k = 0; k < 4; k++)
                    {
                        int next_r = i + directions[k][0];
                        int next_c = j + directions[k][1];
                        if(next_r >=0 && next_r < map.length && next_c >=0 && next_c < map[0].length)
                        {
                            if(map[next_r][next_c] == 0)
                            {
                                temp[i][j] -= 1;
                            }
                        }
                    }
                }
                if(temp[i][j] < 0)
                 temp[i][j] = 0;
            }
        }
        boolean empty = true;
    Loop1:for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[0].length; j++)
            {
                if(temp[i][j] != 0)
                {
                    empty = false;
                    break Loop1;
                }
            }
            // System.out.println();
        }
        if(empty == false)
            return temp;
        else
            return null;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] map = new int[row][col];
        for(int i = 0; i < row ; i++)
        {
            for(int j = 0; j < col; j++)
            {
                map[i][j] = sc.nextInt();
            }
        }
        int time = 0;
        while(true)
        {
            // System.out.println("여기냐?");
            group = 0;
            time++;
            visited = new boolean[row][col];
            map = melting(map);
            // for(int i = 0; i<row; i++)
            // {
            //     for(int j = 0 ; j < col ; j++)
            //     {
            //         System.out.print(map[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            if(map == null)
            {
                System.out.println(0);
                return;
            }
            for(int i = 0; i<row; i++)
            {
                for(int j = 0 ; j < col ; j++)
                {
                    BFS(map,i,j);
                }
            }
            if(group >1)
            {
                break;
            }
        }
        System.out.println(time);
    }
}
