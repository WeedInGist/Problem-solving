package Algo_study.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_2309_조성민 {
    
    static int[] arr;
    static ArrayList<Integer> stack = new ArrayList();
    static void combination(int index, int n)
    {
        if(n==0)
        {
            int sum = 0;
            for(int a: stack)
            {
                sum += a;
            }
            if(sum == 100)
            {
                Collections.sort(stack);
                for(int a: stack)
                {
                    System.out.println(a);
                }   
            }
            return;
        }
        for(int i = index+1; i < 9; i++)
        {
            stack.add(arr[i]);
            combination(i, n-1);
            stack.remove(stack.get(stack.size()-1));
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        arr = new int[9];
        Arrays.sort(arr);
        for(int i = 0; i < 9; i++)
        {
            arr[i] = sc.nextInt();
        }
        combination(-1, 7);
    }
}
