// Graph_BOJ_14950_정복자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MST_BOJ_14950_JJC {
    static int N, M, t, result;
    static int[] parent;
    static ArrayList<Edge> edges;

    static class Edge {
        int nodeA, nodeB, distance;

        public Edge(int nodeA, int nodeB, int distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }
    }

    static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a > b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /* ==========input========== */
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        edges = new ArrayList<>();
        for (int i = 1; i <= N; i++)
            parent[i] = i;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }
        /* ==========sol========== */
        edges.sort((Comparator.comparingInt(o -> o.distance))); // 크루스칼 알고리즘을 사용하기 위해 간선을 거리순으로 정렬
        result=0;
        int count=0;
        for (int i = 0; i < M; i++) {
            int a = edges.get(i).nodeA;
            int b = edges.get(i).nodeB;
            int c = edges.get(i).distance;
            if(findParent(a)!=findParent(b)){ // 거리가 가장 작은 간선부터 순환하지 않으면 간선을 이어주며 정복해 나간다.
                union(a,b);
                result+=c; // 각 도시의 정복 비용 증가
                result+=(count++)*t; // 방법 1: 정복을 할때마다 추가 비용계산
            }
        }
//        if(N>=3) // 방법 2: 점화식 - N이 1이나 2면 추가비용이 없으며 3이상이면 발생하는 추가비용을 더해준다.
//            result+=(N-1)*(N-2)/2*t;

        /* ==========output========== */
        System.out.println(result);
        br.close();
    }
}