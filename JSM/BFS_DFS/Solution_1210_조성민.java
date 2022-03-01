package Algo_study.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point
{
    int x,y;
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class Solution_1210_조성민 {

    static int[][] directions = {{0,-1},{0,1},{-1,0}};
    static boolean[][] visited;
    static int Find(int x, int y, int[][] map)
    {

        Queue<Point> queue = new LinkedList<Point>();
        int cur_r = x;
        int cur_c = y;
        queue.add(new Point(cur_r,cur_c));
        while(queue.isEmpty() == false)
        {
            // System.out.println(queue.size());
            Point a = queue.poll();
            // System.out.println(a.x+" "+a.y);
            if(a.x == 0)
            {
                return a.y;
            }
            for(int i = 0; i <3; i++)
            {
                int next_r = a.x + directions[i][0];
                int next_c = a.y + directions[i][1];
                if(next_r>=0 && next_r <100 && next_c >=0 && next_c < 100)
                {
                    if(map[next_r][next_c] == 1 && visited[next_r][next_c] == false)
                    {
                        visited[next_r][next_c] = true;
                        queue.add(new Point(next_r, next_c));
                        break;
                    }
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        for(int i = 1; i<= 10 ; i++)
        {
            br.readLine();
            int[][] ladder = new int[100][100];
            visited = new boolean[100][100];
            int arrival = -1;
            for(int j = 0; j < 100; j++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < 100; k++)
                {
                    int temp = Integer.parseInt(st.nextToken());
                    ladder[j][k] = temp;
                    if(temp==2)
                    {
                        arrival = k;
                    } 
                }
            }
            System.out.print("#"+i+" ");
            System.out.println(Find(99,arrival,ladder));
        }
    }
}
