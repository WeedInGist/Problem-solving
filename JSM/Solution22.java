package com.ssafy.algo;
import java.util.Scanner;

public class Solution22 {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		//테스트 케이스의 수를 받는 변수 T 선언
		int T = sc.nextInt();
		// 델타탐색을 위한 방향을 위한 2차원 배열 선언. 이 배열은 정수 변수 direction을 통해 사용됨.
		int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
		//출력값을 저장해놓아다가 한꺼번에 출력하기 위한 StringBuilder 변수
		StringBuilder sb = new StringBuilder();
		
		//테스트 케이스만큼 맵의 사이즈, 기타 등등 정보들을 받기 위한 포문
		for(int test_case = 0 ; test_case < T; test_case++)
		{
			//포문 안에 변수를 선언해도 성능상 하자는 없음. 단연코 말하건대 없음. 오히려 관리 또는 기억의 편리함을 위해 권장함.
			int size = sc.nextInt();
			//개구리가 마지막에 머문 곳이 어디인지 체크하기 위한 boolean 형 2차원 배열. 개구리가 마지막에 점프 띈 곳을 true로 저장할 것임.
			boolean[][] visited = new boolean[size][size];
			//변수 이름은 person_number 이지만 실제로는 이 테스트 케이스에서의 개구리 수를 저장함.
			int person_num = sc.nextInt();
			//현재까지 살아있는 개구리의 수를 저장하는 변수임. 추후에 개구리가 죽을 때마다 하나씩 깎임.
			int alive = person_num;
			//개구리의 행,열,그리고 방향을 저장하는 2차원 배열을 선언해줌.
			int[][] position = new int[person_num][3];
			//이제 개구리들의 위치와 점프 뛸 방향을 제시해주는 정보들을 받아볼 포문임.
			for(int i = 0 ; i < person_num; i++)
			{
				//0열에는 행 위치, 1열에는 열 위치, 2열에는 바라보는 방향이 들어가있음. 
				for(int j = 0; j < 3; j++)
				{
					position[i][j] = sc.nextInt();
				}
			}
			//이제 개구리들을 차례대로 불러서 점프를 띄게 할거임.
			for(int i = 0; i < person_num; i++)
			{
				//근데 처음 시작자리에 이미 개구리가 있으면 바로 죽는다는 걸 표현한 문장임
				if(visited[position[i][0]][position[i][1]] == true)
				{
					alive--;
					//얘는 죽고 다음 개구리로 넘어가기 위한 continue 사용
					continue;
				}
				//3발자국, 2발자국, 1발자국 순으로 가기 때문에 그걸 위한 step 변수 선언.
				int step = 3;
				//결국 step 값이 0 이면 결국 다 뛴 건데 이게 더 처리하기 편한 것 같아서 while문의 조건 범위가 0을 포함하게 만듦.
				while(step>=0)
				{
					//점프 뛸 방향을 저장함. 마지막에 1 빼주는 건 인덱스 차이를 맞추기 위해서임.
					//directions의 인덱스는 0부터 3까지, 문제에서 주어지는 방향은 1부터 4까지임.
					int direction = position[i][2] - 1;
					//점프를 뛰기 전에 그 자리의 값을 미리 얻어와서 여러가지 조건을 검사할거임.
					int next_row = position[i][0] + directions[direction][0]*step;
					int next_col = position[i][1] + directions[direction][1]*step;
					
					//만약 3번 다 뛰었으면 지금 현재 자리를 방문했음으로 표시하고 이 반복문을 멈춤.
					//어차피 끝나는데 break는 할 필요 없지 않냐 하면 뒤에 조건에서 혹시 몰라서 브레이크를 걸었음.
					if(step == 0)
					{
						visited[position[i][0]][position[i][1]] = true;
						break;
					}
					
					//점프 뛸 자리가 맵을 벗어났거나 누군가 이미 방문한거라면 개구리는 죽음. 
					if( next_row >= size || next_row < 0 || next_col >= size || next_col < 0 ||
							visited[next_row][next_col] == true )
					{
						alive--;
						break;
					}
					//아웃될 상황이 모두 지났음. 고로 점프 뛰어도 안전하단 뜻이니 현재 위치를 다음 위치로 바꿔줌.
					position[i][0] = next_row;
					position[i][1] = next_col;
					//다음번엔 한 발자국 덜 뛸 것이므로 step 수를 감소시켜줌.
					step--;
				}
			}
			//살아남은 개구리의 수를 문자열로 포장해서 저장함.
			sb.append("#"+(test_case+1)+" ").append(alive).append('\n');
		}
		//저장한 문자열을 한꺼번에 출력함.
		System.out.println(sb);
	}
	
}
