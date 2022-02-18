// BOJ - 촌수계산(2644번)
// BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_2644_LSH {
    public static int n, s, e, m;
    public static LinkedList<LinkedList<Integer>> list;
    public static boolean[] visited;
    public static class Node {
        int num;
        int dis;
        public Node(int num, int dis){
            this.num = num;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");
        s = Integer.parseInt(data[0]);
        e = Integer.parseInt(data[1]);
        m = Integer.parseInt(br.readLine());
        list = new LinkedList<>();
        for(int i=0;i<n+1;i++){
            list.add(new LinkedList<>());
        }


        for(int i=0;i<m;i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited = new boolean[n+1];
        System.out.println(bfs(s, e));

    }

    public static int bfs(int start, int end){
        Queue<Node> q = new LinkedList<>();
        visited[start] = true;

        q.add(new Node(start, 0));
        while (!q.isEmpty()){
            Node node = q.poll();
            if(node.num == end){
                return node.dis;
            }
            for(int node_idx:list.get(node.num)){
                if(!visited[node_idx]){
                  visited[node_idx] = true;
                  q.offer(new Node(node_idx, node.dis+1));
                }
            }
        }

        return -1;

    }
}
