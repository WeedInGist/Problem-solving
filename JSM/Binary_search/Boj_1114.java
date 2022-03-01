package Algo_study.Binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Boj_1114 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long k = sc.nextLong();
        long c = sc.nextLong();
        ArrayList<Long> cut_locations = new ArrayList<Long>();
        cut_locations.add(l);
        loop1:for(int i = 0; i < k; i++)
        {
            long a = sc.nextLong();
            for(int j = 0 ; j < i; j++)
            {
                if(cut_locations.get(j) == a)
                {
                    continue loop1;
                }
            }
            cut_locations.add(a);
        }
        Collections.sort(cut_locations);
        long low = 1;
        long high = l;
        long last_cut = 0;
        Long result = 0L;
        ArrayList<Long> arr = new ArrayList<Long>();
        Object[] a = cut_locations.toArray();
        long[] diff = new long[a.length+1];
        for(int i = 0; i < a.length-1; i++)
        {
            diff[i] = (long)a[i+1] - (long)a[i];
        }
        diff[0] = (long)a[0];
        diff[a.length] = l - (long)a[(int)a.length-1];
loop1:     while(low <= high)
        {
            long mid = (low+high)/2;
            last_cut = 0;
            long count = 0;
            // System.out.println(low+" "+mid+" "+high);
            for(int i = 0 ; i < cut_locations.size(); i++)
            {
                if(cut_locations.get(i)-last_cut > mid)
                {
                    if(i == 0)
                    {
                        low = mid + 1;
                        continue loop1;
                    }
                    else
                    {
                        boolean fail = false;
                        int last_cut_index = -1;
                        for(int j = 0; j < i ; j++)
                        {
                            if(last_cut == cut_locations.get(j))
                            {
                                last_cut_index = j;
                                break;
                            }
                        }
                        for(int j = last_cut_index+1; j < i ; j++)
                        {
                            last_cut = cut_locations.get(j);
                            if(last_cut + mid >= cut_locations.get(i))
                            {
                                arr.add(cut_locations.get(j));
                                count++;
                                break;
                            }
                            if(j == i)
                            {
                                fail = true;
                                low = mid +1;
                                continue loop1;
                            }
                        }
                        
                    }
                }
            }
            if(count > c)
            {
                low = mid + 1;
            }
            else
            {
                // System.out.println("씨발"+low+" "+mid+" "+high);
                result = mid;
                high = mid -1;
            }


        }
        System.out.println(low+" "+arr.get(0));

    }
}
