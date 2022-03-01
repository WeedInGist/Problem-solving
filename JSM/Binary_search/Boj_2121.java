package Algo_study.Binary_search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Point
{
    int x,y;
    Point(int x, int y)
    {
      
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object a)
    {
        if(a instanceof Point)
        {
            if(((Point)a).x == this.x && this.y == ((Point)a).y)
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public int hashCode()
    {
        return (String.valueOf(x)+String.valueOf(y)).hashCode();
    }
}

public class Boj_2121 {
    public static void main(String [] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] x_cordinates = new int[num];
        int[] y_cordineates = new int[num];
        for(int i = 0; i < num; i++)
        {
            x_cordinates[i] = sc.nextInt();
            y_cordineates[i] = sc.nextInt(); 
        }
        for(int i = 0; i < num; i++)
        {
            int low = i+1;
            int high = num-1;
            int result = i+1;
            while( low <= high)
            {
                int mid = (low+high)/2;
                if(x_cordinates[mid] > x_cordinates[i] + x)
                {
                    high = mid-1;
                }
                else if(x_cordinates[mid] < x_cordinates[i] + x)
                {
                    low = mid + 1;
                }
                else if( mid == x_cordinates[i] + x)
                {
                    result = mid;
                }
            }

        }
        int ans = 0;
        
        System.out.println(ans);

    }
}
