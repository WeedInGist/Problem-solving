package Algo_study.Search;

import java.util.Scanner;
import java.util.Stack;

class Solution_1218_조성민
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Stack<Character> bracket= new Stack();
        int index = 1;
        while(index <=1)
        {
            bracket.clear();
            int type_1 = 0;
            int type_2 = 0;
            int type_3 = 0;
            int type_4 = 0;

            int size = sc.nextInt();
            sc.nextLine();
            String s= sc.nextLine();
            for(int i=0; i < s.length(); i++)
            {
                bracket.push(s.charAt(i));
            }
            boolean ans = true;
            while(bracket.isEmpty() == false)
            {
                char t = bracket.pop();
                if(t == ')')
                    type_1++;
                else if(t=='(')
                    type_1--;
                if(t == '}')
                    type_2++;
                else if(t=='{')
                    type_2--;
                if(t == ']')
                    type_3++;
                else if(t=='[')
                    type_3--;
                if(t == '>')
                    type_4++;
                else if(t=='<')
                    type_4--;
                if(type_1 < 0 || type_2 < 0 || type_3 < 0 || type_4 <0)
                {
                    ans = false;
                    break;
                }
            }
            if(ans == false || type_1 >0 || type_2 >0 || type_3 >0 || type_4 >0) System.out.println("#"+index+" "+0);
            else System.out.println("#"+index+" "+1);
            index++;
        }
    }
}