package Algo_study.Greedy;
import java.util.Scanner;


//결국 이 문제는 0의 연속된 수열과 1의 연속된 수열 중 어느 것이 더 적느냐를 구하는 문제이다.
//추가로 생각해줄 것은 처음 시작하는 수에 따라서 어느 한쪽의 수가 커진다는 것 뿐.
public class Greedy_no_3 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean zero = false;
        boolean one = false;
        int zero_num = 0;
        int one_num = 0;
        if(s.charAt(0) == '0')
        {
            zero = true;
            zero_num++;
        }
        else
        {
            one = true;
            one_num++;
        }
        for(int i = 1 ; i < s.length(); i++)
        {
            if(s.charAt(i) != s.charAt(i-1))
            {
                // System.out.println("나 여기서 달라짐 "+i);
                if(zero)
                {
                    zero_num += 1;
                    zero = !zero;
                    one = !one;
                }
                else if(one)
                {
                    one_num += 1;
                    zero = !zero;
                    one = !one;

                }
            }
        }
        if(zero_num > one_num)
            System.out.println(one_num);
        else
            System.out.println(zero_num);
        // System.out.println(zero_num+" "+one_num);
    }
}
