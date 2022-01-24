import java.util.Scanner;
import java.util.Arrays;

class Schedule implements Comparable<Schedule>
{
    int needed_time = 0;
    int deadline = 0;
    
    public int compareTo(Schedule a)
    {
        return this.deadline-a.deadline;
    }

}
class BOJ_1263{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int Task = sc.nextInt();
        Schedule[] arr = new Schedule[Task];
        for(int i = 0 ; i < Task; i++)
        {
            arr[i] = new Schedule();
            arr[i].needed_time = sc.nextInt();
            arr[i].deadline = sc.nextInt();
        }
        Arrays.sort(arr);
        int time = arr[Task-1].deadline-arr[Task-1].needed_time;
        for(int i = Task -2 ; i >= 0 ; i--)
        {
            if(arr[i].deadline < time)
            {
                time = arr[i].deadline;
                time -= arr[i].needed_time;
            }
            else
            {
                time -= arr[i].needed_time;
            }
//            System.out.println(time);
        }
        System.out.println(time);
        
    
    }
}