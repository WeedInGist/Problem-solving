package Algo_study.Greedy;

import java.util.Scanner;

public class Greedy_no_2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int result = 1;
        String s = sc.nextLine();
        for(int i = 0 ; i < s.length(); i++)
        {
            int temp = s.charAt(i)-'0';
            if(temp != 0)
                result *= temp; 
        }
        System.out.println(result);
    }
}
