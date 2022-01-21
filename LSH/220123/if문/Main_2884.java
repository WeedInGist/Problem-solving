// BOJ - 2884번(알람시계) 
import java.util.Scanner;

public class Main_2884 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int m = scan.nextInt();
		
		if(m >= 45) {
			System.out.println(h +" " + (m-45));
		} else{
			if(h == 0) {
				System.out.println(23 + " " + (60-(45-m)));
			} else {
				System.out.println((h-1) + " " + (60-(45-m)));
			}
		}
		
	}

}
