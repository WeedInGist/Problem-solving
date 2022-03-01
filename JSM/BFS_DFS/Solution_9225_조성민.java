package Algo_study.Search;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_9225_조성민 {

    static int max = 0;
    static int weight_max;
    static int[] snacks;
    static ArrayList<Integer> ans= new ArrayList<>();
    public static void combination(int index, int n)
    {
        if(n ==0)
        {
            int temp = snacks[ans.get(0)]+snacks[ans.get(1)];
            if(temp>max && temp <= weight_max)
            {
                max = temp;
            }
            return;
        }
        for(int i = index+1; i< snacks.length; i++)
        {   
            ans.add(i);
            combination(i, n-1);
            ans.remove(ans.get(ans.size()-1));
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1 ; i <= T; i++)
        {
            max = 0;
            ans.clear();
            int snack_num = sc.nextInt();
            weight_max = sc.nextInt();
            snacks = new int[snack_num];
            for(int j = 0; j < snack_num ; j++)
            {
                snacks[j] = sc.nextInt();
            }
            combination(-1, 2);
            if(max == 0)
                System.out.println("#"+i+" "+-1);
            else
                System.out.println("#"+i+" "+max);
        }

    }
}
