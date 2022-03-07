// BOJ - 서강그라운드(14938번)
// 다익스트라 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 다익스트라 방법 -> 이.코.테 책에서 개선된 다익스트라 방법 사용

class Node implements Comparable<Node>{
    int index;
    int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }


    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }

}


public class Dijkstra_BOJ_14938_LSH {
    public static final int INF = (int)1e9;
    public static int n,m,r;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] distance;
    public static int[] item;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // n, m, r 입력받는 부분
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        item = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        // 각 지역마다 가지고 있는 아이템 개수 입력 받음
        // 인접 연결리스트를 사용해서 최단 거리 계산에 이용
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            item[i] = Integer.parseInt(st.nextToken());
        }
        // 문제에서 주어진 각 지역의 범위의 인덱스는 1~n 이므로
        // 인덱스 맞추기 위해 a, b에 1 감소시킨 값으로 인접 연결리스트 생성

        int ans_max = 0;
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a-1).add(new Node(b-1, c));
            graph.get(b-1).add(new Node(a-1, c));
        }
        distance = new int[n];

        // 문제를 구하는 핵심 부분
        // 다익스트라가 start 지점부터 다른 노드들이 제일 가깝게 연결될 수 있는 거리를 구할 수 있음
        // 따라서 모든 0 ~ n-1의 지역들을 start 지점으로 했을 때 다익스트라 돌려줘서
        // 각 지점에 예은이가 낙하산에 떨어진다면
        // m 거리 이하의 갈 수 있는 모든 곳에 아이템을 총 몇 개 수집할 수 있는지를 갯수를 세준 후
        // 최대값 갱신하면 정답을 얻을 수 있음
        for(int i=0;i<n;i++){
            // 시작점과 각 시작점에서 이제 계산될 거리를 위해 distance 배열을 무한대로 초기화
            int start = i;
            Arrays.fill(distance, INF);
            // 다익스트라 돌려줌
            dijkstra(start);
            int sum = 0;
            for(int j=0;j<n;j++){
                // 문제에서 시작점에 있는 곳에서도 아이템을 수집할 수 있다고 주어짐
                if(j == start){
                    sum += item[j];
                    continue;
                }
                // 다익스트라 돌려줬는데도 INF라면 갈 수 없는 곳이므로 아이템 갯수 세어주지 않음
                if(distance[j] == INF){
                    continue;
                }
                // 다익스트라로 도달할 수 있으면서, 그곳이 m 거리 이하에 있는 곳이라면 해당 곳의 아이템 수를 sum에 더해줌
                if(distance[j] <= m){
                    sum += item[j];
                }
            }
            // 정답 출력을 위해 최대값 갱신
            ans_max = Math.max(ans_max, sum);
        }
        System.out.println(ans_max);


    }

    // 다익스트라가 실행되는 함수
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하고, 우선순위 큐에 삽입
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()){ // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대해 정보를 꺼내서
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;
            // 현재 노드가 이미 처리된 적이 있는 곳이라면 무시
            if(distance[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들 확인
            for(int i=0;i<graph.get(now).size();i++){
                int cost = distance[now] + graph.get(now).get(i).distance;
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                // distance 배열 갱신
                if(cost < distance[graph.get(now).get(i).index]){
                    distance[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }
}
