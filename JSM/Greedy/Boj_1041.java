package Algo_study.Greedy;
import java.util.Arrays;
import java.util.Scanner;

// n이 1개일 땐 예외인 듯. 

//정육면체의 윗면 중 모서리 부분은 3면이 보임.  -> 3면 최소, 4개 (n>1)         
//나머지 변 중에 모서리 부분을 제외한 곳은 2면이 보임. -> 2면 최소, (n-1) * 4 + (n-2) *4 = (2n-3) * 4 = 8n-12
//나머지 면 중 변을 제외한 부분은 1면만 보임. -> 1면 최소, n^2 - 4(n-1) + 4n^2- 12n+8 = 5n^2 -16n+12

//1면 최소를 구하는 것은 쉬움. 걍 정렬
// 2면 최소를 구하는 것은? 숫자의 인덱스 두 개의 합이 5가 되면 안 됨. 마주보고 있는 것이므로.
public class Boj_1041 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int size_n = sc.nextInt();
        int[] arr = new int[6];
        int min_2 = Integer.MAX_VALUE;
        for(int i = 0 ; i < 6; i++)
        {
            arr[i] = sc.nextInt();
        }
        //두 면이 서로 다른 면이며 마주보지 않을 때 두 면의 합의 최솟값  
        for(int i = 0 ; i < 6; i++)
        {
            for(int j = 0 ; j < 6 ; j++)
            {
                if(i!=j && i+j != 5)
                    if(min_2 > arr[i]+arr[j])
                        min_2 = arr[i]+arr[j];
            }
        }
        //세 면이 모두 다르며 세 면이 각각 서로를 마주보지 않을 때 세 면임.
        long min_3 = Integer.MAX_VALUE;
        for(int i = 0 ; i < 6; i++)
        {
            for(int j = 0 ; j < 6 ; j++)
            {
                for(int k =0; k < 6; k++)
                {
                    if(i !=j && j!=k && i!=k && i+j !=5 && j+k != 5 && i+k != 5)
                    {
                        if(min_3 > arr[i]+arr[j]+arr[k])
                            min_3 = arr[i]+arr[j]+arr[k];
                    }
                }
            
            }
        }
        // 인덱스 순서가 안 바뀌게 가장 마지막에 1면의 최솟값을 구해줌.
        Arrays.sort(arr);
        long min_1 = arr[0];
        long sum = 0;
        for(int a : arr)
            sum += a;
        sum -=arr[5];
        if(size_n ==1)
            System.out.println(sum);
        else
        {
            long ans = 4*min_3 + (8*size_n-12) * min_2 + ((long)Math.pow(size_n,2)*5-16*size_n+12)*min_1;
            System.out.println(ans);
        }
    }
}
