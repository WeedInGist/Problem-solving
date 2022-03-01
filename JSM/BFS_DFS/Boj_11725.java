package Algo_study.Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class From_who implements Comparable<From_who>
{
    int index;
    int parent;
    From_who(int index, int parent)
    {
        this.index = index;
        this.parent = parent;
    }

    public int compareTo(From_who a)
    {
        return this.index - a.index;
    }
    public String toString()
    {
        return ""+this.parent;
    }
}

public class Boj_11725 {
    static boolean[] visited;
    static ArrayList<From_who> ans = new ArrayList<>();
    
    static void BFS(ArrayList<ArrayList<Integer>> map)
    {
        Queue<From_who> queue = new LinkedList();
        visited[1] = true;
        queue.add(new From_who(1, 1));
        while(queue.isEmpty() == false)
        {
            From_who now = queue.poll();
            for(int i : map.get(now.index))
            {
                if(visited[i] == false)
                {
                    visited[i] = true;
                    queue.add(new From_who(i, now.index));
                    ans.add(new From_who(i, now.index));
                }
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i <= size; i++)
        {
            map.add(new ArrayList<Integer>());
        }
        for(int i =1; i < size ; i++)
        {
            int row = sc.nextInt();
            int col = sc.nextInt();
            map.get(row).add(col);
            map.get(col).add(row);
        }
        visited = new boolean[size+1];
        BFS(map);
        Collections.sort(ans);
        for(From_who a : ans)
        {
            System.out.println(a+" ");
        }
    }
}
