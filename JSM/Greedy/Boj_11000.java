package Algo_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Schedule1 implements Comparable<Schedule1>
{
    Schedule1(int start_time, int end_time)
    {
        this.start_time = start_time;
        this.end_time = end_time;
    }
    int start_time;
    int end_time;
    @Override
    public int compareTo(Schedule1 a)
    {
        if(this.end_time > a.end_time)
        {
            return 1;
        }
        else if (this.end_time == a.end_time)
        {
            if(this.start_time < a.start_time)
            {
                return -1;
            }
            else if(this.start_time == a.start_time)
            {
                return 0;
            }
            else
                return -1;
        }
        else
            return -1;
    }
    public String toString()
    {
        return start_time+" "+end_time;
    }
}
//저녁 요리중
class Classroom {
    PriorityQueue<Schedule1> rooms = new PriorityQueue<>();
    public boolean isEmpty()
    {
        if(rooms.size() == 0)
        {
            return true;
        }
        return false;
    }
    public Schedule1 peek()
    {
        return rooms.peek();
    }
    public Schedule1 poll()
    {
        return rooms.poll();
    }
    public void add(Schedule1 a)
    {
        rooms.add(a);
    }
    public int size()
    {
        return rooms.size();
    }

    // ArrayList<Schedule1> time_schedule = new ArrayList<Schedule1>();
    // public boolean insert_possible(Schedule1 s)
    // {
    //     if(this.time_schedule.isEmpty())
    //     {
    //         this.time_schedule.add(s);
    //         return true;
    //     }
    //     if(this.time_schedule.get(this.time_schedule.size()-1).end_time <= s.start_time) 
    //     {
    //         this.time_schedule.add(s);
    //         return true;
    //     } 
    //     return false;
    // }
}
public class Boj_11000 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Schedule1> schedules = new PriorityQueue<Schedule1>();
        Classroom room_schedule = new Classroom();
        for(int i = 0; i < N; i++)
        {
            String[] s = br.readLine().split(" ");
            int a, b;
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            schedules.add(new Schedule1(a, b));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(schedules.poll().end_time);
		
		//4. 배열을 두 번째 값부터 순회하면서,
		for(int i = 1; i < N; i++) {
			//start가 PriorityQueue의 peek()보다 작거나 같다면, pq에서 하나 뺀다.
			if(pq.peek() <= schedules.peek().start_time) pq.poll();
			
			//4-1. 순회하면서, 현재 end값을 새로 pq에 넣어준다.
			pq.add(schedules.poll().end_time);
		}
		
		//5. pq에 남아있는 데이터의 갯수가 필요한 강의실의 갯수이다.
		System.out.println(pq.size());
        // while( schedules.size() != 0)
        // {
        //     if(room_schedule.isEmpty())
        //     {
        //         room_schedule.add(schedules.poll());
        //         continue;
        //     }
        //     Schedule1 a = schedules.poll();
        //     if(room_schedule.peek().end_time <= a.start_time)
        //     {
        //         room_schedule.poll();
        //         room_schedule.add(a);
        //     }
        //     else
        //     {
        //         room_schedule.add(a);
        //     }
            
        // }
        // System.out.println(room_schedule.size());
        // for(Schedule1 a : room_schedule.rooms)
        // {
        //     System.out.println(a);
        // }

    }
}
