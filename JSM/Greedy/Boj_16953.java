package Algo_study.Greedy;
import java.util.Scanner;

public class Boj_16953{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int count = 0;
        while(start < end)
        {
            //1이 붙어있냐?
            if(end % 10 == 1)
            {
                end -= 1;
                end /= 10;
                count++;
            }
            //아니면 2의 배수냐?
            else if(end % 2 == 0)
            {
                count++;
                end /= 2;
            }
            // 것도 아니면 뭐 어케 만들었음? 노답이므로 실패
            else
            {
                System.out.println(-1);
                return;
            }
        }
        // System.out.println("내 지금 값 "+ end);
        if(start == end)
        {
            System.out.println(count+1);
        }
        else
        {
            System.out.println(-1);
        }
    }
}