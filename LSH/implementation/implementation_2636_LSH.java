// BOJ - 치즈(2636)
// 구현 + BFS
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class implementation_2636_LSH {
   public static int cheese_cnt = 0;
   public static int time = 0;
   public static int[][] map;
   public static int[] dx = {-1, 1, 0, 0};
   public static int[] dy = {0, 0, -1, 1};
   public static class Node{
       public int x;
       public int y;
       public Node(int x, int y){
           this.x = x;
           this.y = y;
       }
   }
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       String[] str = br.readLine().split(" ");
       int n = Integer.parseInt(str[0]);
       int m = Integer.parseInt(str[1]);
       map = new int[n][m];
       for(int i=0;i<n;i++){
           String[] s = br.readLine().split(" ");
           for(int j=0;j<s.length;j++){
               map[i][j] = Integer.parseInt(s[j]);
           }
       }

       while (true){
           boolean result = Check(n, m);
           if(result){
               break;
           }

           bfs(n, m);
           time++;

       }

       bw.write(String.valueOf(time+"\n"));
       bw.write(String.valueOf(cheese_cnt));
       bw.flush();
       bw.close();


   }

   public static boolean Check(int n, int m){
       int cnt = 0;
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(map[i][j] == 1){
                   cnt++;
               }
           }
       }

       if(cnt > 0){
           cheese_cnt = cnt;
           return false;
       } else{
           return true;
       }

   }

   public static void bfs(int n, int m){
       Queue<Node> queue = new LinkedList<>();
       boolean[][] visited = new boolean[n][m];
       queue.add(new Node(0, 0));
       visited[0][0] = true;
       while(!queue.isEmpty()){
           Node nd = queue.poll();
           int x = nd.x;
           int y = nd.y;
           for(int k=0;k<4;k++){
               int nx = x + dx[k];
               int ny = y + dy[k];
               if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                   if(!visited[nx][ny]){
                       if(map[nx][ny] == 1){
                           map[nx][ny] = 0;
                           visited[nx][ny] = true;
                       } else if(map[nx][ny] == 0){
                            queue.add(new Node(nx, ny));
                            visited[nx][ny] = true;
                       }
                   }
               }
           }

       }

   }
}
