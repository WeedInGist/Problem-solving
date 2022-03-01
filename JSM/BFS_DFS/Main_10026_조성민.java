package Algo_study.Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Char_point
{
    int row,col;
    char c;
    Char_point(int row, int col, char c)
    {
        this.row = row;
        this.col = col;
        this.c = c;
    }
    
}

public class Main_10026_조성민 {

    static int[][] directions = {{0,1},{0,-1}, {1,0},{-1,0}};
    static boolean[][] visited;
    static int weird_group = 0;
    static int normal_group = 0;
    static void Weird_Eye_BFS(int row, int col, char[][] map)
    {
        if(visited[row][col] == true)
        {
            return;
        }
        Queue<Char_point> queue = new LinkedList<>();
        visited[row][col] = true;
        weird_group++;
        queue.add(new Char_point(row,col, map[row][col]));
        while(queue.isEmpty() == false)
        {
            Char_point a = queue.poll();
            for(int i =0; i<4; i++)
            {
                int next_r = a.row + directions[i][0];
                int next_c = a.col + directions[i][1];
                if(next_r >=0 && next_r< map.length && next_c>=0 && next_c < map[0].length)
                {
                    if(visited[next_r][next_c] == false)
                    {
                        if(a.c == 'R' || a.c == 'G')
                        {
                           if(map[next_r][next_c] == 'R' || map[next_r][next_c] == 'G')
                           {
                               visited[next_r][next_c] = true;
                               queue.add(new Char_point(next_r, next_c, map[next_r][next_c]));
                           } 
                        }
                        else if(a.c =='B')
                        {
                            if(map[next_r][next_c] == 'B')
                            {
                               visited[next_r][next_c] = true;
                               queue.add(new Char_point(next_r, next_c, map[next_r][next_c]));
                            } 
                        }
                    }
                }
            }
        }
    }
    static void Normal_Eye_BFS(int row, int col, char[][] map)
    {
        if(visited[row][col] == true)
        {
            return;
        }
        Queue<Char_point> queue = new LinkedList<>();
        visited[row][col] = true;
        normal_group++;
        queue.add(new Char_point(row,col, map[row][col]));
        while(queue.isEmpty() == false)
        {
            Char_point a = queue.poll();
            for(int i =0; i<4; i++)
            {
                int next_r = a.row + directions[i][0];
                int next_c = a.col + directions[i][1];
                if(next_r >=0 && next_r< map.length && next_c>=0 && next_c < map[0].length)
                {
                    if(visited[next_r][next_c] == false)
                    {
                        if(a.c ==  map[next_r][next_c])
                        {
                           visited[next_r][next_c] = true;
                           queue.add(new Char_point(next_r, next_c, map[next_r][next_c]));
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        char[][] map = new char[size][size];
        visited = new boolean[size][size];
        for(int i = 0 ; i < size; i++)
        {
            map[i]= sc.nextLine().toCharArray();
            // System.out.println(map[i]);
        }

        for(int i =0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                Weird_Eye_BFS(i, j, map);
            }
        }
        visited = new boolean[size][size];
        for(int i =0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                Normal_Eye_BFS(i, j, map);
            }
        }
        System.out.print(normal_group+" "+weird_group);
    }
}
