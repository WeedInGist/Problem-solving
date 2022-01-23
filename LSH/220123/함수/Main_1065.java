// BOJ - 1065번(한수)
import java.util.Scanner;

public class Main_1065 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int cnt = 0;
		
		for(int i=1;i<=n;i++) {
			if(i<=99) {
				cnt += 1;
			} else if(i<=999) {
				String[] str = Integer.toString(i).split("");
				if((Integer.parseInt(str[1])-Integer.parseInt(str[0])) == (Integer.parseInt(str[2])-Integer.parseInt(str[1]))){
					cnt += 1;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
