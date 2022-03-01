package Algo_study.Binary_search;

import java.util.Scanner;

public class Boj_1072 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        long z = 100*y/x;
        long low = 1;
        long high = x;
        long result = -1;
        while(low <= high)
        {
            long mid = (low+high)/2;
            if( z != (y+mid)*100/(x+mid))
            {
                result = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            } 
        }
        System.out.println(result);
    }
}
