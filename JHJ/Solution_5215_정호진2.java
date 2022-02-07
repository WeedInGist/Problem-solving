import java.util.Scanner;

public class Solution_5215_정호진2 {

	static int N, L;
	static int result = Integer.MIN_VALUE;
	static int[][] arr;
	static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			L = sc.nextInt();
			isSelected = new boolean[N];
			arr = new int[N][2];

			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			generateSubSet(0);
			System.out.println("#" + test_case + " " + result);
		}
	}

	public static void generateSubSet(int cnt) {
		if (cnt == N) {
			int sumScore = 0;
			int sumCal = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					//System.out.print(arr[i][0] + " " + arr[i][1]+ "\t");
					sumScore += arr[i][0];
					sumCal += arr[i][1];
				}
			}
			
			if(sumCal <= L) {
				//System.out.println("sumCal : " + sumCal );
				result = Math.max(sumScore, result);
			}
			return;
		}

		else {
			isSelected[cnt] = true;
			generateSubSet(cnt + 1);
			isSelected[cnt] = false;
			generateSubSet(cnt + 1);
		}
	}

}
