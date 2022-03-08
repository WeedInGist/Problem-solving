// BOJ - 최단경로(1753번)
// Dijkstra

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1753 {
    static class Node implements Comparable<Node>{
        int index;
        int distance;

        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance-o.distance;
        }
    }
    public static int INF = (int)1e9;
    public static int[] distance;
    public static int v, e;
    public static ArrayList<ArrayList<Node>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        distance = new int[v];
        Arrays.fill(distance, INF);
        list = new ArrayList<>();
        for(int i=0;i<v;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a-1).add(new Node(b-1, c));
        }

        dijkstra(start-1);
        for(int i=0;i<v;i++){
            if(distance[i] == INF){
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    public static void dijkstra(int start){
        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()){
            Node node = pq.poll();
            if(distance[node.index] < node.distance) continue;
            for(int i=0;i<list.get(node.index).size();i++){
                int cost = node.distance + list.get(node.index).get(i).distance;
                if(cost < distance[list.get(node.index).get(i).index]){
                    distance[list.get(node.index).get(i).index] = cost;
                    pq.offer(new Node(list.get(node.index).get(i).index, cost));
                }
            }
        }
    }
}
