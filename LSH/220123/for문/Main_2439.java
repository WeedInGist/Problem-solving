// BOJ - 2439(별 찍기 -2)
import java.util.Scanner;

public class Main_2439 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=n-1;j>=0;j--) {
				if(j<=i)
					System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		
		
	}

}
