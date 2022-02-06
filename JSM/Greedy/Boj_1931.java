package Algo_study.Greedy;
import java.util.Scanner;
import java.util.Arrays;

class Reservation implements Comparable<Reservation>
{
    int start_time;
    int end_time;
    Reservation()
    {

    }
    @Override
    public int compareTo(Reservation a)
    {
        if(this.end_time - a.end_time > 0)
        {
            return 1;
        }
        else if (this.end_time == a.end_time)
        {
            if(this.start_time > a.start_time)
                return 1;
            else if(this.start_time == a.start_time)
                return 0;
            else
                return -1;
        }
        else
            return -1;
    }
}

public class Boj_1931
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Reservation[] arr = new Reservation[size];
        for(int i = 0 ; i < size ; i++)
        {
            arr[i] = new Reservation();
            arr[i].start_time = sc.nextInt();
            arr[i].end_time = sc.nextInt();
        }
        if(size == 1)
        {
            System.out.println(1);
            return;
        }
        Arrays.sort(arr);
        int cur_time = 0;
        cur_time = arr[0].end_time;
        int index = 1;
        int count = 1;
        while(index<size)
        {
            if(arr[index].start_time >= cur_time)
            {
                count++;
                cur_time = arr[index].end_time; 
            }
            index++;
        }
        System.out.println(count);

    }
}