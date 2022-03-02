package Algo_study.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_18353 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i =1; i < n+1; i++)
        {
            arr[i] = sc.nextInt();
        }
        int[] d = new int[n+1];
        d[1] = 1;
        Arrays.fill(d,1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(arr[i]<arr[j]){
                    d[i]=Math.max(d[i],d[j]+1);
                }
            }
        }
        Arrays.sort(d);
        System.out.println(n-d[n]);
    }
}
