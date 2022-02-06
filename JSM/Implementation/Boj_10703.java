package Algo_study.Implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_10703 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        char[][] arr = new char[row][col];
        for(int i = 0 ; i < row ; i++)
        {
            arr[i] = sc.nextLine().toCharArray();
        }
        char[][] temp = new char[col][row];
        for(int i = 0 ; i < row ; i++)
        {
            for(int j = 0 ; j < col ; j++)
            {
                temp[j][i] = arr[i][j];
            }
        }
        // for(int i = 0 ; i < col ; i++)
        // {
            //     for(int j = 0 ; j < row ; j++)
            //     {
                //         System.out.print(temp[i][j]);
        //     }
        //     System.out.println();
        // }
        
        ArrayList<Integer> exist = new ArrayList<Integer>();
        ArrayList<Integer> exist_j = new ArrayList<Integer>();

        int minimum = Integer.MAX_VALUE;
        for(int i = 0; i< col; i++)
        {
            boolean isStar = false;
            int highest_ground = -1;
            int lowest_star = -1;
            for(int j =0 ; j < row; j++)
            {
                if(temp[i][j] == 'X')
                {
                    if(!isStar)
                    {
                        exist_j.add(j);
                    }
                    isStar = true;
                    lowest_star = j;
                }
                if(temp[i][j] == '#')
                {
                    highest_ground = j;
                    break;
                }
            }
            if(!isStar)
            {
                continue;
            }
            exist.add(i);
            if(minimum >= highest_ground - lowest_star)
                minimum = highest_ground - lowest_star;
        }
        minimum -= 1;
        for(int i : exist)
        {
            for(int j =row-1 ; j >= 0; j--)
            {
                if(temp[i][j] == 'X')
                {
                    temp[i][j+minimum] = 'X';
                    temp[i][j] = '.';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< row; i++)
        {
            for(int j =0 ; j < col; j++)
            {
                sb.append(temp[j][i]);
                
            }
            sb.append('\n');
        }
    System.out.println(sb);
    }
}
