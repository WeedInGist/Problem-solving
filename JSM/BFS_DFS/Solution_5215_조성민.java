package Algo_study.Search;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_5215_조성민 {
    static boolean[] taste_visited;
    static boolean[] calories_visited;
    static int taste_max =0;
    static int calories_max ;
    static int[] taste;
    static int[] calories;
    static int size;
    static ArrayList<Integer> ans = new ArrayList();
    
    static void combination(int index, int n)
    {
        if(n ==0)
        {
            // System.out.println("조합 완성");
            int calorie_sum = 0;
            int taste_sum = 0;
            for(int i: ans)
            {
                // System.out.print(i+" ");
                calorie_sum += calories[i];
            }
            if(calorie_sum <= calories_max)
            {
                for(int i : ans)
                {
                    taste_sum += taste[i];
                }
                if(taste_sum >= taste_max)
                {
                    taste_max = taste_sum;
                }
            }
            return;
        }
        for(int i = index+1; i < size ; i++)
        {
          ans.add(i); 
          // visited[i]=true;
          combination(i, n-1); // combination(-1, 5) -> combination(0,4) ->  combination(1, 3) -> -> -> combination(4,0)
          // visited[i]=false;                       -> combination(1,4) -> combin
          ans.remove(ans.size()-1); 
        }
    }

    

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int z=0; z<T; z++)
        {
            taste_max = 0;
            size =sc.nextInt();
            calories_max = sc.nextInt();
            taste = new int [size];
            calories = new int[size];
            for(int i =0; i < size; i++)
            {
                taste[i] = sc.nextInt();
                calories[i] = sc.nextInt();
            }
            for(int i =size; i>0; i--)
            {
                ans.clear();
                // taste_visited = new boolean[n];
                combination(-1, i);
            }
            System.out.println("#"+(z+1)+" "+taste_max);
            // combination(-1,5);
        }
    }
}
