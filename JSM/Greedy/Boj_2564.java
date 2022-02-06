package Algo_study.Greedy;
import java.util.Scanner;

import javax.lang.model.element.TypeElement;

class Shop{
    int type, offset;
    Shop(int type, int offset)
    {
        this.type = type;
        this.offset = offset;

    }
}

class Guard
{
    int type, offset;
    Guard(int type, int offset)
    {
        this.type = type;
        this.offset = offset;
    }
}
public class Boj_2564 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int shop_num = sc.nextInt();
        Shop[] shops = new Shop[shop_num];
        for(int i = 0 ; i < shop_num; i++)
        {
            shops[i] = new Shop(sc.nextInt(), sc.nextInt());
        }
        Guard me = new Guard(sc.nextInt(), sc.nextInt());
        int dist = 0;
        int temp = 0;
        for(Shop a : shops)
        {
            if(a.type == 1)
            {
                if(me.type == 1)
                {
                    temp = Math.abs(me.offset-a.offset);
                    dist += temp;
                }
                else if(me.type == 2)
                {
                    if(me.offset < row - a.offset)
                    {
                        temp = me.offset + a.offset + col;
                    }
                    else
                        temp = 2 * row - me.offset - a.offset + col;
                    dist += temp;
                }
                else if(me.type == 3)
                {
                    temp = me.offset + a.offset;
                    dist += temp;
                }
                else if(me.type == 4)
                {
                    temp = me.offset + row - a.offset;
                    dist += temp;
                }
            }
            else if(a.type == 2)
            {
                if(me.type == 2)
                {
                    temp = Math.abs(me.offset-a.offset);
                    dist += temp;
                }
                else if(me.type == 1)
                {
                    if(me.offset < row - a.offset)
                    {
                        temp = me.offset + a.offset + col;
                    }
                    else
                        temp = 2 * row - me.offset - a.offset + col;
                    dist += temp;
                }
                else if(me.type == 3)
                {
                    temp = col - me.offset + a.offset;
                    dist += temp;
                }
                else if(me.type == 4)
                {
                    temp = col - me.offset + row - a.offset;
                    dist += temp;
                }
            }
            else if(a.type == 3)
            {
                if(me.type == 3)
                {
                    temp = Math.abs(me.offset-a.offset);
                    dist += temp;
                }
                else if(me.type == 4)
                {
                    if(me.offset < col - a.offset)
                    {
                        temp = me.offset + a.offset + row;
                    }
                    else
                        temp = 2 * col - me.offset - a.offset + row;
                    dist += temp;
                }
                else if(me.type == 1)
                {
                    temp = me.offset + a.offset;
                    dist += temp;
                }
                else if(me.type == 2)
                {
                    temp = col + me.offset - a.offset;
                    dist += temp;
                }
         
            }
            else if(a.type == 4)
            {
                if(me.type == 4)
                {
                    temp = Math.abs(me.offset-a.offset);
                    dist += temp;
                }
                else if(me.type == 3)
                {
                    if(me.offset < col - a.offset)
                    {
                        temp = me.offset + a.offset + row;
                    }
                    else
                        temp = 2 * col - me.offset - a.offset + row;
                    dist += temp;
                }
                else if(me.type == 1)
                {
                    temp = row - me.offset + a.offset;
                    dist += temp;
                }
                else if(me.type == 2)
                {
                    temp = col + row - me.offset - a.offset;
                    dist += temp;
                }
            }
        }
        System.out.println(dist);
    }
}
