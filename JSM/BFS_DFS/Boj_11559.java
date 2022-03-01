package Algo_study.Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    int x,y;
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Boj_11559 {
    static boolean[][] visited;
    static void falling(char[][] map)
    {
        for(int j = 5 ; j >= 0; j--)
        { 
            for(int i = 11 ; i >= 0; i--)
            {
                int k = i;
                if(map[i][j] != '.')
                {
                    while(true)
                    {
                        if(k+1 > 11 || map[k+1][j] != '.')
                        {
                            break;
                        }
                        else
                        {
                            k += 1;
                        }
                        
                    }
                    if(k != i)
                    {

                        map[k][j] = map[i][j];
                        map[i][j] = '.';
                    }
                }
            }
        }
        // for(int i = 0 ; i < 12; i++)
        // { 
        //     for(int j = 0 ; j < 6; j++)
        //     {
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }
    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static int BFS(char[][] map, int row, int col)
    {
        if(map[row][col] == '.' || visited[row][col] == true)
        {
            return 0;
        }
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> remove_list = new LinkedList<>();
        visited[row][col] = true;
        queue.add(new Point(row,col));
        while(queue.isEmpty() == false)
        {
            Point now = queue.poll();
            remove_list.add(now);
            for(int i = 0 ; i < 4; i++)
            {
                int next_r = now.x + directions[i][0];
                int next_c = now.y + directions[i][1];
                if(next_r >= 0 && next_r < map.length && next_c >=0 && next_c < map[0].length)
                {
                    if(visited[next_r][next_c] == false)
                    {
                        if(map[now.x][now.y] == map[next_r][next_c])
                        {
                            visited[next_r][next_c] = true;
                            queue.add(new Point(next_r,next_c));
                        }
                    }
                }
            }
        }
        if(remove_list.size() >= 4)
        {
            while(remove_list.isEmpty() == false)
            {
                Point remove = remove_list.poll();
                map[remove.x][remove.y] = '.';
            }
            return 1;
        }
        else
            return 0;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        char[][] map = new char[12][6];
        visited = new boolean[12][6];
        for(int i = 0 ; i < 12; i++)
        {
            map[i] = sc.nextLine().toCharArray();
        }
        int chain_boom = 0;
        while(true)
        {
            visited = new boolean[12][6];
            // falling(map);
            int boom = 0;
            for(int i = 0; i < 12; i++)
            {
                for(int j = 0 ; j < 6; j++)
                {
                    boom +=BFS(map,i,j);
                }
            }
            if(boom==0)
            {
                break;
            }
            if(boom > 0)
            {
                chain_boom++;
            }
            falling(map);
        }
        System.out.println(chain_boom);
    }
}