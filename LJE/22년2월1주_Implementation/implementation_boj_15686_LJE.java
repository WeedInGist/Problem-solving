package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implementation_boj_15686_LJE {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [][] map = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=n;j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
			System.out.print(map[i][j]);	
				
			}
			System.out.println();
		}
	}

}
