// BOJ - 2908(상수)
// 문자열 뒤집기

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2908 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		a = Integer.parseInt(new StringBuilder().append(a).reverse().toString());
		b = Integer.parseInt(new StringBuilder().append(b).reverse().toString());
		
		System.out.println(a>b?a:b);
	}
}
