package Algo_study.Greedy;
import java.util.Scanner;

public class Boj_1213
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr = new int[26];
        //각 인덱스마다 문자열의 개수를 알려준다.
        for(int i = 0 ; i < s.length(); i++)
        {
            arr[s.charAt(i)-'A'] += 1;
        }
        //홀수인 문자를 하나 뺀다.
        int odd_count = 0;
        int odd_index = 0;
        boolean odd = false;
        for(int i = 0 ; i < 26; i++)
        {
            //홀수 번 등장하는 문자를 찾고 인덱스를 저장한 다음 하나 빼줌.
            if(arr[i] > 0 && arr[i] % 2 == 1)
            {
                odd = true;
                odd_index = i;
                odd_count++;
                arr[i]--;
            } 
        }
        //홀수인게 두 개 이상이라면 
        if(odd_count > 1)
        {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        char[] half_arr = new char[s.length()];
        int arr_index = 0;
        for(int i = 0 ; i < 26; i++)
        {
            int num = arr[i]/2;
            if(num > 0)
            {
                while(num >0)
                {
                    half_arr[arr_index++] = (char)((char)i+'A');
                    num--;
                }
            }
        }
        if(odd)
            half_arr[arr_index++] = (char)((char)odd_index+'A');
        for(int i = 25 ; i >= 0; i--)
        {
            int num = arr[i]/2;
            if(num > 0)
            {
                while(num >0)
                {
                    half_arr[arr_index++] = (char)((char)i+'A');
                    num--;
                }
            }
        }
        System.out.println(half_arr);









    }
}