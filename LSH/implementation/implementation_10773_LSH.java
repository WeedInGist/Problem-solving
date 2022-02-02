// BOJ - 제로(10773번)
// 구현, 스택 
import java.io.*;
import java.util.Stack;

public class implementation_10773_LSH {

   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       int k = Integer.parseInt(br.readLine());
       Stack<Integer> stack = new Stack<>();
       int ans = 0;
       for(int i=0;i<k;i++){
           int num = Integer.parseInt(br.readLine());
           if(num == 0){
               if(!stack.empty()){
                   stack.pop();
               }
           } else {
               stack.push(num);
           }
       }

       for(int i=stack.size()-1;i>=0;i--){
           ans += stack.pop();
       }
       bw.write(String.valueOf(ans));
       bw.flush();
       bw.close();
   }
}

