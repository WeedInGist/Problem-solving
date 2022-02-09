// BOJ - 숨바꼭질(1697번)
// BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs_1697_LSH {
    static int n, k;
    static int[] time;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();

        time = new int[100001];

        bfs(n);




    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        time[start] = 0;

        while (!q.isEmpty()){
            int x = q.poll();
            if(x == k){
                System.out.println(time[k]);
                return;
            }

            if((x-1) >= 0 && (x-1) < 100001 && time[x-1] == 0){
                time[x-1] = time[x]+1;
                q.add(x-1);
            }

            if((x+1) >= 0 && (x+1) < 100001 && time[x+1] == 0){
                time[x+1] = time[x]+1;
                q.add(x+1);
            }

            if((2*x) >= 0 && 2*x < 100001 && time[2*x] == 0){
                time[2*x] = time[x]+1;
                q.add(2*x);
            }

        }
    }


}
