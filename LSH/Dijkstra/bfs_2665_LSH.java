// BOJ - 미로만들기(2665번)
// BFS + Dijkstra
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_2665_LSH {
    public static int n;
    public static int[][] map;
    public static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] arags) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        map = new int[n][n];
        visited = new int[n][n];

        for(int i=0;i<n;i++){
            String[] data = br.readLine().split("");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(data[j]);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(0, 0);
        System.out.println(visited[n-1][n-1]);

    }

    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[0][0] = 0;
        while (!q.isEmpty()){
            Node node = q.poll();
            for(int d=0;d<4;d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];
                if(0<=nx && nx < n && 0 <= ny && ny <n){
                    if(visited[nx][ny] > visited[node.x][node.y]){
                        if(map[nx][ny] == 1){
                            visited[nx][ny] = visited[node.x][node.y];
                            q.add(new Node(nx, ny));
                        } else {
                            visited[nx][ny] = visited[node.x][node.y] + 1;
                            q.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }
    }


}
