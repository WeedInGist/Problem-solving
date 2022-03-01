package Algo_study.Dynamic_Programming;

import java.util.Scanner;

public class Boj_2011 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray();
        if(s.length == 0)
        {
            System.out.println(0);
            return;
        }
        int[] temp = new int[s.length+1];
        for(int i = 1 ; i < temp.length; i++)
        {
            temp[i] = s[i-1]-'0';
        }
        int[] d = new int[temp.length];
        if(temp[1] == 0)
        {
            System.out.println(0);
            return;
        }
        if(d.length == 2)
        {
            System.out.print(1);
            return;
        }
    
        d[1] = 1;
        if(temp[2] == 0)
        {
            if(temp[1] >= 3)
            {
                System.out.println(0);
                return;
            }
            else
            {
                d[2] = 1;
            }
        }
        else
        {
            if(temp[1] == 1)
            {
                d[2] = 2;
            }
            else if(temp[1] == 2)
            {
                if(temp[2] <=6)
                {
                    d[2] = 2;
                }
                else 
                {
                    d[2] = 1;
                }
            }
            else if(temp[1] >= 3)
            {
                d[2] = 1;
            }
        }
        for(int i = 3; i < temp.length; i++)
        {
           if(temp[i] == 0)
           {
               if(temp[i-1] == 0 || temp[i-1] >= 3)
               {
                   System.out.println(0);
                   return;
               }
               else
               {
                    d[i] = d[i-2]%1000000;
               }
           }
           else
           {
               if(temp[i-1] == 1)
               {
                   d[i] = (d[i-1]+d[i-2]) %1000000;
               }
               else if(temp[i-1] == 2)
               {
                   if(temp[i] <=6)
                   {
                        d[i] = (d[i-1]+d[i-2]) %1000000;
                   }
                   else
                   {
                       d[i] = d[i-1]%1000000;
                   }
               }
               else if(temp[i-1] >= 3)
               {
                   d[i] = d[i-1]%1000000;
               }
               else if(temp[i-1] == 0)
               {
                   d[i] = d[i-1]%1000000;
               }
           }
        }
        // for(int i = 1; i < s.length+1; i++)
        {
            System.out.print(d[d.length-1]%1000000+" ");

        }
    }
}
