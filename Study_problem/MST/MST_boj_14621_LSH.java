// BOJ - 나만 안되는 연애(14621번)
// MST

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_14621 {
    public static class Node implements Comparable<Node>{
        int nodeA;
        int nodeB;
        int distance;
        public Node(int nodeA, int nodeB, int distance){
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    public static int n, m;
    public static String[] university;
    public static ArrayList<Node> edges;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        university = br.readLine().split(" ");
        edges = new ArrayList<>();
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        // 간선에 대한 정보 받기
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 여대 - 남대만 연결될 수 있기 때문에
            // 같은 성별의 대학의 경우 연결될 필요 없음
            if(!university[a-1].equals(university[b-1])) {
                edges.add(new Node(a - 1, b - 1, c));
            }
        }

        // 간선을 비용 순으로 정렬
        Collections.sort(edges);
        int ans_cost = 0;
        int cnt = 0;
        // 간선을 하나씩 확인
        for(int i=0;i<edges.size();i++){
            int cost = edges.get(i).distance;
            int a = edges.get(i).nodeA;
            int b = edges.get(i).nodeB;
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if(findParent(a) != findParent(b)){
                unionParent(a, b);
                ans_cost += cost;
                cnt++;

            }
        }

        // 조건에 모든 대학교가 연결되어야 한다고 했으므로
        // 만약 최소 스패닝 트리로 만들어지긴 했지만 모든 대학이 포함되지 않은 경우가 있으면
        // 사심 경로가 아니므로 -1 출력
        if(cnt != n-1){
            System.out.println(-1);
        } else {
            System.out.println(ans_cost);
        }

    }

    // 특정 원소가 속한 집합 찾기
    public static int findParent(int x){
        // 루트노드가 아니라면 루트 노드를 찾을 때까지 호출
        if(x== parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b){
        int parentA = findParent(a);
        int parentB = findParent(b);
        if(parentA < parentB){
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }

    }


}
