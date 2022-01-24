import java.util.Scanner;

public class greedy_bj_16953 {

	public static void main(String[] args) {
		// ** A -> B 가 아닌 B -> A 로 생각해본다.
		// 1. 뒷자리가 1이면 - 1을 제거한다.
		// 2. 뒷자리가 짝수면 - 2로 나눠준다.
		// 3. 그외 뒷자리가 1을 제외한 홀수 이면서, 여전히 A < B이고,
		//    1과 2의 방법으로 제거해줄 수 없는 경우, A = B 가 될 수 없다.
		// 		i.e. 2 53
		// 4. A > B라는 것은 이제 B를 아무리 1과 2의 방법으로 계산해 주어도
		//    A==B가 같을 수 없다는 것을 의미한다. 
		// 		i.e. 26 51 일때  B 값의 변화 과정(51 - 50 - 25)
		// 5. A == B 이면 끝

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		int cnt = 1;
		while (true) {
			if (A == B)
				break;
			else if (A > B) {
				cnt = -1;
				break;
			}
			if (B % 10 == 1)
				B /= 10;
			else if (B % 2 == 0)
				B /= 2;
			else {
				cnt = -1;
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}