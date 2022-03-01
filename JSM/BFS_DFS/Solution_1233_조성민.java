package Algo_study.Search;

import java.util.Scanner;

public class Solution_1233_조성민 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = 10;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 10; i++)
        {
            int size = sc.nextInt();
            sc.nextLine();
            boolean ans = true;
            for(int j = 0; j < size ; j++)
            {
                String[] s = sc.nextLine().split(" ");
                if(s[1].charAt(0)-'0' <= 9 && s[1].charAt(0)-'0' >=0)
                {
                    if(s.length >2 && ans == true)
                    {
                        sb.append("#"+i+" 0\n");
                        ans = false;
                    }
                }
            }
            if(ans == true)
                sb.append("#"+i+" 1\n");
        }
        System.out.println(sb);
    }
}
