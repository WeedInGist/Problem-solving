// greedy_boj_15729_JJC

import java.util.*;

public class greedy_boj_15729_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] button = new boolean[n + 2];
		for (int i = 0; i < n; i++) {
			if (sc.nextInt() == 1) {
				button[i] = true;
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			if (button[i] == true) {
				result++;
				button[i] = !button[i];
				button[i + 1] = !button[i + 1];
				button[i + 2] = !button[i + 2];
			}
		}
		System.out.println(result);

		sc.close();
	}
}
