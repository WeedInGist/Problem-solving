package Algo_study.Greedy;

import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_1208_조성민
{
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        //높은 순서
        PriorityQueue<Integer> narashi = new PriorityQueue<>(Collections.reverseOrder());
        //낮은 순서
        PriorityQueue<Integer> narashi_reverse = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int i = 1 ; i <= 1 ; i++)
        {
            narashi.clear();
            narashi_reverse.clear();
            int chance = sc.nextInt();
            sc.nextLine();
            String[] burdens = sc.nextLine().split(" ");
            int[] burdens_arr = new int[100];
            for(int j = 0 ; j < 100; j++)
            {
                burdens_arr[j] = Integer.parseInt(burdens[j]);
                narashi.add(burdens_arr[j]);
                narashi_reverse.add(burdens_arr[j]);
            }
            while(chance > 0)
            {
                if(narashi.peek()-narashi_reverse.peek() > 1)
                {
                    int max = narashi.poll();
                    int min = narashi_reverse.poll();
                    narashi_reverse.remove(max);
                    narashi.remove(min);
                    narashi.add(max-1);
                    narashi.add(min+1);
                    narashi_reverse.add(min+1);
                    narashi_reverse.add(max-1);
                    chance--;
                }
                else
                    break;
            }
            sb.append("#").append(i).append(" ").append(narashi.peek()-narashi_reverse.peek()).append("\n");
            // System.out.println(narashi.peek());
            // System.out.println(narashi_reverse.peek());

        }
        System.out.println(sb);
    }
}