package Algo_study.Search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//헛간이라는 클래스를 하나 만들어줌.
// 헛간의 번호, 내가 스타트 지점으로부터 얼마나 떨어져있는지 거리를 저장함.
class Barn implements Comparable<Barn>
{
    int index;
    int g;
    Barn(int index, int g)
    {
        this.index = index;
        this.g = g;
    }
    public String toString()
    {
        return "이 헛간은 "+this.index+"번 헛간이며 거리는 "+g+" 입니다.";
    }
    public int compareTo(Barn a)
    {
        return this.index - a.index;
    }
}

public class Boj_6118 {
    static int max_g = -1;
    static boolean[] visited;
    //현재 내가 탐색한 바로는, 1 에서부터 거리가 1인 헛간이 최대
    //어 그래? 그러면 거리가 1인 헛간들 다 넣을게
    //거리가 2인 헛간이 나왔음
    // 어 그래? 그러면 ans를 싹 초기화하고 다시 넣을게 거리가 2인 것들만
    static ArrayList<Barn> ans = new ArrayList<Barn>();

    static void BFS(ArrayList<ArrayList<Integer>> map)
    {
        Queue<Barn> queue = new LinkedList<Barn>();
        visited[1] = true;
        queue.add(new Barn(1, 0));
        while(queue.isEmpty() == false)
        {
            Barn now = queue.poll();
            if(now.g > max_g)
            {
                max_g = now.g;
                ans.clear();
            }
            if(now.g == max_g)
            {
                ans.add(now);
            }
            //지금 보고 있는 now 의 헛간과 연결된 모든 헛간들을 둘러볼 것.
            for(int j : map.get(now.index))
            {
                //아직 방문이 안 된 상태라면
                if(visited[j] == false)
                {
                    //방문처리를 해준다.
                    visited[j] = true;
                    //Barn -> index, 원점으로부터의 거리 g 
                    // 현재보고있는 지점에서부터 탐색한다는 뜻은, 원점에서부터의 현재까지의 거리에 1을
                    // 더한 지점을 탐색한다는 뜻
                    queue.add(new Barn(j, now.g+1));
                }
            }
        }
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[n+1];  
        // N+1개의 ArrayList<Integer>
        for(int i = 0; i <= n; i++)
        {
            map.add(new ArrayList<Integer>());
        }      
        for(int i = 0 ; i < m ; i++)
        {
            int row = sc.nextInt();
            int col = sc.nextInt();
            map.get(row).add(col);
            map.get(col).add(row);
        }
        BFS(map);
        //ans에 거리가최대인 헛간들만 담기게 됨.
        Collections.sort(ans);
        System.out.println(ans.get(0).index+" "+ans.get(0).g+" "+ans.size());
    }
}
