package Algo_study.Greedy;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

class Point {
    int x,y;
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class Boj_15686 {
    // M 개의 최대 상점 개수
    static int maximum;
    // 지도 사이즈
    static int size;
    // 내가 지금 조합에 넣은 상점인지 아닌지 체크하는 변수
    static boolean[] visited;
    //상점 리스트
    static ArrayList<Point> shop_list = new ArrayList<Point>();
    // 조합 탐색을 위해 조합을 저장해두는 스택
    // 실제로 자료구조 형태가 스택은 아니지만 스택처럼 사용
    static ArrayList<Point> stack = new ArrayList<Point>();
    static int[][] map;
    static int[][] temp_map;
    
    static int chicken_sum = Integer.MAX_VALUE;
    //조합 탐색을 한 뒤 자동적으로 치킨거리의 합을 갱신해주는 재귀 함수
    static void combination(int n, int index)
    {
        if(n == 0 )
        {   //조건을 다 만족했으므로 하나씩 꺼내며 거리 맵 갱신
            // System.out.println("조합 완성");
            // System.out.println(stack.size());
            //새롭게 갱신할 목적으로 임시맵을 초기화해줌.
            for(int i = 1; i <= size; i++)
            {
                Arrays.fill(temp_map[i], Integer.MAX_VALUE);
            }
            //스택에서 하나씩 꺼내면서 검사함.
            for(Point a : stack)
            {
                
                for(int i = 1 ; i <= size; i++)
                {
                    for(int j = 1 ; j <= size; j++)
                    {
                        //주택을 발견했을 때 현재 위치의 치킨집으로부터의 거리를 구하고 그 값이 최소일 경우 갱신함.
                        if(map[i][j] == 1)
                        {
                            int offset = Math.abs(a.x-i)+Math.abs(a.y-j);
                            if(temp_map[i][j] >= offset)
                            {
                                temp_map[i][j] = offset;
                                // System.out.println("변경했습니다. 포인트 "+a.x+" "+a.y+" "+i+" "+j+" "+offset);
                            }
                        }
                    }
                }
            }
            //어떻게 변하는지 볼려고 찍어본 출력문
            // System.out.println();
            // for(int i = 1 ; i <= size; i++)
            // {
            //     for(int j = 1 ; j <= size; j++)
            //     {
            //         if(temp_map[i][j] == Integer.MAX_VALUE)
            //             System.out.print("0 ");
            //         else
            //             System.out.print(temp_map[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            //치킨거리의 합을 갱신해주기 위해 만든 임시 치킨거리합 변수
            int temp = 0;
            for(int i = 1; i <= size; i++)
            {
                for(int j = 1; j <= size; j++)
                {
                    if(temp_map[i][j] != Integer.MAX_VALUE)
                    {
                        temp += temp_map[i][j];
                    }
                }
            }
            //치킨거리합의 최소가 나왔으면 갱신함.
            if(temp <= chicken_sum)
                chicken_sum = temp;
            // System.out.println("조합 완성!");
            return;
        }
        // 조합탐색을 해주며 재귀호출하는 부분. index+1부터 시작하는 것은 중복을 제거하기 위함임.
        // 방문하지 않은 곳이라면 넣고 방문한 곳이면 조합에 넣지 않음.
        //방문하기 전에 스택에 넣는 것은 이해가 되는데 방문이 끝났으면 스택에서 하나 빼줘야함.
        //그리고 방문하지 않았다는 처리를 해주어야 함. 왜냐면 뒤에서 조합을 짤 때를 위해서임. 
        for(int i = index+1 ; i < shop_list.size(); i++)
        {
            if(visited[i] == false)
            {  
                // System.out.println("정상작동중! "+ i +" "+ n);
                // bundle.push(shop_list.get(i));
                stack.add(shop_list.get(i));
                visited[i] = true;
                combination(n-1, i);
                stack.remove(shop_list.get(i));
                // bundle.push(shop_list.get(i));
                visited[i] = false;
            }
        }
      
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        maximum = sc.nextInt();
        int shop_count = 0; 
        map = new int[size+1][size+1];
        temp_map = new int[size+1][size+1];
        for(int i = 1 ; i <= size; i++)
        {
            for(int j = 1 ; j <= size ; j++)
            {
                map[i][j] = sc.nextInt();
                // temp_map[i][j] = Integer.MAX_VALUE;
                if(map[i][j] == 2)
                {
                    shop_list.add(new Point(i,j));
                    shop_count++;
                }
            }
        }
        visited = new boolean[shop_count];
        combination(maximum, -1);
        System.out.println(chicken_sum);
    }
}
