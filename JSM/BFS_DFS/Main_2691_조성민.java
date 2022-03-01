package Algo_study.Search;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_2691_조성민 {
    public static ArrayList<Integer> ans = new ArrayList<>();
    public static int[] t1,t2;
    static int min = Integer.MAX_VALUE;
    public static void choice(int chance, int index, int size)
    {
        if(chance == 0)
        {
            int t1_sum = 1;
            int t2_sum = 0;
            for(int i : ans)
            {
                t1_sum *= t1[i];
                t2_sum += t2[i];
            }
            if(Math.abs(t1_sum-t2_sum) < min)
            {
                min = Math.abs(t1_sum-t2_sum);
            }
            return;
        }
        for(int i = index+1; i < size; i++)
        {
            ans.add(i);
            choice(chance-1, i, size);
            ans.remove(ans.size()-1);
        }

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        t1 = new int[size];
        t2 = new int[size];
        for(int i = 0; i < size; i++)
        {
            t1[i] = sc.nextInt();
            t2[i] = sc.nextInt();
        }
        for(int i= 1; i <=size; i++)
        {
            choice(i, -1, size);
        }
        System.out.println(min);
    }
}
