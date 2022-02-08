package Algo_study.Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 문제에서 주는 힌트는 BFS라는 점이다.
// BFS와 DFS의 결정적인 차이는 DFS는 모든 탐색을 끝까지 마치고 다시 탐색을 시작하지만
// BFS는 마치 호숫가에 던져진 돌이 동심원의 물결을 그리듯 주위에서부터 차근차근 탐색한다는 점이다.
// 만약 BFS에서 탐색 방향이 좌하단과 우하단만 정해져있다고 생각해보자.
// 그럼 이 탐색은 마치 트리와 같은 모양이 된다.
//                          1번째 탐색 대상
//                          /           \
//                        2번째        2번째
//                       /    \       /    \
//                    3번째   3번째  3번째 3번째
// 그럼 이 문제를 보자. 처음 시작이 X 라면
//   1차 탐색                     처음 위치 X
//                        /          |         \
//   2차 탐색            X-1         X+1        2*X
//                    /  |   \    /   |  \     /   |  \
//   3차 탐색        a    b    c  d    e   f   g    h   i
//   이런 식으로 X에서부터 도달 가능한 거리는 3의 제곱으로 늘어난다. 
//   BFS는 이 때 도달가능한 위치를 어떤 순으로 탐색할까?
//   답은 X, X-1, X+1, 2*X, a, b, c, d, e, f, g, h, i 순이다.
//   즉, 시작점에서부터 먼 거리 순으로 탐색한다는 것이다.
//  이 때 c가 우리가 찾는 위치라고 해보자. 이 때 X에서 c까지 도달하기 위해 우리는 어떤 연산을 해야될까?
//  답은 X-> X-1, X-1 -> c 이 두번의 연산을 거쳐야 한다. 즉 2초가 지나면 X에서 c까지 도달할 수 있다는 얘기이다.
//  그럼 우리는 무슨 연산을 했는지는 알 필요 없지만 몇번의 연산을 했는지 어떻게 알 수 있을까?
//  이것은 BFS만 잘해서는 풀 수 없고 추가적인 클래스를 하나 만들어주어야 한다.

// 탐색을 할 때 위치 정보를 기준으로 탐색하지만 그와 동시에 몇 세대인지도 체크해주는 것이다.
// 맨 처음 지점 X를 0세대라고 하자. 그럼 X로부터 파생된 X-1, X+1, 2*X 는 모두 1세대가 된다.
// 이러한 정보를 저장해주기 위해 Generation이라는 클래스를 만들었다.
// x에는 위치값이 담기며 g에는 세대 값이 담긴다. 
class Generation{
    int x;
    int g;
    Generation(int x, int g)
    {
        this.x = x;
        this.g = g;
    }
}

public class Boj_1697 {
    
    // 현재 방문한 위치를 체크해주는 1차원 배열
    // 왜 1차원 탐색에서도 방문했는지 체크해주는 1차원 배열이 필요할까?
    // 정답은 방문한 곳을 다시 방문할 때 그 행동은 명확한 낭비이기 때문이다.
    // X에서 X+1로 갔다 치자. 근데 다시 X+1에서 X로 갔다면, 시간은 2초 흘렀지만 문제는 전혀 해결되지 않았다.
    // 이러한 경우 도달하는데까지 최소한의 시간을 구하자는 문제의 취지에 부합하지 않기 때문에
    // 이전에 방문한 곳을 다시 방문하지 않기 위해 체크해주는 것이다. 물론 무한 루프에 빠지기 때문이기도 하다.
    static boolean[] visited = new boolean[100001];
    
    // 이제 본격적으로 너비우선탐색을 진행할 것이다. 인자로는 시작점 x와 탐색이 끝나야 하는 점 y가 주어진다.
    public static void BFS(int x, int y)
    {
        //이전에 와본 곳이라면 종료한다. 이 구문은 사실 필요없는 구문이긴 하다. 문제에서 x,y 준 값을 그대로 대입하기 때문.
        if(visited[x] == true)
        {
            return;
        }
        // 현재 위치 x로부터 갈 수 있는 곳들을 다음으로 탐색할 순서대로 저장해놓는 큐에 집어넣는다.
        else
        {
            //탐색 순서를 저장하는 큐를 생성해준다.
            Queue<Generation> queue = new LinkedList<Generation>();
            //방문한 곳을 체크해준다.
            visited[x] = true;
            //이 코드는 처음 탐색 X에서만 쓰이는 코드이고 따라서 당연히 세대는 0세대이다. 
            int generation = 0;
            // 맨 처음 탐색으로 보는 지점 X를 0세대라고 표시해놓으며 큐에 넣는다.
            queue.add(new Generation(x, generation));
            //이후 기존의 BFS와 같이 큐에서 하나씩 꺼내며 조사할 곳을 큐에 넣는다.
            while(queue.isEmpty()==false)
            {
                //현재 내가 탐색할 위치를 큐에서 꺼낸다.
                Generation location = queue.poll();
                //만약 현재 내가 탐색하는 위치가 도착지와 같다면
                if(location.x == y)
                {
                    //탐색하는 위치가 몇 세대인지 출력하고 종료한다.
                    //만약 0세대 라면 문제에서 준 X값과 Y값이 같다는 뜻이고
                    //2세대라면 2번의 연산을 거쳐 X에서 Y로 도달했다는 뜻이다.
                    System.out.println(location.g);
                    return;
                }
                //내가 탐색하는 위치가 도착지와 다르다면, 추가 탐색이 필요하므로 인접한 탐색 위치를 큐에 넣는다.
                else
                {
                    //다음 탐색의 위치는 현재 위치에서부터 -1, +1, X2 이다.
                    int[] next_x = new int[]{location.x-1, location.x+1, 2*location.x};
                    for(int i =0; i < 3; i++)
                    {
                        //다음 탐색할 위치가 문제에서 준대로 옳바른 범위인지 확인한다.
                        if (0 <=next_x[i] && next_x[i] <= 100000)
                        {
                            //이전에 방문하지 않은 곳이라면, 즉 처음 와본 곳이라면
                            if(visited[next_x[i]] == false)  
                            {
                                //이제 방문했다는 표시를 해준다.
                                visited[next_x[i]]= true;
                                //그리고 탐색을 위해 큐에 넣어준다.
                                //이 때 중요한 점은 현재 g 세대인 지점에서 탐색했으므로
                                // g 세대에서 탐색할 수 있는 세대는 g+1 세대라는 점이다.
                                // 따라서 큐에 넣어줄 때 세대를 location.g+1로 정해주었다.
                                // 1세대에서 탐색해서 갈 수 있는 지점은 2세대이기 때문인 것처럼.
                                queue.add(new Generation(next_x[i], location.g+1));
                            }
                        }
                    }

                }
            }
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        BFS(x,y);

    }
}
