package Algo_study.Implementation;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_3107 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String before = "";
        String after = "";
        StringTokenizer token = new StringTokenizer(s, "::");
        boolean exist = false;
        for(int i = 0 ; i < s.length()-1; i++)
        {
            if(s.substring(i, i+2).equals("::"))
            {
                String[] two = s.split("::");
                if(two.length == 2)
                {

                    before = two[0];
                    after = two[1];
                }
                else if(two.length ==1)
                {
                    before = two[0];
                }
                exist = true;
                break;
            }
        }
        if(!exist)
        {
            String[] strings = s.split(":");
            for(int i = 0 ; i < 8; i++)
            {
                String temp = "";
                for(int j = 0; j < 4-strings[i].length(); j++)
                {
                    temp += "0";
                }
                temp += strings[i];
                strings[i] = temp;
                if( i != 7)
                    strings[i] += ":";
            }
            for(int i = 0 ; i < strings.length; i++)
            {
                System.out.print(strings[i]);
            }
        }
        else
        {
            String[] strings_1 = before.split(":");
            for(int i = 0; i < strings_1.length; i++)
            {
                String temp = "";
                for(int j = 0; j < 4-strings_1[i].length(); j++)
                {
                    temp += "0";
                }
                temp += strings_1[i];
                strings_1[i] = temp;
                // if( i != strings.length -1)
                strings_1[i] += ":";
            }
            for(int i = 0 ; i < strings_1.length; i++)
            {
                System.out.print(strings_1[i]);
            }

            String[] strings = after.split(":");
            for(int i = 0; i < strings.length; i++)
            {
                String temp = "";
                for(int j = 0; j < 4-strings[i].length(); j++)
                {
                    temp += "0";
                }
                temp += strings[i];
                strings[i] = temp;
                if( i != strings.length -1)
                    strings[i] += ":";
            }
            String temp = "";
            for(int i = 0; i < 8 - strings.length - strings_1.length; i++)
            {
                temp += "0000:";
                if(i == 7)
                {
                    temp += "0000";
                }
            }
            System.out.print(temp);
            for(int i = 0 ; i < strings.length; i++)
            {
                System.out.print(strings[i]);
            }

        }
    }
}
