package implementation;

import java.util.Scanner;

public class Imple_boj_2564_HSH {
	
	static final int Nor=1,Eas=2, Sou=3,Wes=4;
	static int N,M;
	static int shops_n;
	static int start;
	static int Mins;
	static boolean maps[];
	
	
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		shops_n = sc.nextInt();
				
		int totalDist = 2*(N+M);
		
		maps = new boolean[totalDist];
		
		for(int i=0; i<=shops_n ; i++) {
			int temp = 0;
			
			if(i==shops_n) {
			switch(sc.nextInt()) {
				case Nor:
					start = sc.nextInt()-1;
					break;
				case Eas:
					start = sc.nextInt()+N-1;				
					break;
				case Sou:
					start = sc.nextInt()+N+M-1;				
					break;
				case Wes:
					start = sc.nextInt()+N+M+N-1;				
					break;
				default:
					break;
				}
			}
			else {
				switch(sc.nextInt()) {
				case Nor:
					temp = sc.nextInt()-1;
					maps[temp] = true;		
					break;
				case Eas:
					temp = sc.nextInt()+N-1;
					maps[temp] = true;
					break;
				case Sou:
					temp = sc.nextInt()+N+M-1;
					maps[temp]=true;
					break;
				case Wes:
					temp = sc.nextInt()+N+M+N-1;
					maps[temp] =true;
					break;
				default:
					break;
				}
			}
		}
		
		for(int i=0;i<totalDist;i++) {
			int dist=0;
			if(maps[i]==true) {
				dist = Math.abs(start-i);
				Mins+=Math.min(dist, totalDist-dist);
			}
			
		}
		
		System.out.println(Mins);
		
		sc.close();
	}

}
