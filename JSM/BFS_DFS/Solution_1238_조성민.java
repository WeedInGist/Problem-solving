package Algo_study.Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Crazy implements Comparable<Crazy>
{
    int number;
    int time;
    Crazy(int number, int time)
    {
        this.number = number;
        this.time = time;
    }
    public int compareTo(Crazy a)
    {
        return a.number - this.number;
    }
}
class Solution_1238_조성민
{
    public static PriorityQueue<Crazy> ans = new PriorityQueue<Crazy>();
    public static void BFS(int[][] map, boolean[] visited,int start)
    {
        int max = -1;
        Queue<Crazy> queue = new LinkedList<Crazy>();
        visited[start] = true;
        queue.add(new Crazy(start, 0));
        while(queue.isEmpty() == false)
        {
            Crazy now = queue.poll();
            if(now.time > max)
            {
                max = now.time;
                ans.clear();
            }
            if(max == now.time)
            {
                ans.add(now);
            }
            for(int i = 0; i < map[0].length; i++)
            {
                if(map[now.number][i] == 1 && visited[i] == false)
                {
                    visited[i] = true;
                    queue.add(new Crazy(i, now.time+1));
                }
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        for(int t = 1; t<= 10; t++)
        {
            int[][] map = new int[101][101];
            boolean[] visited = new boolean[101];
            int length = sc.nextInt();
            int start = sc.nextInt();
            for(int i = 0; i < length/2; i++)
            {
                map[sc.nextInt()][sc.nextInt()] = 1;
            }
            BFS(map, visited, start);
            System.out.println("#"+t+" "+ans.poll().number);
        }
    }
}