package com.ssafy.hw04.lv4;

//2차원 배열 위를 떠돌며 현재 내 위치가 어딘지, 다음 위치는 어딘지 값을 가지는 클래스
class Point{
	int x = 0;
	int y = 0;
	int next_x, next_y;
}
//문제양식에 맞게 출력하고 2차원 배열을 회전하는 메소드를 제공하는 클래스
class ArrayMoving
{
	//방향을 미리 하드코딩해놓아서 direction 값을 바꿔주는 것만으로 자동으로 바뀜. 이 때 종류는 동남서북 4가지
	int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
	int direction = 0; //point의 다음 위치가 어떻게 변할지 가르쳐주는 값, 1씩 증가하나 4의 나머지 값으로 저장된다.
	Point cur_point = new Point();
	
	//실제로 회전을 담당하는 메소드. 2차원 배열 원본을 받은 뒤 복사본을 하나 만든다. 그 뒤 복사본을 다시 원본에 덮어써서 돌려준다. 따라서 원본 배열이 바뀐다.
	void rotate(int[][] i_arr)
	{
		//복사본을 만드는 부분
		int[][] temp = new int[4][4];
		for(int i = 0 ; i < 4; i++)
			for(int j = 0 ; j < 4 ; j++)
				temp[i][j]=i_arr[i][j];
		//cur_point가 현재 어느 어느 곳을 방문했는지 체크해주는 boolean형 2차원 배열
		//방문했던 곳은 true로 바뀐다.
		boolean[][] visited = new boolean[4][4];
		
		//방문하지 않은 곳을 순회하며 값을 바꾼다.
		while(visited[cur_point.y][cur_point.x] == false)
		{
			//처음 [0][0]값은 [1][0]값에서 따로 불러내어준다. 이유는 생각해볼만함. 이 구문이 없으면 동작이 틀림.
			if(cur_point.y==0 && cur_point.x ==0)
				temp[0][0] = i_arr[1][0];
			//System.out.printf("%d %d\n", cur_point.y, cur_point.x);
			//옮겨갈 다음 위치를 구한다.
			cur_point.next_x = cur_point.x+directions[direction][1];
			cur_point.next_y = cur_point.y+directions[direction][0];
			if(cur_point.next_x >= 4 || cur_point.next_x <0 || cur_point.next_y >= 4|| cur_point.next_y < 0 || visited[cur_point.next_y][cur_point.next_x] ==true)
			{
				//만약 다음 위치가 경계 밖에 있거나 이미 방문한 곳이라면 방향을 오른쪽으로 꺾는다.
				direction = (direction+1)%4;
				cur_point.next_y = cur_point.y+directions[direction][0];
				cur_point.next_x = cur_point.x+directions[direction][1];
			}
			//값을 1칸 옮겨주는 구문이다.
			temp[cur_point.next_y][cur_point.next_x] = i_arr[cur_point.y][cur_point.x];
			//현재 위치를 방문했으므로 true로 바꿔준다.
			visited[cur_point.y][cur_point.x] = true;
			//현재 위치를 다음 위치로 바꿔준다. 다음 반복문을 위해서!
			cur_point.x = cur_point.next_x;
			cur_point.y = cur_point.next_y;
		}
		
		//출력해주는 부분이다.
		for(int i = 0; i < 4; i++)
		{	
			for(int j = 0 ; j < 4 ; j++)
			{
				//System.out.printf("%d ", temp[i][j]);
				i_arr[i][j] = temp[i][j];
			}
			//System.out.println();
		}
		
		//한 번 회전을 한 뒤 초기화를 안해주면 다음에 할 땐 이 값이 유지가 되어 처음 시작점이나 처음 시작 방향이 기존의 데이터가 사용된다.
		//고로 초기화해주는 것.
		direction = 0;
		cur_point = new Point();
	}
	void printArr(int[][] arr)
	{
		int num = 0;
		while(num < 4)
		{	
			System.out.printf("%dth Matrix Moving\n", num+1);
			rotate(arr);
			for(int i = 0 ; i < 4; i++)
			{
				for(int j = 0 ; j < 4; j++)
				{
					System.out.printf("%-4d ", arr[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			num++;
		}
	}
}

public class Rotation {
	public static void main(String[] args)
	{
		ArrayMoving am = new ArrayMoving();
		System.out.println("Original Matrix");
		int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
		for(int i = 0 ; i < 4; i++)
		{
			for(int j = 0 ; j < 4; j++)
			{
				System.out.printf("%d ", arr[i][j]);
			}
			System.out.println();
		}		
		System.out.println();
		am.printArr(arr);
		
	}
}
