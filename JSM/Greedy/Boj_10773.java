package Algo_study.Greedy;

import java.util.Scanner;
import java.util.Stack;

public class Boj_10773 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int size = sc.nextInt();
        for(int i = 0 ; i < size; i++)
        {
            int temp = sc.nextInt();
            if(temp == 0)
            {
                stack.pop();
            }
            else
                stack.push(temp);
        }
        int sum = 0;
        while(stack.isEmpty() != true)
        {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
