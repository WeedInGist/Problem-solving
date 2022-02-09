// BOJ - DFS와 BFS(1260)
// DFS, BFS (인접 행렬풀이)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m;
    static boolean[][] connect;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        int v = Integer.parseInt(str[2]);

        visited = new boolean[n+1];
        connect = new boolean[n+1][n+1];
        for(int i=0;i<m;i++){
            String[] data = br.readLine().split(" ");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            connect[a][b] = true;
            connect[b][a] = true;
        }

        dfs(v);
        System.out.println();
        visited = new boolean[n+1];
        bfs(v);

    }

    public static void dfs(int start){
        visited[start] = true;
        System.out.print(start+" ");
        for(int i=1;i<=n;i++){
            if(!visited[i] && connect[start][i]){
                dfs(i);
                }
        }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        System.out.print(start+" ");
        q.offer(start);
        while (!q.isEmpty()){
            int x = q.poll();
            for(int i=1;i<=n;i++){
                if(!visited[i] && connect[x][i]){
                    visited[i] = true;
                    System.out.print(i+" ");
                    q.offer(i);
                }
            }
        }
    }
}
