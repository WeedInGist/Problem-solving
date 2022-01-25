// BOJ - A -> B(16953번)
// 그리디(탐욕법)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class greedy_boj_16953_LSH {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);

		int ans = 0;
		while(a!=b) {
			if(b < a) {
				ans = -1;
				break;
			}
			
			if(b%2 != 0 && b%10 != 1) {
				ans = -1;
				break;
			} 


			if(b%10 == 1) {
				ans++;
				b = (b/10);
			}
			else if(b%2 == 0){
				ans++;
				b /= 2;
			}
			
			
		}
		if(ans != -1) {
		bw.write(String.valueOf(ans+1));
		} else {
			bw.write(String.valueOf(ans));
		}
		bw.flush();
		bw.close();
		
	}

}
