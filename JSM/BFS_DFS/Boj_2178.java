package Algo_study.Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Which
{
    int row, col;
    int step;
    Which(int row, int col, int step)
    {
        this.row = row;
        this.col = col;
        this.step = step;
    }
}

public class Boj_2178 {

    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visited;
    static void BFS(int[][] map)
    {
        Queue<Which> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new Which(0,0,1));
        while(queue.isEmpty() == false)
        {
            Which now = queue.poll();
            if(now.row == map.length-1 && now.col == map[0].length-1)
            {
                System.out.println(now.step);
            }
            for(int d = 0 ; d < 4; d++)
            {
                int next_r = now.row + directions[d][0];
                int next_c = now.col + directions[d][1];
                if(next_r >=0 && next_r < map.length && next_c >= 0 && next_c <map[0].length)
                {
                    if(visited[next_r][next_c] == false && map[next_r][next_c] == 1)
                    {
                        visited[next_r][next_c] = true;
                        queue.add(new Which(next_r,next_c, now.step+1));
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i < n; i++)
        {
            String s = sc.nextLine();
            for(int j = 0; j < m; j++)
            {
               map[i][j] = s.charAt(j)-'0'; 
            }
        }
        BFS(map);
        
    }
}
