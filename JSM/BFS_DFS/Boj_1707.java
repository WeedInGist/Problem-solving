package Algo_study.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Node
{
    int index;
    int property;
    Node(int x, int y)
    {
        this.index = x;
        this.property = y;
    }
}

public class Boj_1707 {
    static boolean[] visited;
    static boolean ans = true;
    static Queue<Node> queue = new LinkedList<Node>();
    static void BFS(LinkedList<LinkedList<Node>> map, int index)
    {
        if(visited[index] == true)
        {
            return;
        }
        // group++;
        // if(group >= 3)
        // {
        //     System.out.println("NO");
        // }
        visited[index] = true;
        queue.add(new Node(index, 0));
        while(queue.isEmpty() == false)
        {
            Node a = queue.poll();
            System.out.println(a.index+" "+a.property);
            for(Node b : map.get(a.index))
            {
                if(visited[b.index] == false)
                {
                    visited[b.index] = true;
                    if(a.property == 1)
                    {
                        queue.add(new Node(b.index, 0));
                        b.property = 0;
                    }
                    else
                    {
                        queue.add(new Node(b.index, 1));
                        b.property = 1;
                    }
                }
                if(b.index ==3)
                {
                    
                    System.out.println("씨발"+" "+b.index+" "+b.property);
                }
                if(b.property == a.property)
                {
                    ans = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < t ; i++)
        {
            queue.clear();
            ans = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int edge_num = Integer.parseInt(st.nextToken());
            LinkedList<LinkedList<Node>> map = new LinkedList<>();
            visited = new boolean[size];
            
            for(int z = 0; z < size; z++)
            {
                map.add(new LinkedList<Node>());
            }
            
            for(int j = 0; j < edge_num; j++)
            {
                StringTokenizer str = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(str.nextToken())-1;
                int col = Integer.parseInt(str.nextToken())-1;
                map.get(row).add(new Node(col, -1));
                map.get(col).add(new Node(row, -1));
            }
            
            int number = 0;
            // for(int j = 0; j < size; j++)
            // {
            //     if(number == 2)
            //     {
            //         break;
            //     }
            //     if(visited[j] == false)
            //     {
            //         BFS(map,j);
            //         number++;
            //     }
            // }
            BFS(map,0);
            if(ans)
            {
                System.out.println("YES");
            }
            else
                System.out.println("NO");
            for(int k =0;k < size ; k++)
            {
                // System.out.println(visited[k]);
            }
        }

    }
}
