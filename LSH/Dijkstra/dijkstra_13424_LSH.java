// BOJ - 비밀 모임(13424번)
// dijkstra

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dijkstra_13424_LSH {
    public static int v, e, k;
    public static final int INF = (int)1e9;
    public static int[] distance;
    static class Node implements Comparable<Node>{
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
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int test_case=1;test_case<=TC;test_case++){
            st = new StringTokenizer(br.readLine(), " ");
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
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
            k = Integer.parseInt(br.readLine());
            int[] friend = new int[k];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0;i<k;i++){
                friend[i] = Integer.parseInt(st.nextToken());
            }
            long ans = INF;
            int ans_idx = -1;
            for(int i=0;i<v;i++){
                distance = new int[v];
                Arrays.fill(distance, INF);
                dijkstra(i);
                long sum = 0;
                for(int j=0;j<k;j++){
                    int index = friend[j];
                    sum += distance[index-1];
                }
                if(ans > sum){
                    ans_idx = (i+1);
                    ans = sum;
                }
            }
            sb.append(ans_idx).append("\n");

        }
        System.out.println(sb.toString());
    }

    public static void dijkstra(int start){
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
    }
}
