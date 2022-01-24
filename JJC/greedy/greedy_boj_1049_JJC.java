// greedy_boj_1049_JJC

import java.util.*;

public class greedy_boj_1049_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] pack = new int[m];
		int[] one = new int[m];

		for(int i=0;i<m;i++){
			pack[i] = sc.nextInt();
			one[i] = sc.nextInt();
		}
		Arrays.sort(pack);
		Arrays.sort(one);

		int result= pack[0]*(n/6)+one[0]*(n%6);
		if(result>pack[0]*(n/6+1)){
			result=pack[0]*(n/6+1);
		}
		if(result>one[0]*n){
			result=one[0]*n;
		}
		
		System.out.println(result);

		sc.close();
	}
}
