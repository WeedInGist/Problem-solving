// greedy_boj_1263_JJC

import java.util.*;

public class greedy_boj_1263_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int ti[] = new int[n];
		int si[] = new int[n];
		for (int i = 0; i < n; i++) {
			ti[i] = sc.nextInt();
			si[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (si[i] < si[j]) {
					int tmp = si[i];
					si[i] = si[j];
					si[j] = tmp;
					tmp = ti[i];
					ti[i] = ti[j];
					ti[j] = tmp;
				}
			}
		}
		boolean success = true;
		for (int i = 0; i < n; i++) {
			if (ti[i] > si[i]) {
				success = false;
			}
		}
		if (success) {
			System.out.println(si[0] - ti[0]);
		} else {
			System.out.println("-1");
		}

		sc.close();
	}
}
