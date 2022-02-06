package Algo_study.Greedy;

import java.util.Scanner;
import java.util.Arrays;

//가장 많이 고민한 것이 배열의 인덱스를 모조리 다 한번씩 때려넣는 것이었는데
//정말 간단하게도 그냥 for(int a : arr) 쓰면 해결되는 것이었다.
//모르는 것이 아니었는데...

public class Greedy_no_1 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int index = 0;
        int fear = 0;
        int people = 0;
        int count = 0;
        while(index<N)
        {
            //파티에 사람이 아무도 없으면 한 명 일단 넣고 인원수는 1로, 공포값 설정
            if(people == 0)
            {
                if(index == N)
                    break;
                people += 1;
                fear = arr[index++];
            }//공포값이 사람들 수보다 높으면 한명 더 넣음. 
            if(people < fear)
            {
                if(index == N)
                    break;
                people += 1;
                if(fear < arr[index])
                {
                    fear = arr[index];
                }
                index++;
            }
            if(people >= fear)
            {
                // System.out.println(fear+" "+people);
                count++;
                people = 0;
                fear = 0;
            }
        }
        System.out.println(count);
    }
}
