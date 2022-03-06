package Algo_study.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1520 {
    public static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int count = 1;


    
    
    // d[row][col]의 값을 반환해라
    // d[row][col]의 값이 정해지지 않았으면 구해서 저장한 후 반환해라.
    public static int dfs(int[][] map, int[][] d, int row, int col)
    {
        // row col에서 시작해서 가장 오른쪽 아래까지 도달했다면
        // d[n-1][m-1]은 1이므로 1을 리턴함.
        // 이때 d[row][col]이 갖는 의미는 row col에서 n-1 m-1까지 가는 경우의 수
        // 즉 d[n-1][m-1]은 가장 오른쪽 아래에서 가장 오른쪽 아래까지 가는 경우의 수
        // 자기 자신에게 가는 경우의 수를 말하므로 무조건 1가지임.
        if(row == map.length-1 && col == map[0].length-1)
        {
            return 1;
        }
        // d 이차원 배열은 모두 -1로 초기화가 되어 있음. 이 값이 아닌 다른 값이라면
        // 기존에 내가 방문해서 d 배열의 값을 갱신해줬다는 뜻.
        // 값을 갱신해주었다는 것은 해당 위치에서 목적지까지 도달하는 경우의 수를 이미 구해줬다는 뜻이므로
        // 바로 그 값을 반환함. 이 부분에서 동적 프로그래밍이 적용이 됨.
        if(d[row][col] != -1)
        {
            return d[row][col];
        }
        else
        {
            // 만약 처음 방문하는 것이라면 값을 0으로 바꿔줌. 
            // 왜냐면 -1은 방문하지 않았음을 뜻하는 값이고
            // 방문을 해서 row col 위치에서 갱신을 시작했다면 당연히 경우의 수는 0부터 시작해서 늘어나기 때문에 0으로 설정해줌.
            d[row][col] = 0;
            //사방 탐색 및 dfs 활용을 위한 코드 부분
            for(int i = 0 ; i < 4; i++)
            {
                int next_r = row + directions[i][0];
                int next_c = col + directions[i][1];
                if(next_r >=0 && next_r < map.length && next_c >= 0 && next_c < map[0].length)
                {
                    // 이 문제를 푸는 핵심 점화식의 정수
                    // d[row][col] += d[next_r][next_c];
                    if(map[row][col] > map[next_r][next_c])
                    {
                        // 이미 내가 next_r, next_c의 지점을 탐색을 해서 값을 저장해놨음.
                        if(d[next_r][next_c] != -1)
                        {
                            // 그렇다면 바로 값을 활용해서 더해줌.
                            d[row][col] += d[next_r][next_c];
                        }
                        //어라? 아직 값이 저장이 안 되어있네? 
                        else
                        {
                            // 즉 d[next_r][next_c] 값이 아직 무엇인지 모른다면 그 값을 함수로 찾아서 더해줌.
                            //이 때 혹시 그럼 d[next_r][next_c] 값은 갱신 안 되는 것 아니냐고 생각할 수도 있음.
                            //하지만 함수 dfs(map,d,next_r,next_c)에서 d[next_r}{next_c}를 갱신을 해주고 그 값을 반환하는 것임.
                            d[row][col] += dfs(map,d,next_r,next_c);
                        }
                    }
                }
            }
        }
        // 함수 dfs(map,d,row,col)의 반환 값은 d[row][co]임.
        // 무슨 말이냐면, 함수 dfs(map,d,row,col)은 설령 d[row][col] 값이 아직 갱신 안되어있다 하더라도 재귀적으로
        // 답을 찾을 때까지 자기 자신을 호출하여 답을 구한 후 저장한 뒤에 반환한다는 것임. 
        return d[row][col];
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int row = Integer.parseInt(s[0]);
        int col = Integer.parseInt(s[1]);
        
        
        //입력 받고 이차원 배열 형성
        int[][] map = new int[row][col];
        int[][] d = new int[row][col];

        // 이차원 배열을 채워주되 동적 프로그래밍의 결과를 저장하는 d 배열의 값을 -1로 초기화해줌.
        // -1로 초기화 하는 이유는 dfs에서 더 설명함.
        for(int i = 0 ; i < row; i++)
        {
            s = br.readLine().split(" ");
            for(int j = 0; j < col; j++)
            {
                map[i][j] = Integer.parseInt(s[j]);
                d[i][j] = -1;
            }
        }

        // dfs(map,d,0,0) 이 하는 역할은 결국 d[0][0] 값을 반환하라는 것.
        // 함수를 실행할 때에 d[0][0] 값이 아직 갱신이 안 되어있다면( 아직 -1 값이라면) 
        // 함수가 알아서 재귀함수처럼 실행이 되어 d[0][0] 값을 갱신하고 그 값을 리턴함.
        
        int ans = dfs(map,d,0,0);
        System.out.println(ans);
    }
}
