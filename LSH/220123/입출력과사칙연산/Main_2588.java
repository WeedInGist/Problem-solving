// BOJ 입출력과 사칙연산 - 2588번
import java.util.Scanner;

public class Main_2588 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		
		
		int b_100 = B/100;
		int b_10 = (B%100)/10;
		int b_1 = (B%100)%10;
		
		int C = b_1 * A;
		int D = b_10 * A;
		int E = b_100 * A;
		
		System.out.println(C);
		System.out.println(D);
		System.out.println(E);
		System.out.println(E*100 + D* 10 + C);

	}

}
