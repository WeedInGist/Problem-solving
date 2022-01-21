// BOJ - 1110번(더하기 사이클)
import java.util.Scanner;

public class Main_1110 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int origin = n;
		int cnt = 0;
		while(n >= 0 && n <= 99) {
			int a = 0;
			int b = 0;
			if(n < 10) {
				a = 0;
				b = n;
				
			} else {
				a = n / 10;
				b = n % 10;
			}
			int sum = a+b;
			n = (b*10+sum%10);
			cnt++;
			
			if(n == origin) {
				System.out.println(cnt);
				break;
			}

		}
	}

}
