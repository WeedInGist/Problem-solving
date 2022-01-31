// implementation_boj_2636_JJC

import java.util.*;

public class implementation_boj_2636_JJC {
    static int[] dx = { -1, 0, 1, 0 }; // 4방향 행이동
    static int[] dy = { 0, 1, 0, -1 }; // 4방향 열이동
    static int m, n; // 가로, 세로 크기
    static int[][] map; // 치즈 모양
    static boolean[][] out; // 치즈 모양에서 바같쪽 영역 구분

    public static void dfs(int x, int y) { // 바같쪽 공기와 접촉한 치즈의 값을 2로 변경
		for (int i = 0; i < 4; i++) { // 4방 탐색
			int row = x + dx[i];
			int col = y + dy[i];

			if (row >= 0 && col >= 0 && row < m && col < n) { // 배열 안인지 검사
                if (!out[row][col]) { // 탐색하지 않은 위치라면 실행
                    out[row][col] = true; 
                    if (map[row][col] == 1) { // 바같쪽 공기와 맞다은 치즈의 값을 2로 변경
                        map[row][col] = 2;
                    } else { // 
                        dfs(row, col);
                    }
                }
			}
		}
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[m][n]; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt(); 
            }
        } // 입력 종료

        out = new boolean[m][n];

        int result = 0; // 완전히 녹기까지 걸리는 시간
        int count = 0; // 현재 치즈의 개수
        int pre =0; // 직전 수행의 치즈의 개수

        for (int i = 0; i < m; i++) { // 처음부터 치즈가 없을 수 있으니 한번 탐색;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
        pre=count; 

        while (count>0) { // 탐색 후 치즈가 없었으면 반복을 실행하지 않는다.

            count=0; // 치즈개수를 다시 count

            for (int i = 0; i < m; i++) { // out 배열값 false로 초기화
                for (int j = 0; j < n; j++) {
                    out[i][j] = false;
                }
            } 

            dfs(0,0); // (0, 0)은 무조건 바깥쪽 공기이르로 (0,0)부터 탐색 

            for (int i = 0; i < m; i++) { //탐색을 마치면 바깥쪽 공기와 접촉한 치즈를 녹인다.
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 2) {
                        map[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < m; i++) { // 한시간 후 치즈 개수를 카운트
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        count++;
                    }
                }
            }

            result++; // 한시간이 지났으므로 걸리는 시간 증가
            if (count == 0) { // 모든 치즈가 녹았으면 반복문을 빠져나온다.
                break;
            }
            
            pre =count; // 치즈가 남아있다면 반복전에 치즈의 개수 저장
        }

        // System.out.println(); // 한시간 후 치즈 print
        // for (int i = 0; i < m; i++) { 
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(result);
        System.out.println(pre);

        sc.close();
    }
}