import java.util.Scanner;
import java.util.Arrays;

//쉽게 정렬을 해주기 위해 스케쥴 클래스를 만든 뒤 Comparable 인터페이스를 확장함.
class Schedule implements Comparable<Schedule>
{
    int needed_time = 0;
    int deadline = 0;
    //정렬을 위한 compareTo 오버라이드 부분.
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
        //스케쥴 인스턴스에 정보들을 받고 완수해야되는 시간 기준으로 정렬함. 빠를수록 앞에 있음.
        Arrays.sort(arr);
        //기준점을 잡아주기 위해 포문 밖에 걍 초기화함.
        int time = arr[Task-1].deadline-arr[Task-1].needed_time;
        //자세한 부분은 스터디 때 설명해야 할 듯.
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
