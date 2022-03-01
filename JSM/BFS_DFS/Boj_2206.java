package Algo_study.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Frontier
{
    int x,y;
    int chance = 1;
    int step = 1;
    Frontier(int row, int col, int chance, int step)
    {
        this.x = row;
        this.y = col;
        this.chance = chance;
        this.step = step;
    }
}


public class Boj_2206 
{   
    static int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] visited;

    static void BFS(int[][] map)
    {
        Queue<Frontier> queue = new LinkedList<Frontier>();
        visited[0][0] = -1;
        queue.add(new Frontier(0,0,1,1));
        while(queue.isEmpty() == false)
        {
            Frontier a = queue.poll();
            if(a.x == map.length-1 && a.y == map[0].length-1)
            {
                System.out.println(a.step);
                return;
            }
            for(int i = 0 ;i <4; i++)
            {
                int next_r = a.x + directions[i][0];
                int next_c = a.y + directions[i][1];
                if(next_c >=0 && next_c < map[0].length && next_r >=0 && next_r < map.length)
                {
                    if( visited[next_r][next_c] == -1)
                    {
                        if(map[next_r][next_c] == 1 && a.chance ==1)
                        {
                            visited[next_r][next_c] = 0;
                            queue.add(new Frontier(next_r, next_c, 0, a.step+1));
                        }
                        else if(map[next_r][next_c] == 0)
                        {
                            if(a.chance == 1)
                            {
                                visited[next_r][next_c] = 1;
                                queue.add(new Frontier(next_r, next_c, a.chance, a.step+1));
                            }
                            else
                            {
                                visited[next_r][next_c] = 0;
                                queue.add(new Frontier(next_r, next_c, a.chance, a.step+1));
                            }
                        }
                    }
                    else if(visited[next_r][next_c] == 0)
                    {
                        if(map[next_r][next_c] == 0)
                        {
                            if(a.chance == 1)
                            {
                                visited[next_r][next_c] =1;
                                queue.add(new Frontier(next_r,next_c, a.chance, a.step+1));
                            }
                        }
                    }
                }
            }
        }
        if(queue.isEmpty())
        {
            System.out.println(-1);
            return;
        }
        
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[2];
        input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        int[][] map = new int[row][col];
        visited = new int[row][col];
        for(int r = 0; r < row; r++)
        {
            Arrays.fill(visited[r], -1);

        }
        for(int i=0; i< row; i++)
        {
            String inputs = br.readLine();
            for(int j = 0; j < col; j++)
            {
                map[i][j] = inputs.charAt(j)-'0';
            }
        }
        BFS(map);

    }
}
