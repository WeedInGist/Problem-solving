package Algo_study.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1049 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] sixpack = new int[M];
        int[] onepack = new int[M];
        for(int i = 0 ; i < M ; i++)
        {
            sixpack[i] = sc.nextInt();
            onepack[i] = sc.nextInt();
        }
        int price = 0;
        int price2 = 0;
        Arrays.sort(sixpack);
        Arrays.sort(onepack);
        if((double)sixpack[0]/6 > onepack[0])
        {    
            System.out.println(N*onepack[0]);
            return;
        }
        else
        {
            price = (N/6)*sixpack[0] + ( N % 6 ) * onepack[0]; 
            price2 = (N/6+1) * sixpack[0];
        }
        if(price > price2)
            System.out.println(price2);
        else
            System.out.println(price);






    }
}
