package Algo_study.Greedy;
import java.util.Scanner;

public class Solution_1289_조성민 {
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[T];
        for(int i = 0 ; i < T ; i++)
        {
            arr[i] = sc.nextLine();
        }
        for(int i = 0 ; i < T; i++)
        {
            int count = 0;
            char[] temp = arr[i].toCharArray();
            for(int j = 0; j < temp.length; j++)
            {
               if(temp[j] == '1')
               {   
                   count++;
                   for(int k=j; k < temp.length; k++)
                   {
                        if(temp[k] == '1')
                            temp[k] = '0';
                        else
                            temp[k] = '1';
                   }
               }
            }
            System.out.println("#"+(i+1)+" "+count);
        }
    }
}
