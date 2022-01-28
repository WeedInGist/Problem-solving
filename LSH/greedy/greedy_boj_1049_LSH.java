// BOJ - 기타줄(1049)
// 그리디
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class greedy_boj_1049_LSH {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		String[] s1 = br.readLine().split(" ");
		int n = Integer.parseInt(s1[0]);
		int m = Integer.parseInt(s1[1]);
		
		int ans = Integer.MAX_VALUE;
		int min_pack = Integer.MAX_VALUE;
		int min_one = Integer.MAX_VALUE;
		
		for(int i=0;i<m;i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			min_pack = Math.min(min_pack, a);
			min_one = Math.min(min_one, b);
			
		}
		
		ans = Math.min(ans, (n/6+1)*min_pack);
		ans = Math.min(ans, min_one*n);
		
		ans = Math.min(ans, (n/6)*min_pack + (n%6)*min_one);
		
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();

		
	}

}
