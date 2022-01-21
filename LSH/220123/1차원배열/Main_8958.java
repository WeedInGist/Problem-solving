// BOJ - 8958(OX퀴즈)
import java.util.Scanner;

public class Main_8958 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		for(int i=0;i<n;i++) {
			String s = scan.next();
			int[] arr = new int[s.length()];
			int num = 0;
			for(int j=0;j<arr.length;j++) {
				if (s.charAt(j) == 'O') {
					arr[j] = ++num;
				} else {
					num = 0;
					arr[j] = num;
				}
			}
			int sum = 0;
			for(int k=0;k<arr.length;k++) {
				sum += arr[k];
			}
			System.out.println(sum);
		}
		
	}
}
