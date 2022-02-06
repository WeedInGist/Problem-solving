package Algo_study.Greedy;
import java.util.Scanner;
import java.util.Arrays;

class Boj_11399{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0 ; i < N; i++)
        {
            sum += arr[N-1-i]*(i+1);
        }
        System.out.println(sum);
    }
}