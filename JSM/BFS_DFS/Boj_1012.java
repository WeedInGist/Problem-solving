package Algo_study.Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point
{
    int x,y;
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Boj_1012
{
    static int[][] directions = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    //맵이 주어지고 시작 위치가 주어지면 시작 위치부터 한 그룹인 모든 노드들을 순회하며 그룹화함.
    static int group_count = 0;
    static boolean[][] visited;
    static void BFS(int[][] map, int row, int col)
    {
        if(visited[row][col] == true)
        {
            return;
        }
        else if(map[row][col] == 1)
        {
            group_count++;
            Queue<Point> queue = new LinkedList<Point>();
            visited[row][col] = true;
            queue.add(new Point(row,col));
            while(queue.isEmpty() == false)
            {
                Point a = queue.remove();
                for(int i = 0; i < 4; i++)
                {
                    int next_r = a.x + directions[i][0];
                    int next_c = a.y + directions[i][1];
                    if(next_r >=0 && next_r< map.length && next_c>=0 && next_c < map[0].length)
                    {
                        if(map[next_r][next_c] == 1 && visited[next_r][next_c] == false)
                        {
                            visited[next_r][next_c] = true;
                            queue.add(new Point(next_r, next_c));
                        }
                    }
                }
            }
        }
    }
    public static int DFS(int[][] map, int row, int col)
    {
        if(visited[row][col] == true)
        {
            return 0;
        }
        else if(map[row][col] == 1)
        {
            visited[row][col] = true;
            for(int i = 0; i < 4; i++)
            {
                int next_r = row + directions[i][0];
                int next_c = col + directions[i][1];
                if(next_r >=0 && next_r< map.length && next_c>=0 && next_c < map[0].length)
                {
                    if(map[next_r][next_c] == 1 && visited[next_r][next_c] == false)
                    {
                        // visited[next_r][next_c] = true;
                        DFS(map, next_r, next_c);
                    }
                }
            }
            return 1;
        }
        return 0;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i =1; i<= T; i++)
        {   
            group_count = 0;
            int height = sc.nextInt();
            int width = sc.nextInt();
            int[][] map = new int[height][width];
            visited = new boolean[height][width];
            int num = sc.nextInt();
            for(int j = 0; j < num ; j++)
            {
                int row = sc.nextInt();
                int col = sc.nextInt();
                map[row][col] = 1;
            }
            for(int k=0; k< height; k++)
            {
                for(int j = 0; j < width; j++)
                {
                    if(DFS(map, k, j) ==1)
                        group_count++;
                }
            }
            System.out.println(group_count);
        }
    }
}