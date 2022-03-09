// BOJ - 특정한 최단 경로(1504번)
// dijkstra

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dijkstra_1504_LSH {
    public static int v, e;
    public static final int INF = (int)1e9;
    static class Node implements Comparable<Node> {
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


    public static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        if(e==0){
            System.out.println(-1);
            return;
        }

        graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a-1).add(new Node(b-1, c));
            graph.get(b-1).add(new Node(a-1, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] distance1;
        int[] distance2;
        int[] distance3;
        distance1 = dijkstra(0);
        distance2 = dijkstra(x-1);
        distance3 = dijkstra(y-1);

        long ans = Math.min(distance1[x-1]+distance2[y-1]+distance3[v-1], distance1[y-1]+distance3[x-1]+distance2[v-1]);


        if(ans >= INF){
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static int[] dijkstra(int start){
        int[] distance = new int[v];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()){
            Node node = pq.poll();
            if(distance[node.index] < node.distance) continue;

            for(int i=0;i<graph.get(node.index).size();i++){
                int cost = node.distance + graph.get(node.index).get(i).distance;
                if(cost < distance[graph.get(node.index).get(i).index]){
                    distance[graph.get(node.index).get(i).index] = cost;
                    pq.offer(new Node(graph.get(node.index).get(i).index, cost));
                }
            }
        }
        return distance.clone();
    }
}
