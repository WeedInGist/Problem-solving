package Algo_study.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Node1 implements Comparable<Node1>
{
    int row, col;
    int value;
    int step;
    Node1(int row, int col, int value, int step)
    {
        this.row = row;
        this.col = col;
        this.value = value;
        this.step = step;
    }
    public int compareTo(Node1 a)
    {
        return this.value - a.value;
    }
}

public class Solution_1861_조성민 {
    static Queue<Node1> queue = new LinkedList<>();
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    static int max = 0;
    static ArrayList<Node1> ans = new ArrayList<>();
    
    static void BFS(int[][] map, int row, int col)
    {
        if(true)
        {
            queue.add(new Node1(row,col, map[row][col],1));
            while(queue.isEmpty() == false)
            {
                Node1 now = queue.poll();
                if(now.step >= max)
                {
                    max = now.step;
                    ans.add(new Node1(row,col,map[row][col], now.step));
                }
                for(int i = 0 ; i < 4 ; i++)
                {
                    int next_r = now.row + directions[i][0];
                    int next_c = now.col + directions[i][1];
                    if(next_r>=0 && next_r< map.length && next_c >=0 && next_c < map.length)
                    {
                        if(map[next_r][next_c] -now.value == 1)
                        {
                            queue.add(new Node1(next_r, next_c, map[next_r][next_c], now.step+1));
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= test ; i++)
        {
            int size = Integer.parseInt(br.readLine());
            queue.clear();
            ans.clear();
            max = 0;
            int[][] map = new int[size][size];
            for(int j =0 ; j < size ; j++)
            {
                String[] s =br.readLine().split(" ");
                for(int k = 0 ; k < size; k++)
                {
                    map[j][k] = Integer.parseInt(s[k]);
                }
            }
            for(int j =0 ; j < size ; j++)
            {
                for(int k = 0 ; k < size; k++)
                {
                    BFS(map,j,k);
                }
            }
           
            Collections.sort(ans);
            for(Node1 a : ans)
            {
                if(a.step == max)
                {
                    sb.append("#"+i+" "+a.value+" "+max).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
        }
}
