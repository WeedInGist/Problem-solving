// BOJ - 1152(단어의 개수)
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		StringTokenizer st = new StringTokenizer(s, " ");
		System.out.println(st.countTokens());
	}
}
