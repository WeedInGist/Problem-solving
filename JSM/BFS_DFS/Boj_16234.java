package Algo_study.Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

class Nation
{
    int row,col;
    Nation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}

public class Boj_16234 {
    public static boolean[][] visited;
    static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    static ArrayList<ArrayList<Nation>> ally_group = new ArrayList<>();
    public static boolean bfs(int[][] map, int row, int col, int min, int max)
    {
        if(visited[row][col] == true)
        {
            return false;
        }
        ArrayList<Nation> ally = new ArrayList<>();
        boolean once = false;
        visited[row][col] = true;
        Queue<Nation> queue = new LinkedList<>();
        queue.add(new Nation(row, col));
        int sum = 0;
        while(queue.isEmpty() == false)
        {
            // System.out.println("하이");
            Nation now = queue.poll();
            sum += map[now.row][now.col];
            ally.add(now);
            for(int i = 0 ; i < 4; i++)
            {
                int next_r = now.row + directions[i][0];
                int next_c = now.col + directions[i][1];
                if(next_r >=0 && next_r < map.length && next_c >= 0 && next_c < map.length)
                {
                    if(visited[next_r][next_c] == false)
                    {
                        // System.out.println("방문하는 곳 "+next_r+" "+next_c);
                        int diff =Math.abs(map[now.row][now.col] - map[next_r][next_c]);
                        if(min <= diff && diff <= max)
                        {
                            visited[next_r][next_c] = true;
                            queue.add(new Nation(next_r, next_c));
                            once = true;
                        }
                    }
                }
            }
        }
        if(once == true)
        {
            ally_group.add(ally);
        }
        return once;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                map[i][j] = sc.nextInt();
            }
        }
        int time = 0;
        while(true)
        {
            boolean once = false;
            visited = new boolean[map.length][map.length];
            for(int i = 0 ; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    once |= bfs(map, i, j, l, r);
                }
            }
            // System.out.println();
            // for(int i = 0 ; i < n; i++)
            // {
            //     for(int j = 0; j < n; j++)
            //     {
            //         System.out.print(map[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            if(once == true)
            {
                time++;
                for(ArrayList<Nation> ally: ally_group)
                {
                    int sum = 0;
                    for(Nation now : ally)
                    {
                        sum += map[now.row][now.col];
                    }
                    for(Nation now : ally)
                    {
                        map[now.row][now.col] = sum / ally.size();
                    }
                }
                ally_group.clear();
            }
            else
                break;
        }
        System.out.println(time);
    }
}
