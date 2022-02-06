package Algo_study.Greedy;
// 지상 최악의 햄버거 버거킹 ㅣ발롬들
import java.util.Arrays;
import java.util.Scanner;
public class Greedy_no_4 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int sum = 0;
        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        int price = 1;
        while(price <= sum)
        {
            int available = 0;
            for(int a : arr)
            {
                if(a > price)
                {
                    if(available != price)
                    {
                        System.out.println(price);
                        return;
                    }
                }
                if(a <= price)
                {
                    available += a;
                }
                if( available == price)
                {
                    price++;
                    break;
                }
                if( available > price)
                {
                    System.out.println(price);
                    return;
                }
            }



        }






    }


}
