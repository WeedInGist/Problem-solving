// BOJ - 최소 스패닝 트리(1197번)
// MST

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MST_1197_LSH {
    public static class Node implements Comparable<Node> {
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
    public static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Node> edges = new ArrayList<>();
        parent = new int[v];
        for(int i=0;i<v;i++){
            parent[i] = i;
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Node(a-1, b-1, c));
        }

        Collections.sort(edges);
        int sum = 0;
        for(Node node:edges){
            if(find_parent(node.nodeA) != find_parent(node.nodeB)){
                sum += node.distance;
                union(node.nodeA, node.nodeB);
            }
        }
        System.out.println(sum);
    }

    public static int  find_parent(int x){
        if(x == parent[x]) return x;
        return parent[x] = find_parent(parent[x]);
    }

    public static void union(int a, int b){
        a = find_parent(a);
        b = find_parent(b);
        if(a < b){
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }


}
