package Algo_study.Search;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import Algo_study.Greedy.test;

class Fish implements Comparable<Fish>
{
    int row, col;
    int size;
    int eat = 0;
    int step = 0;
    Fish(int row, int col, int size, int step)
    {
        this.row = row;
        this.col = col;
        this.size = size;
        this.step = step;
    }
    public int compareTo(Fish a)
    {
        if(this.step == a.step)
        {
            if(this.row == a.row)
            {
                return this.col - a.col;
            }
            return this.row - a.row;
        }
        return this.step - a.step;

    }
}



public class Boj_16236 {
    static int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};
    static boolean[][] visited;
    static PriorityQueue<Fish> eat_list = new PriorityQueue<>();
    public static int BFS(int[][] map, Fish shark)
    {
        visited = new boolean[map.length][map.length];
        // System.out.println("탐색을 시작할 때의 상어 위치 "+shark.row+" "+shark.col);
        Queue<Fish> queue = new LinkedList<>();
        queue.add(shark);
        visited[shark.row][shark.col] = true;
        while(queue.isEmpty() == false)
        {
            Fish now = queue.poll();
            if(now.size < shark.size && now.size != 0)
            {
                eat_list.add(now);
            }
            for(int i = 0; i < 4; i++)
            {
                // System.out.println(0);
                int next_r = now.row + directions[i][0];
                int next_c = now.col + directions[i][1];
                if(next_r<map.length && next_r >= 0 && next_c < map.length && next_c >= 0)
                {
                    // System.out.println(1);
                    if(visited[next_r][next_c] == false)
                    {
                        // System.out.println(2);
                        if(map[next_r][next_c] <= shark.size)
                        {
                            // System.out.println(3);
                            visited[next_r][next_c] = true;
                            // int step = Math.abs(shark.row-next_r)+ Math.abs(shark.col - next_c);
                            queue.add(new Fish(next_r,next_c,map[next_r][next_c], now.step+1));
                        }
                    }
                } 
            }
        }
        if(eat_list.isEmpty())
        {
            return 0;
        }
        else
        {
            Fish eat = eat_list.poll();
            shark.eat++;
            if(shark.eat == shark.size)
            {
                shark.size++;
                shark.eat = 0;
            }
            map[shark.row][shark.col] = 0;
            shark.row = eat.row;
            shark.col = eat.col;
            map[shark.row][shark.col] = 9;
            eat_list.clear();
            // System.out.println("이동한 위치 "+shark.row+" "+shark.col+" "+eat.step);
            return eat.step;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        Fish shark = new Fish(0, 0, 2, 0);
        for(int i = 0; i < n; i++)
        {
            for(int j =0 ; j < n; j++)
            {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9)
                {
                    shark.row = i;
                    shark.col = j;
                }
            }
        }
        // System.out.print(shark.row+" "+shark.col);
        int time = 0;
        visited= new boolean[n][n];
        while(true)
        {
            int temp = BFS(map, shark);
            // System.out.println("걸린 시간은 "+temp);
            // for(int i = 0; i < n; i++)
            // {
            //     for(int j = 0 ; j < n ; j++)
            //     {
            //         System.out.print(visited[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            if(temp != 0)
            {
                time += temp;
            }
            else
                break;
        }
        System.out.println(time);
        
    }
}
