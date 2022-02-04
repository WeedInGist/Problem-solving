// BOJ - 경비원(2564)
// 구현
import java.io.*;


public class implementation_2564_LSH {
    static int dir, x, n, w, h;
    static int ans;
    static int[][] store;
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       String[] str = br.readLine().split(" ");
       w = Integer.parseInt(str[0]);
       h = Integer.parseInt(str[1]);

       n = Integer.parseInt(br.readLine());
       store = new int[n][2];
       for(int i=0;i<n;i++){
           String[] s = br.readLine().split(" ");
           int dir = Integer.parseInt(s[0]);
           int dis = Integer.parseInt(s[1]);
           store[i][0] = dir;
           store[i][1] = dis;
       }

       String[] dong = br.readLine().split(" ");
       dir = Integer.parseInt(dong[0]);
       x = Integer.parseInt(dong[1]);
       ans = 0;
       move();
       bw.write(String.valueOf(ans));
       bw.flush();
       bw.close();


   }

   public static void move(){
       // 북
       if(dir==1){
           for(int i=0;i<n;i++){
               if(store[i][0] == 1){
                   ans += Math.abs(store[i][1]-x);
               } else if(store[i][0] == 2){
                   ans += h + Math.min(x+store[i][1], w-x+w-store[i][1]);
               } else if(store[i][0] == 3) {
                    ans += x + store[i][1];
               } else if(store[i][0] == 4){
                    ans += (w-x)+store[i][1];
               }
           }
       }
       // 남
       else if(dir==2){
           for(int i=0;i<n;i++){
               if(store[i][0] == 1){
                   ans += h + Math.min(x+store[i][1], w-x+w-store[i][1]);
               } else if(store[i][0] == 2){
                   ans += Math.abs(store[i][1]-x);
               } else if(store[i][0] == 3) {
                   ans += (x+h-store[i][1]);
               } else if(store[i][0] == 4){
                   ans += (w-x+h-store[i][1]);
               }
           }
       }
       // 서
       else if (dir==3){
           for(int i=0;i<n;i++){
               if(store[i][0] == 1){
                   ans += (x+store[i][1]);
               } else if(store[i][0] == 2){
                   ans += (h-x + store[i][1]);
               } else if(store[i][0] == 3) {
                   ans += Math.abs(store[i][1]-x);
               } else if(store[i][0] == 4){
                   ans += w + Math.min(x+store[i][1], h-x+h-store[i][1]);
               }
           }

       }
       //동
       else if(dir==4){
           for(int i=0;i<n;i++){
               if(store[i][0] == 1){
                   ans += x + w-store[i][1];
               } else if(store[i][0] == 2){
                   ans += w-store[i][1]+x;
               } else if(store[i][0] == 3) {
                   ans += w + Math.min(x+store[i][1], h-w+h-store[i][1]);
               } else if(store[i][0] == 4){
                   ans += Math.abs(store[i][1]-x);
               }

               }
       }
   }


}
