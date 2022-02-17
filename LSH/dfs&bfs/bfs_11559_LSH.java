// BOJ - Puyo Puyo(11559번)
// BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_11559_LSH {
    public static char[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for(int i=0;i<12;i++){
            map[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        while (true){
            boolean run = false;
            for(int i=0;i<12;i++){
                for(int j=0;j<6;j++){
                    if(map[i][j] != '.'){
                        if(puyo(i, j)){
                            run = true;

                        }
                    }
                }
            }

            down();

            if(run){
                ans++;
            } else {
                break;
            }

        }
        System.out.println(ans);

    }

    public static void down(){

        for(int j=0;j<6;j++){
            for(int i=11;i>0;i--){
                if(map[i][j] == '.'){
                    int row = i;
                    while (row > 0){
                        row--;
                        if(map[row][j] != '.'){
                            char temp = map[row][j];
                            map[row][j] = '.';
                            map[i][j] = temp;
                            break;
                        }
                    }
                }
            }
        }
    }

    public static boolean puyo(int x, int y){
        int cnt = 0;
        boolean[][] visited = new boolean[12][6];
        visited[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        cnt++;
        while (!q.isEmpty()){
            Node node = q.poll();
            for(int d=0;d<4;d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];
                if(0 <= nx && nx < 12 && 0 <= ny && ny < 6){
                    if(!visited[nx][ny] && map[nx][ny] == map[x][y]){
                        cnt++;
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                    }
                }
            }

        }

        if(cnt >= 4){
            for(int i=0;i<12;i++){
                for(int j=0;j<6;j++){
                    if(visited[i][j]) map[i][j] = '.';
                }
            }
            return true;
        }
        return false;
    }

}
