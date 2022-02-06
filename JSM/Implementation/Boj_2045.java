package Algo_study.Implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2045 {
    public static  void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        for(int i = 0 ; i < 3; i++)
        {
            for (int j = 0 ; j < 3 ; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] c1,c2,c3,d1,d2;
        c1 = new int[]{arr[0][0], arr[1][0], arr[2][0]};
        c2 = new int[]{arr[0][1], arr[1][1], arr[2][1]};
        c3 = new int[]{arr[0][2], arr[1][2], arr[2][2]};
        d1 = new int[]{arr[0][0], arr[1][1], arr[2][2]};
        d2 = new int[]{arr[0][2], arr[1][1], arr[2][0]};
        int complete = -1;
        int[][] list = new int[][]{arr[0],arr[1],arr[2],c1,c2,c3,d1,d2};
        boolean[] good = new boolean[8];
        Arrays.fill(good, true);
        for(int i = 0 ; i < 8; i++)
        {
            for(int j = 0 ; j < 3; j++)
            {
                if(list[i][j]==0)
                {
                    good[i]= false;
                    break;
                }
            }
        }
        for(int i = 0 ; i < 8; i++)
        {
            if (good[i]== true)
            {
                complete = list[i][0]+list[i][1]+list[i][2];
                // System.out.println(i);
                break;
            }
        }
        int zero = -1;
        if(complete == -1)
        {
            // System.out.println("시발");
            if(d1[0] == 0)
            {
                arr[0][0] = (arr[1][0]+arr[1][2]+arr[0][2]+arr[1][2] -(arr[1][0]+arr[2][0]))/2;
                arr[2][2] = arr[1][0]+arr[1][2]-arr[0][0];
                arr[1][1] = arr[1][0]+arr[2][0]-arr[2][2];
                for(int i = 0 ; i < 3; i++)
                {
                    for(int j = 0 ; j < 3; j++)
                    {
                        System.out.print(arr[i][j]+" ");
                    }
                    System.out.println();
                }
            return;
            }
            else
            {
                arr[0][2] = (arr[2][1]-arr[1][2]+arr[0][0]+arr[2][2])/2;
                arr[2][0] = arr[0][0]+arr[2][2]-arr[0][2];
                arr[1][1] = arr[1][2]+arr[2][2]-arr[2][0];
                for(int i = 0 ; i < 3; i++)
                {
                    for(int j = 0 ; j < 3; j++)
                    {
                        System.out.print(arr[i][j]+" ");
                    }
                    System.out.println();
                }
                return;
                }
            }
        else
        {
            // System.out.println(complete);

            for(int i = 0; i<3; i++)
            {
                int temp = complete;
                int zero_count = 0;
                int zero_index=-1;
                for(int j = 0; j < 3; j++)
                {
                    if(arr[i][j] == 0)
                    {
                        zero_count++;
                        zero_index=j;
                    }
                }
                if(zero_count == 1)
                {
                    int sum = 0;
                    for(int j = 0; j < 3 ; j++)
                    {
                        if(j != zero_index)
                        {
                            sum+=arr[i][j];
                        }
                    }
                    arr[i][zero_index]=temp-sum;
                }
            }
            for(int i = 0; i<3; i++)
            {
                int temp = complete;
                int zero_count = 0;
                int zero_index=-1;
                for(int j = 0; j < 3; j++)
                {
                    if(arr[j][i] == 0)
                    {
                        zero_count++;
                        zero_index=j;
                    }
                }
                if(zero_count == 1)
                {
                    int sum = 0;
                    for(int j = 0; j < 3 ; j++)
                    {
                        if(j != zero_index)
                        {
                            sum+=arr[j][i];
                        }
                    }
                    arr[zero_index][i]=temp-sum;
                }
            }
            for(int i = 0 ; i < 3; i++)
            {
                for(int j = 0 ; j < 3; j++)
                {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }   
    }
}
