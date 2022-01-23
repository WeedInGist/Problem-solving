// BOJ - 1316(그룹 단어 체커)
import java.util.Scanner;

public class Main_1316 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int cnt = 0;
		for(int i=0;i<n;i++) {
			String s = scan.next();
			if(solve(s)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static boolean solve(String s) {
		int pre = 0;
		boolean[] check = new boolean[26];
		for(int j=0;j<s.length();j++) {
			int now = s.charAt(j);
			if(pre != now) {
				if(!check[now-'a']) {
					check[now-'a'] = true;
					pre = now;
				}  else {
					return false;
				}
			} 
		}
		return true;
	}

}
