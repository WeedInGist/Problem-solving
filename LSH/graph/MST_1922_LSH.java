// BOJ - 네트워크 연결(1922번)
// MST

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MST_1922_LSH {
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
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n];
        StringTokenizer st = null;
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        ArrayList<Node> edges = new ArrayList<>();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Node(a-1, b-1, c));

        }

        Collections.sort(edges);
        int cost = 0;
        for(Node node:edges){
            if(find_parent(node.nodeA) != find_parent(node.nodeB)){
                cost += node.distance;
                union(node.nodeA, node.nodeB);
            }

        }

        System.out.println(cost);
    }

    public static int find_parent(int x){
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
