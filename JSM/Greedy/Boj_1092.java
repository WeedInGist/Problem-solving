package Algo_study.Greedy;
import java.util.Arrays;
import java.util.Scanner;

public class Boj_1092 {
    static void donwGrade(int[] arr)
    {
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i] > 0)
                arr[i] -= 1;
            else if (arr[i] == 0)
            {
                int closest = -1;
                for(int j = i-1; j >=0 ; j--)
                {
                    if(arr[j] > 0)
                    {
                        closest = j;
                        // System.out.println("현재 내 위치는 "+i);
                        // System.out.println("가장 가까운 곳은 "+ j);
                        break;
                    }
                }
                if(closest != -1)
                    arr[closest] -= 1;
            }
        }
    }
    static boolean isDone(int[] arr)
    {
        for(int a : arr)
        {
            if(a != 0)
                return false;
        }
        return true;
    }
    static int countInterval(int start, int end, int[] loads)
    {
        int count = 0;
        if(start == end)
        {
            for(int a : loads)
            {
                if(a == end)
                    count++;
            }
            return count;
        }
        else
            for(int a : loads)
            {
            
                if( start<a && a <= end)
                    count++;
                else if( end < a)
                {
                    break;
                }
            }
            return count;
    }
    static int[] cranes;
    static int[] loads;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cranes = new int[N];
        for(int i = 0 ; i < N; i++)
        {
            cranes[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        loads = new int[M];
        for(int i = 0; i < M ; i++)
        {
            loads[i] = sc.nextInt();
        }
        Arrays.sort(cranes);
        Arrays.sort(loads);
        int[] diff_cranes = new int[N];
        for(int i = 0; i < M; i++)
        {
            if(loads[i] <= cranes[0])
            {
                diff_cranes[0]++;
            }
        }
      
        for(int i = 0; i < M; i++)
        {
            if(loads[i] > cranes[N-1])
            {
                System.out.println(-1);
                sc.close();
                return;
            }
        }
        for(int i = 0 ; i < N-1 ; i++)
        {
           diff_cranes[i+1] = countInterval(cranes[i], cranes[i+1], loads);
        }
        int time = 0;
        while(true)
        {
            if(!isDone(diff_cranes))
            {
                System.out.println("다운 그레이드 하기 전");
                for(int a : diff_cranes)
                    System.out.print(a+" ");
                System.out.println();
                donwGrade(diff_cranes);
                System.out.println("다운 그레이드 한 후");
                for(int a : diff_cranes)
                    System.out.print(a+" ");
                System.out.println();
                time++;
            }
            else
            {
                System.out.println(time);
                sc.close();
                return;
            } 
        }
    }
}

