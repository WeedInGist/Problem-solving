package Algo_study.Greedy;

import java.util.Scanner;

public class Main_17478_조성민 {
    static String[] str1 = {"\"재귀함수가 뭔가요?\"","\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
    "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.","그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};
    static String str5 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String str6 = "라고 답변하였지.";

    static void chatbot(int index, int n)
    {
        String s="____";
        if(n==index)
        {
            for(int j =0; j <index; j++)
                System.out.print(s);
            System.out.println(str1[0]);
            for(int j =0; j <index; j++)
                System.out.print(s);
            System.out.println(str5);
            for(int j =0; j <index; j++)
                System.out.print(s);
            System.out.println(str6);
            return;
        }
        else
        {
            for(int i = 0; i < 4; i++)
            {
                for(int j =0; j <index; j++)
                    System.out.print(s);
                System.out.println(str1[i]);
            }
            chatbot(index+1, n);
            for(int j =0; j <index; j++)
                System.out.print(s);
            System.out.println(str6);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        chatbot(0,n);
    }
}
