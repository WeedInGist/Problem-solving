package Algo_study.Backtracking;

import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Boj_1038 {
    static int count = -1;
    static int[] map;
    static int destination;
    static boolean find = false;
    public static void dfs(int index, int size)
    {
        if(find)
        {
            return;
        }
        for(int i = 0; i < index-1; i++)
        {
            if(map[i] <= map[i+1])
            {
                return;
            }
        }
        if(index == size)
        {
            count++;
            // System.out.print(count);
            // System.out.println();
            if(count == destination)
            {
                for(int a : map)
                {
                    System.out.print(a);
                }
                System.out.println();
                // System.out.println(count+" "+destination);
                // System.out.println("발견");
                find = true;
                // System.out.println();
            }
            return;
        }
        for(int i = 0 ; i < 10; i++)
        {
            // System.out.println("시발 뭔데 대체");
            map[index] = i;
            dfs(index+1, size);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        destination= sc.nextInt();
        for(int size = 1; size <= 10; size++)
        {
            map = new int[size];
            dfs(0,size);
            if(find)
            {
                // System.out.println(size+ "크기는");
                break;
            }
        }
        if(find == false)
        {
            System.out.println(-1);
            return;
        }
        // for(int a : map)
        // {
        //     System.out.print(a);
        // }
           
        
    }
}
