import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// BOJ - 치킨배달(15686번)
// 구현 + DFS

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class implementation_15686_LSH {
	
	static int ans;
	static List<int[]> home;
	static List<int[]> chicken;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		int[][] map = new int[n][n];
		home = new ArrayList<int[]>();
		chicken = new ArrayList<int[]>();
		
		
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<s.length;j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j] == 2) {
					int[] c = {i, j};
					chicken.add(c);
				} else if(map[i][j] == 1) {
					int[] h = {i, j};
					home.add(h);
				}
			}
		}
		
		
		ans = Integer.MAX_VALUE;
		visited = new boolean[chicken.size()];
		DFS(0, m, 0);
		
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		
	}
	
	public static void DFS(int start, int m, int c) {
		if(c == m) {
			int all_dis = 0;
			for(int i=0;i<home.size();i++) {
				int dis = Integer.MAX_VALUE;
				for(int j=0;j<chicken.size();j++) {
					if(visited[j]) {
						int diff_x = Math.abs(home.get(i)[0] - chicken.get(j)[0]);
						int diff_y = Math.abs(home.get(i)[1] - chicken.get(j)[1]);
						dis = Math.min(dis, diff_x+diff_y);
					}
				}
				all_dis += dis;
			}
			
			ans = Math.min(ans, all_dis);
		}
		
		for(int i=start;i<chicken.size();i++) {
			visited[i] = true;
			DFS(i+1, m,c+1);
			visited[i] = false;
		}
	}

}
