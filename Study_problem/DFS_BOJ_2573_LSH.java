// BOJ - 빙하(2573번)
// DFS 구현
// 메모리 : 135940KB, 시간 :	524ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFS_BOJ_2573_LSH {
    public static int[][] map;
    public static int n, m;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        n = Integer.parseInt(data[0]);
        m = Integer.parseInt(data[1]);
        map = new int[n][m];
        // map에 대한 정보를 받는 부분
        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean check = false;
        int year = 0;
        while (true){
            // 만약 map에 얼음이 존재하지 않는다면 --> true 값이므로 check= true로 변경해주고 while문 빠져나오기

            if(check()){
                check = true;
                break;
            }
            // 1년이 증가
            // down()을 통해 얼음의 양 감소 처리
            year++;
            down();
            // ice는 얼음덩어리의 갯수를 체크 해줌
            int ice = 0;
            // dfs에서 방문 처리를 체크할 visited 배열
            visited = new boolean[n][m];
            // map을 돌면서 dfs룰 통해 아직 방문처리 되지 않고, 얼음이라면 얼만큼 얼음이 이어진지 처리
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j] > 0 && !visited[i][j]){
                        ice++;
                        dfs(i, j);


                    }
                }
            }
            // dfs를 통해 얼음 덩어리의 갯수가 2 이상이라면 while문 빠져나가게 됨
            if(ice>= 2){
                break;
            }


        }

        // 위에 check()라는 함수를 통해서 만약 아직 덩어리가 2개 이상으로 쪼개지지 않았는데 map에 얼음이 존재하지 않는 상태
        // check가 true 라면 0 출력
        if(check){
            System.out.println("0");
        } else {
            System.out.println(year); // while을 통해 증가시킨 year 값 출력
        }

    }
    // dfs 함수로 하나의 얼음덩어리를 만나면 체크
    public static void dfs(int x, int y){
       visited[x][y] = true;
       for(int d=0;d<4;d++){
           int nx = x + dx[d];
           int ny = y + dy[d];
           if (0 <= nx && nx < n && 0 <= ny && ny < m) {
               // 상,하,좌,우로 얼음덩이리가 있다면 재귀를 들어가면서 탐색
               if(map[nx][ny] > 0 && !visited[nx][ny]) dfs(nx, ny);
           }
       }
    }

    // copy라는 배열을 통해 1년동안 바다 상,하,좌,우에 있는 얼음이 주변에 바다가 있는 만큼 얼음양 감소
    // 감소는 1년 안에 일어나기 때문에 copy라는 새로운 배열에 변경된 값 넣어줌
    // 그리고 마지막에 실제 map에 값을 바꿔줘야함
    public static void down(){
        int[][] copy = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int zero_cnt = 0;
                // 만약 map 행, 열 돌면서 얼음이 있다면
                if(map[i][j] > 0) {
                    // 상,하,좌,우로 돌면서 해당 위치의 4방향에 얼만큼 바다가 있는지 카운트
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                            if (map[nx][ny] == 0) zero_cnt++;
                        }
                    }
                    //만약 현재 자기가 가진 얼음양보다 바다의 개수가 더 많으면 0으로 값
                    //아니면 자기가 가진 얼음의 양 - 바다의 갯수
                    if(map[i][j] < zero_cnt){
                        copy[i][j] = 0;
                    } else {
                        copy[i][j] = (map[i][j] - zero_cnt);
                    }
                }

            }
        }
        // 마지막으로 copy 배열을 실제 map 2차원 배열에 값을 copy 해줌
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = copy[i][j];
            }
        }
    }

    // 바다에 얼음이 존재하는지 체크하는 함수
    // 만약 한 곳이라도 얼음이 존재한다면 false 반환
    // 만약 얼음이 다 사라졌다면 true 반환
    public static boolean check(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] > 0) return false;
            }
        }
        return true;
    }
}
