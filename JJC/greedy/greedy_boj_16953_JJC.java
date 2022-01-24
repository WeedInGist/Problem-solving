// greedy_boj_16953_JJC

import java.util.*;

public class greedy_boj_16953_JJC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int result = 1;
		while (true) {
			if (b == a) {
				break;
			} else if (b < a || (b % 2 == 1 && b % 10 != 1)) {
				result = -1;
				break;
			}
			if (b % 2 == 1 && a != b) {
				b = b / 10;
				result++;
			} else {
				b = b / 2;
				result++;
			}
		}
		System.out.println(result);

		sc.close();
	}
}
