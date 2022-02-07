import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 햄버거 맛은 최대한 유지하면서 정해진 칼로리를 넘지 않는 햄버거 주문
 * 재료를 선택하면 준비해놓은 재료를 그대로 사용하여 조합
 * 입력: 
 * 재료의 수 N, 제한 칼로리 L
 * 재료에 대한 민기의 점수 T_i, 칼로리 K_i
 * 출력:
 * 제한 칼로리 이하의 조합 중 가장 맛에 대한 점수가 높은 햄버거 점수 출력
 */

class Ingredient implements Comparable<Ingredient> {

	int t;
	int k;

	Ingredient(int t, int k) {
		this.t = t;
		this.k = k;
	}

	// 칼로리 순 오름차순
	@Override
	public int compareTo(Ingredient o) {
		if (k - o.k == 0)
			return t - o.t;
		return k - o.k;
	}
}

public class Solution_5215_정호진 {

	static ArrayList<Ingredient> hamburger;
	static ArrayList<Ingredient> ingredients;
	static int N, L;
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt();
			L = sc.nextInt();

			ingredients = new ArrayList<>();
			hamburger = new ArrayList<>();

			
			for (int i = 0; i < N; i++) {
				int t = sc.nextInt();
				int k = sc.nextInt();
				ingredients.add(new Ingredient(t, k));
			}
			Collections.sort(ingredients);
			// == 입력 값 모두 받아옴, 정렬 완료 ==

			sum(0, 0, 0);
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}

	private static void sum(int total, int start, int cnt) {

		if(total > L || cnt == N)
			return;
		
		if (total <= L) {
			int sum = 0;
			for (Ingredient i : hamburger) {
				System.out.println(cnt + "번째, 맛: " + i.t + " 칼로리:" + i.k);
				sum += i.t;
			}
			System.out.println("total: " + total + "\tsum" + sum);
			result = Math.max(result, sum);
		}

		for (int i = start; i < N; i++) {
			hamburger.add(ingredients.get(i));
			total += ingredients.get(i).k;
			sum(total, i+1, cnt+1);	
			total -= ingredients.get(i).k;
			hamburger.remove(hamburger.size()-1);
		}
	}
}
