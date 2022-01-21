// BOJ - 4344(평균은 넘겠지)

import java.util.Scanner;

public class Main_4344 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		int tc = scan.nextInt();
		for(int t=0;t<tc;t++) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			
			int sum = 0;
			for(int i=0;i<n;i++) {
				int a = scan.nextInt();
				sum += a;
				arr[i] = a;
			}
			
			double avg = (double)sum  / n;
			int cnt = 0;
			for(int i=0;i<n;i++) {
				if(arr[i] > avg)
					cnt++;
			}
			System.out.printf("%.3f", (cnt*100.0)/n);
			System.out.println("%");
		}

		
	}
}
