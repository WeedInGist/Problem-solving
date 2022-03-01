package Algo_study.Search;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_6808_조성민 {
    
    public static boolean[] visited;
    public static int[] arr;
    public static int p1 = 0;
    public static int p2 = 0;
    public static int p3 = 0;
    public static ArrayList<Integer> temp = new ArrayList<>();
    public static ArrayList<Integer> arr1;
    public static void Game(boolean[] visited, int choice)
    {
        if(choice == 0)
        {
            int p1_sum = 0;
            int p2_sum = 0;
            for(int i=0; i < 9 ; i++)
            {
                int a = arr1.get(i);
                int b = temp.get(i);
                // System.out.println("뽑은 숫자는 "+a+" "+b);
                if(a>b)
                {
                    p1_sum += a+b;
                }
                else
                    p2_sum += a+b;
            }
            if(p1_sum > p2_sum)
            {
                p1++;
            }
            if(p1_sum < p2_sum)
            {
                p2++;
            }
            if(p1_sum == p2_sum)
            {
                p3++;
            }
            return;
        }
        for(int i=1; i<=18; i++)
        {
            if(visited[i] == true)
            {
                continue;
            }
            visited[i] = true;
            temp.add(i);
            Game(visited, choice-1);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int i=1; i<= test_case; i++)
        {  
            p1 = 0;
            p2 = 0;
            p3 = 0;
            arr1 = new ArrayList<>();
            visited = new boolean[19];
            for(int j =1; j<=9; j++)
            {
                int a = sc.nextInt();
                arr1.add(a);
                visited[a] = true;
            }

            Game(visited, 9);
            System.out.print("#"+i+" ");
            System.out.println(p1+" "+p2);
        }
    }
}
