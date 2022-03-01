package Algo_study.Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_4963 {

    static boolean[][] visited;
    static int group_count=0;
    static int[][] directions = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    static void BFS(int[][] map, int row, int col)
    {
        Queue<Point> queue = new LinkedList<>();
        if(visited[row][col] == true)
        {
            return;    
        }
        if(visited[row][col] == false && map[row][col] == 1)
        {
            // System.out.println("섬 체크 시작시 위치는 "+row+" "+col);
            group_count++;
            visited[row][col] = true;
            queue.add(new Point(row,col));
            while(queue.isEmpty() == false)
            {
                Point a = queue.poll();
                for(int i =0 ; i< 8; i++)
                {
                    int next_r = a.x + directions[i][0];
                    int next_c = a.y + directions[i][1];
                    if(next_c>=0 && next_r >=0 && next_c < map[0].length && next_r < map.length)
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

    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        int[][] map;
        Scanner sc= new Scanner(System.in);
        int index =1;
        while(true)
        {
            group_count = 0;
            int col = sc.nextInt();
            int row = sc.nextInt();
            if(col == 0 && row == 0)
            {
                System.out.println(sb);
                return;
            }
            map = new int[row][col];
            visited = new boolean[row][col];
            for(int i =0; i < row; i++)
            {
                for(int j = 0; j < col; j++)
                {
                    map[i][j] = sc.nextInt();
                }
            }
            // System.out.println(index+++"번째 맵");
            for(int i =0; i < row; i++)
            {
                for(int j = 0; j < col; j++)
                {
                    BFS(map,i,j);
                }
            }
            sb.append(group_count).append("\n");
        }
    }
}
