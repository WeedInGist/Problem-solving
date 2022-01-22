// SW Expert Academy - 1907 (모래성쌓기)
// 2차원 배열로 풀이 => 실제는 queue랑 시간복잡도 고려해서 풀어야함
import java.util.Scanner;

public class Main_1907 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
		int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
		
		int tc = scan.nextInt();
		for(int t=0;t<tc;t++) {
			int h = scan.nextInt();
			int w = scan.nextInt();
			int[][] map = new int[h][w];
			boolean[][] check = new boolean[h][w];
			for(int i=0;i<h;i++) {
				String s= scan.next();
				for(int j=0;j<w;j++) {
					map[i][j] = s.charAt(j) - '0';
				}
				
			}
			
			int answer = 0;
			int cnt = 0;
			while(true) {
				for(int i=0;i<h;i++) {
					for(int j=0;j<w;j++) {
						if(map[i][j] != 0) {
							int zero = 0;
							for(int k=0;k<8;k++) {
								int nx = i + dx[k];
								int ny = j + dy[k];
								if(nx >= 0 && nx < h && ny >= 0 && ny < w) {
									if(map[nx][ny] == 0)
										zero++;
								}
							}
							
							if(zero >= map[i][j]) {
								check[i][j] = true;
								cnt++;
							}	
						}
					}
				}
				
				for(int i=0;i<h;i++) {
					for(int j=0;j<w;j++) {
						if(check[i][j])
							map[i][j] = 0;
					}

				}
	
			if(cnt > 0) {
				answer++;
				cnt = 0;
			} else {
				break;
			}
			}
			
			System.out.println(answer);
		}
		
		

	}

}
