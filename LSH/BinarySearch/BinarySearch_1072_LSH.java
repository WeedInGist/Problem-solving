// BOJ - 게임(1072번)
// BinarySearch

import java.util.Scanner;

public class BinarySearch_1072_LSH {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        long x = scan.nextLong();
        long y = scan.nextLong();
        double win = Math.floor((y*100/x));


        long ans = -1;
        if(win < 99){
            long left = 1;
            long right = 1000000000L;
            while (left <= right) {
                long mid = (left+right) / 2;
                double win_2 = Math.floor(((y+mid)*100/(x+mid)));
                if(win_2 > win){
                    ans = mid;
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }

            System.out.println(ans);

    }
}
