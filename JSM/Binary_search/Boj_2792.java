package Algo_study.Binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2792 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] jewel = new int[m];
        for(int i = 0; i < m; i++)
        {
            jewel[i] = sc.nextInt();

        }
        Arrays.sort(jewel);
        int low = 1;
        int high = jewel[m-1];
        int result = 1;
        while(low <= high)
        {
            int count = 0;
            int mid = (low+high)/2;
            for(int i = 0; i <m; i++)
            {
                if(jewel[i] % mid != 0)   
                    count = count + jewel[i]/mid + 1;
                else
                    count += jewel[i]/mid;
            }
            if(count > n)
            {
                low = mid+1;
            }
            else if(count <= n)
            {
                // result = mid;
                high = mid-1;
            }
            
        }
        System.out.print(low);
    }
}
