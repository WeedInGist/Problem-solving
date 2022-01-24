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
		int dif = si[0] - ti[0];
		for (int i = 1; i < n; i++) {
			if (dif > si[i]) {
				dif = si[i] - ti[i];
			} else {
				dif -= ti[i];
			}

		}
		if (dif > 0) {
			System.out.println(dif);
		} else {
			System.out.println("-1");
		}

		sc.close();
	}
}
