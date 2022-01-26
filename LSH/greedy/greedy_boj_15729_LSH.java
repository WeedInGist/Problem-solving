// BOJ - 방탈출 (15729번)
// 그리디(탐욕법)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class greedy_boj_15729 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] room = new int[n+2];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<s.length;i++) {
			room[i] = Integer.parseInt(s[i]);
		}
		
		int cnt = 0;
		for(int i=0;i<n;i++) {
			if(room[i] == 1) {
				cnt++;
				for(int j=i;j<i+3;j++) {
					if(room[j] == 0) {
						room[j] = 1;
					} else {
						room[j] = 0;
					}
				}
			}
			
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		
	}

}
