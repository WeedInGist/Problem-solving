package Algo_study.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 최소 이동시간, 최소 이동 횟수, 최소 거리 -> 반복되는 패턴에 맞춰서 반복되는 코딩 습관을 기르자.
// 논리적인 흐름 == 실제 코드 흐름 
class Tomato
{
    //행과 열 좌표
    int x,y;
    //익었는지, 안 익었는지 0, 1
    int mature;
    // 익은 시간
    int time;
    Tomato(int row, int col, int m, int t)
    {
        this.x = row;
        this.y = col;
        this.mature = m;
        this.time = t;
    }
    public String toString()
    {
        String s = this.time+" ";
        return s;
    }
}
public class Main_7576_조성민 {


    static boolean[][] visited;
    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    static ArrayList<Tomato> which = new ArrayList<>();
    static int max = 0;
    static void BFS(Tomato[][] map)
    {
        Queue<Tomato> queue = new LinkedList<>();
        for(Tomato a : which)
        {
            visited[a.x][a.y] = true;
            queue.add(a);
        }
        while(queue.isEmpty() == false)
        {
            Tomato a = queue.poll();
            for(int i = 0; i< 4; i++)
            {
                int next_r = a.x + directions[i][0];
                int next_c = a.y + directions[i][1];
                if(next_r >=0 && next_r< map.length && next_c>=0 && next_c < map[0].length)
                {
                    //방문안한 토마토가 아직 안 익었으면
                    if(map[next_r][next_c].mature == 0 && visited[next_r][next_c] == false)
                    {
                        //방문처리 해주고
                        visited[next_r][next_c] = true;
                        // 익은 것들에서부터 출발해서 안 익은 것들까지 왔다는 것은, 즉 지금 내가 보고있는 안 익은 토마토가 익는다는 뜻
                        map[next_r][next_c].mature = 1;
                        // 이제 갓 익은 토마토가 익은 시점은 얘를 익게 만든 옆에 있는 토마토의 시간 +1 
                        map[next_r][next_c].time = a.time+1;
                        // 이제 막 익은 토마토를 다음 탐색 대상으로 큐에 집어넣어줌.
                        queue.add(new Tomato(next_r,next_c,1, a.time+1));
                        //익은 시간의 최대를 계속 갱신해줌.
                        if(a.time+1 > max)
                        {
                            max = a.time+1;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int col = Integer.parseInt(s[0]);
        int row = Integer.parseInt(s[1]);
        Tomato[][] map = new Tomato[row][col];
        visited = new boolean[row][col];
        for(int i = 0 ; i < row; i++)
        {
            s = br.readLine().split(" ");
            for(int j = 0 ; j < col; j++)
            {
                int mature = Integer.parseInt(s[j]);
                if(mature == 1)
                {
                    which.add(new Tomato(i,j, mature, 0));
                }
                map[i][j] = new Tomato(i,j, mature, 0);
            }
        }
        // BFS(map, 3,5, 0);
        BFS(map);
        for(int i = 0 ; i < row; i++)
        {
            for(int j = 0; j < col ; j++)
            {
                if(visited[i][j]== false)
                    if(map[i][j].mature ==0)
                    {
                        System.out.println(-1);
                        return;
                    }
                
            }
        }
        System.out.println(max);
    }
}
