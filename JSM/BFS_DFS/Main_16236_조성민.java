package Algo_study.Search;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// 구현 + 시뮬레이션 + bfs 거리를 구해서 활용할 줄 아느냐 + 탐색의 조건을 좀 복잡하게 해보면 어떨까? 
// 먹을 수 있는 물고기가 한 마리일 경우 -> 먹음
// 두 마리 이상일 경우에는, 거리가 가까운 것부터 먹는데, 거리가 가까운 게 여러 마리라면, 행이 작고 열이 작은 것을 먹는다.
// 위의 두 가지 조건은 그냥 하나의 행동 원리로 표현이 된다는 것.

// 내가 먹을 수 있는 물고기 중에서, 거리가 가장 가깝고 그 와중에 행과 열이 빠른 순서대로 먹는다.
// 1 단계
// bfs에서 지금 아기 상어의 위치에서부터 먹을 수 있는 것들(즉, 사이즈가 아기 상어보다 작은 것들)의 리스트를 만들어줌.
// 2 단계
// 위에서 언급한 순서대로, 3가지로 정렬을 진행한 다음 맨 앞에꺼를 먹어줌.
// 3 단계
// 1,2를 반복하다가 더 이상 못하면 엄마 상어 호출 끝.

// 물고기 먹이랑 상어를 그냥 Fish 라는 클래스로 표현.
// 빈칸은 어떻게 표현하느냐, 그냥 size 가 0인 걸로 표현.
class Fish implements Comparable<Fish>
{
    int row, col;
    int size;
    int eat = 0;
    int step = 0; //상어로부터 거리가 얼마나 떨어져있는지 나타내주기 위한 변수. 상어인 객체는 이 step 이 0.
    Fish(int row, int col, int size, int step)
    {
        this.row = row;
        this.col = col;
        this.size = size;
        this.step = step;
    }
    public int compareTo(Fish a)
    {
        if(this.step == a.step)
        {
            if(this.row == a.row)
            {
                return this.col - a.col;
            }
            return this.row - a.row;
        }
        return this.step - a.step;
    }
}



public class Boj_16236 {
    static int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};

    static boolean[][] visited;
    // 우선순위 큐의 역할 ->  먹잇감들의 목록인데 여기에 더해주는 순간 우선순위 큐의 특성으로 자동으로 내가 정해준 기준으로 정렬이 됌.
    static PriorityQueue<Fish> eat_list = new PriorityQueue<>();

    public static int BFS(int[][] map, Fish shark)
    {
        visited = new boolean[map.length][map.length];
        // System.out.println("탐색을 시작할 때의 상어 위치 "+shark.row+" "+shark.col);
        Queue<Fish> queue = new LinkedList<>();
        queue.add(shark);
        visited[shark.row][shark.col] = true;
        while(queue.isEmpty() == false)
        {
            Fish now = queue.poll();
            // 큐에서 꺼낼 때, 내가 먹을 수 있는 건지 아닌 건지를 판단.
            // 큐에 들어가 있는 Fish 클래스의 종류는 세가지
            // 1번째, 빈칸
            // 2번째, 먹을 수 없는 물고기 == 크기가 상어랑 같아서 이동은 되지만 못 먹음.
            // 3번째, 먹을 수 있는 물고기
            if(now.size < shark.size && now.size != 0)
            {
                eat_list.add(now);
            }
            for(int i = 0; i < 4; i++)
            {
                // System.out.println(0);
                int next_r = now.row + directions[i][0];
                int next_c = now.col + directions[i][1];
                if(next_r<map.length && next_r >= 0 && next_c < map.length && next_c >= 0)
                {
                    // System.out.println(1);
                    if(visited[next_r][next_c] == false)
                    {
                        // System.out.println(2);
                        if(map[next_r][next_c] <= shark.size)
                        {
                            // System.out.println(3);
                            visited[next_r][next_c] = true;
                            // int step = Math.abs(shark.row-next_r)+ Math.abs(shark.col - next_c);
                            queue.add(new Fish(next_r,next_c,map[next_r][next_c], now.step+1));
                        }
                    }
                } 
            }
        }
        if(eat_list.isEmpty())
        {
            return 0;
        }
        else
        {
            Fish eat = eat_list.poll();
            shark.eat++;
            if(shark.eat == shark.size)
            {
                shark.size++;
                shark.eat = 0;
            }
            map[shark.row][shark.col] = 0;
            shark.row = eat.row;
            shark.col = eat.col;
            map[shark.row][shark.col] = 9;
            eat_list.clear();
            // System.out.println("이동한 위치 "+shark.row+" "+shark.col+" "+eat.step);
            return eat.step;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        Fish shark = new Fish(0, 0, 2, 0);
        for(int i = 0; i < n; i++)
        {
            for(int j =0 ; j < n; j++)
            {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9)
                {
                    shark.row = i;
                    shark.col = j;
                }
            }
        }
        // System.out.print(shark.row+" "+shark.col);
        int time = 0;
        visited= new boolean[n][n];
        while(true)
        {
            int temp = BFS(map, shark);
            // System.out.println("걸린 시간은 "+temp);
            // for(int i = 0; i < n; i++)
            // {
            //     for(int j = 0 ; j < n ; j++)
            //     {
            //         System.out.print(visited[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            if(temp != 0)
            {
                time += temp;
            }
            else
                break;
        }
        System.out.println(time);
        
    }
}
