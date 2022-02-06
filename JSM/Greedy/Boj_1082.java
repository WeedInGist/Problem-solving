package Algo_study.Greedy;

import java.util.Scanner;
public class Boj_1082
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int min = 51;
        int min_index = -1;
        //가장 싸면서 인덱스가 높은 걸 찾아야 한다.
        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = sc.nextInt();
            if(arr[i] <= min && min_index <= i && i!= 0)
            {
                min = arr[i];
                min_index = i;
            }
        }
        int M = sc.nextInt();
        String ans = "";
        if(N ==1)
        {
            System.out.println(0);
            return;
        }
        ans = ""+ String.valueOf(min_index);
        if(M <arr[min_index])
        {
            System.out.println(0);
            return;
        }
        M -= arr[min_index];
        //자릿수 늘리기 좋은 가장 가성비 좋은 건 뭐지?
        min = 51;
        for(int i = 0 ; i < N; i++)
        {
            if(arr[i] < min)
            {
                min = arr[i];
                min_index = i;
            }
        }
     
        int num = M / arr[min_index];
        M -= num * arr[min_index];
        for(int i = 0 ; i < num; i++)
        {
            ans += String.valueOf(min_index);
        }
        //1차적으로 만들어놓은 답안. 이후 업그레이드해가며 수정할 것임.
        char[] temp = ans.toCharArray();
        int[] upgradble_arr = new int[N];
        System.out.println(temp);
        for(int i = 0; i < ans.length() ; i++)
        {
            for(int j = N-1; j >= 0 ; j--)
            {
                for(int k = 0 ; k < N; k++)
                {
                    upgradble_arr[k] = arr[k] - arr[temp[i]-'0'];
                    // System.out.println(k+"로 업그레이드 값은 " + upgradble_arr[k]);
                }
                if(j > temp[i]-'0' && M >= upgradble_arr[j])
                {
                    temp[i] = String.valueOf(j).toString().charAt(0);
                    M -= upgradble_arr[j];
                    // System.out.println("지불한 돈 "+upgradble_arr[j]);
                    // System.out.println(ans.charAt(i)+"에서 " +j+ "로 업글하고 남은 돈은 "+M);
                    break;
                }
            }
        }
        for(int i = 0 ; i < ans.length(); i++)
        {
            System.out.print(temp[i]);
        }
    }
}