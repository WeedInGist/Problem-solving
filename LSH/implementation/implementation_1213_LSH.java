// BOJ - 팰린드롬 만들기(1213번)
// 구현 - 문자열 처리

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class implementation_1213_LSH {
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int[] str = new int[26];
        
        int mid_Idx = 0;
        int odd = 0;
        for(int i=0;i<s.length();i++) {
        	str[s.charAt(i)-'A'] += 1;
        	
        }
        
        for(int i=0;i<str.length;i++) {
        	if(str[i]%2 == 1) {
        		mid_Idx = i;
        		odd += 1;
        	}
        }
        
        if((s.length() % 2 != 0 && odd > 1) || (s.length()%2 == 0 && odd > 0 )) {
        	bw.write(String.valueOf("I'm Sorry Hansoo"));
        } else {
        	String ans = "";
        	for(int i=0;i<str.length;i++) {
        		for(int j=0;j<str[i]/2;j++) {
        			ans += (char)(i+'A');
        		}
        	}

        	
        	String rever_ans = (new StringBuffer(ans)).reverse().toString();
        	if(odd==1) {
        		ans += (char)(mid_Idx+'A');
        	}
        	
        	bw.write(String.valueOf(ans+rever_ans));
        }
        
        bw.flush();
        bw.close();

    }


}
