// BOJ - ATM(11399번)
// 그리디(탐욕법), Sort

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class greedy_boj_11399_LSH {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		String s1 = br.readLine();
		int n = Integer.parseInt(s1);
		int[] person = new int[n];
		
		
		
		
			String[] s = br.readLine().split(" ");
			for(int i=0;i<n;i++) {
				person[i] = Integer.parseInt(s[i]);
			}
		
		
		int ans = 0;
		int[] time = new int[n];
		Arrays.sort(person);
		for(int i=0;i<n-1;i++) {
			person[i+1] += person[i];
		}
		for(int i=0;i<n;i++) {
			ans += person[i];
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		
	}

}
