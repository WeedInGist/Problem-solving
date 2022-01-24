// greedy_boj_11399_JJC

import java.util.*;

public class greedy_boj_11399_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int line[]=new int[n];

		for(int i=0;i<n;i++){
			line[i]=sc.nextInt();
		}
		Arrays.sort(line);
		int result=0;
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=line[i];
			result+=sum;
		}
		System.out.println(result);

		sc.close();
	}
}
