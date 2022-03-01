package Algo_study.Search;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_3040_조성민 {
    public static ArrayList<Integer> ans = new ArrayList<>();
    public static int[] arr;
    public static void choice(int chance, int index)
    {
        if(chance == 0)
        {
            int sum = 0;
            for(int a : ans)
            {
                sum += arr[a];
            }
            if(sum == 100)
            {
                for(int a : ans)
                {
                    System.out.println(arr[a]);
                }
            }
        }
        for(int i = index+1; i < 9; i++)
        {
            ans.add(i);
            choice(chance-1, i);
            ans.remove(ans.size()-1);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        arr = new int[9];
        for(int i =0 ; i < 9 ; i++)
        {
            arr[i] = sc.nextInt();
        }
        choice(7, -1);
    }
}
