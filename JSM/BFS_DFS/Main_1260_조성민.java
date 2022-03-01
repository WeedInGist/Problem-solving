package Algo_study.Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// BFS -> 넓이우선탐색 너비우선탐색 처음 시작점에서 같은 거리순으로 퍼져나간다.
// DFS 의 필요성 
// 결국에는 모든 위치들을, 노드들을 순회하기 위해서 만들어진건데
// 그 방식에 좀 차이가 있는 거에요.
                    
            //    1 1 1 1 1 1
            //    1 1 1 1 1 1
            //    1 1 1 1 1 1
            //    1 1 1 1 1 1
//                1 1 1 1 1 1
//                1 1 1 1 1 1 호수에 돌을 던져서 물결이 퍼져나가듯이 조사하는게 BFS
//          DFS -> 끝까지 한번 가보자. 그게 어디가 됐든.
//          막혔다? 그럼 선택지가 있던 때로 돌아가면 그만이야 
public class Main_1260_조성민 {
    static Queue<Integer> queue = new LinkedList<Integer>();
    static boolean[] visited;
    static boolean[] visited1;
    static ArrayList<Integer> stack = new ArrayList<>();
    static int count = 0;
    static void DFS(int x, int[][] map, int n)
    {
        visited[x] = true;
        System.out.print((x+1)+" ");
        for(int j = 0; j < n; j++)
        {
            if( map[x][j] == 1 && visited[j] == false)
            {  
                DFS(j,map,n);
            }
        }
    }
// 4 5 1  4는 노드들의 개수, 뒤에 5는 노드들을 잇는 관계의 수, 마지막 1은 탐색을 시작할 노드 번호
// 1 2    //노드 1, 노드 2, 노드 3, 노드 4
// 1 3
// 1 4
// 2 4
// 3 4
// 2차원 배열, 또는 ArrayList를 활용한 인접리스트 
//          //int x => 노드 번호를 뜻함
//         x가 1이라면, 1번부터 시작해서 탐색을 하겠음.
//        map 변수 -> 노드들간의 관계를 말하는 2차원 배열
//        n => 노드들의 개수
//   BFS(1, map, 4); -> 탐색은 1번 노드부터 할 것, 관계 2차원 배열은 map로 줄거고 노드의 총 개수는n
   // boolean[] visited1 = new visited1[n+1];
   // static Queue<Integer> queue = new LinkedList<Integer>();
    public static void BFS(int x, int[][] map, int n)
    {
        //x번 노드에 방문을 했는지 안했는지 체크하는 배열
        visited1[x] = true;
        //x번을 검사할 목록에 올려놓았음. 선입선출
        queue.add(x); //BFS에서 모든 탐색은 큐에서 진행될 예정이라서 첫번쨰 노드도 반드시 큐에 넣기
        while(queue.isEmpty() == false)
        {
            int a = queue.poll(); 
            System.out.print(a+" ");
            for(int j=0; j < n; j++)
            {
                
                if(map[a][j] == 1 && visited1[j] == false)
                {
                    visited1[j] = true;
                    queue.add(j); // -> 이제 큐에 2,3,4
                }
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n, m, v;
        n = sc.nextInt();
        visited= new boolean[n];
        visited1= new boolean[n];
        m = sc.nextInt();
        v = sc.nextInt()-1; // 노드 1번을 index 계산을 위해 1씩 빼줌.
        int[][] map = new int[n+1][n+1]; // 노드 1번은 배열에서 0번
        for(int i=0; i < m; i++)
        {
            int r =sc.nextInt()-1; // 노드들의 번호를 받아서 연결해줌.
            int c = sc.nextInt()-1;
            map[r][c] = 1;
            map[c][r] = 1;
        }

// 4 5 1      1 2 3 4
// 1 2      0 0 0 0 0  BFS queue라는 자료구조를 활용 -> 내가 탐색해볼 대상을 집어놓고 나중에 탐색할때
// 1 3    1 0 0 1 1 1     <-  queue <-                       꺼내서 볼거임. 
// 1 4    2 0 1 0 0 1 
// 2 4    3 0 1 0 0 1
// 3 4    4 0 1 1 1 0
        // for(int i =0 ; i < n ; i++)
        // {
        //     for(int j = 0 ; j < n ; j++)
        //     {
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        DFS(v,map, n);
        System.out.println();
        BFS(v,map, n);
        
    }
}
