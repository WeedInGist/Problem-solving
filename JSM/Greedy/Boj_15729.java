package Algo_study.Greedy;

import java.util.Scanner;

public class Boj_15729 {
    static int count = 0;
    static int[] arr;
    static void pushButton(int index)
    {
        count++;
        for(int i = index ; i < index+3; i++)
        {
            if(i <arr.length)
                if(arr[i] == 1)
                    arr[i] = 0;
                else
                    arr[i] = 1;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        int[] target = new int[N];
        for(int i = 0 ; i < N ; i++)
        {
            target[i] = sc.nextInt();
        }
        int index= 0;
        while(index < N)
        {
            if(target[index] != arr[index])
                pushButton(index);
            index++;
        }
        System.out.println(count);
    }
}
