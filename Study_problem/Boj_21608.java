package Algo_study.Implementation;

import java.util.ArrayList;
import java.util.Scanner;

//조건에 맞는 자리를 저장해줄 목적으로 만든 클래스. 단순히 행과 열만을 저장할 것이기 때문에 x,y밖에 없음. x는 행, y는 열
class which{
    int x,y;
    which(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    //System.out.println(which 객체) 할 때 자기의 현재 행과 열을 말하게끔 toString 함수를 오버라이드 해줌. 
    public String toString()
    {
        String s = "지금 현재의 위치는 "+x+" "+y;
        return s;
    }
}
//주위에 좋아하는 사람 의 수 -> 그 다음에 주위에 빈자리가 많은 순서 -> 행이 빠른 순-> 열이 빠른 순 
public class Boj_21608 {
    static int size;
    //4방 탐색을 위해 미리 2차원 배열을 만들어줌. 순서는 오른쪽 왼쪽 위쪽 아래쪽 
    static int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};

    //주위에 내가 좋아하는 사람이 몇 명 있는지 그 사람들의 위치 정보를 ArrayList(동적 배열)에 담아서 반환해주는 함수
    //예를 들어 내가 좋아하는 사람이 (2,2), (3,1)에 있다고 치면 이중 포문을 돌면서 행이 빠른 것부터 넣고 그 다음엔 열이 빠른 것부터 집어넣음.
    //따라서 반환되는 ArrayList 에는 which(2,2)와 which(3,1)이 순서대로 들어가 있다고 보면 됨.
    static ArrayList<which> count_love(int[][] map, int index, int[][] info)
    {
        //반환할 ArrayList를 미리 만들어줌
        ArrayList<which> arr = new ArrayList<which>();
        //각각의 자리에서 주위에 좋아하는 사람이 가장 많은 자리를 체크해주기 위해 love_max 변수를 선언함. 
        int love_max = -1;
        //모든 자리를 검사하며 주위에 좋아하는 사람이 최대로 많은 값은 얼마인지 알아냄. 
        for(int i = 1; i <= size; i++)
        {
            for(int j = 1 ; j <=size; j++)
            {
                // 내가 앉을 수 있는 자리면??
                if(map[i][j]==0)
                {
                    //주위에 내가 얼마나 좋아하는 사람이 있는지 세어줄거야.
                    int love_count = 0;
                    for(int d = 0 ; d <4; d++)
                    {
                        int next_r = i+directions[d][0];
                        int next_c = j+directions[d][1];
                        if(next_r>=1 && next_r <= size && next_c >=1 && next_c <= size)
                        {
                            for(int k=1 ; k < 5; k++)
                            {
                                if( map[next_r][next_c] == info[index][k])
                                {
                                    love_count++;
                                }
                            }
                        }
                    }
                    //이게 지금 최대치보다 크다면 최대치를 새로 갱신
                    if(love_count >= love_max)
                        love_max = love_count;   
                }
            }
        }
        //주위에 love_max 만큼 좋아하는 사람이 있을 때 이게 최고점이라는 것을 알았으니 위와 똑같은 방식을 하되 좋아하는 사람이 love_max만큼 있을 때
        // 위에서 미리 만들어준 ArrayList에 넣어줄 것임. 이 때도 이중포문의 순서대로 행과 열이 빠른 순서대로 들어감.
        for(int i = 1; i <= size; i++)
        {
            for(int j = 1 ; j <=size; j++)
            {
                if(map[i][j] == 0)
                {
                    int love_count = 0;
                    for(int d = 0 ; d <4; d++)
                    {
                        int next_r = i+directions[d][0];
                        int next_c = j+directions[d][1];
                        if(next_r>=1 && next_r <= size && next_c >=1 && next_c <= size)
                        {
                            for(int k=1 ; k < 5; k++)
                            {
                                if( map[next_r][next_c] == info[index][k])
                                {
                                    love_count++;
                                }
                            }
                        }
                    }
                    //어라?? 내가 좋아하는 사람이 주위에 좋아하는 사람의 최대치와 똑같네? 그러면 우선순위가 제일 높은 것들 중 하나이므로 ArrayList에 집어넣자!
                    if(love_count == love_max)
                    {
                        arr.add(new which(i,j));
                    }
                }
            }      
        }
        // 좋아하는 사람이 최대로 있는 자리의 위치 정보 행과 열이 담긴 배열, 순서는 그냥 행과 열이 빠른 순
        return arr;
    }
    //count_love 함수에서 세어준 인원이 2명일 때는 그 두명의 주위의 빈자리의 수를 따지기 때문에 만들어준 함수
    //위에서 반환된 배열을 그대로 받아서 그 자리에 빈자리가 얼마나 많은지 체크한다.
    //빈자리의 최대치를 먼저 알아낸 후 그 최대치만큼 주위에 빈자리를 만족하는 위치를 또다시 ArrayList에 집어 넣는다.
    static ArrayList<which> count_empty(int[][] map, ArrayList<which> info)
    {
        //좋아하는 사람들의 수가 최대치인 위치정보들의 배열을 받고
        //그 배열 속의 위치정보들만 조사할거임.

        ArrayList<which> arr = new ArrayList<which>();
        int empty_max = -1;
        for(which person : info)
        {
            int empty_count = 0;
            for(int i = 0; i < 4; i++)
            {
                int next_r = person.x + directions[i][0];
                int next_c = person.y + directions[i][1];
                if(next_r>=1 && next_r <= size && next_c >=1 && next_c <= size)
                    if( map[next_r][next_c] == 0)
                    {
                        empty_count++;
                    }
                    
            }
            //빈자리의 최대치를 알아내자.
            if(empty_max <= empty_count)
            {
                empty_max = empty_count;
            }
        }
        //최대치를 알아냈으니 최대치를 만족하는 자리의 정보들을 알아내자.
        for(which person : info)
        {
            int empty_count = 0;
            for(int i = 0; i < 4; i++)
            {
                int next_r = person.x + directions[i][0];
                int next_c = person.y + directions[i][1];
                if(next_r>=1 && next_r <= size && next_c >=1 && next_c <= size)
                    if( map[next_r][next_c] == 0)
                    {
                        empty_count++;
                    }
                    
            }
            //어라 내 주위에 빈자리의 수가 최대치의 빈자리 수와 같네? 그럼 얘도 우선순위가 높은 것이니 배열에 넣자.
            if(empty_max == empty_count)
            {
                //이 때 배열의 위치정보들의 순서는 행과 열이 빠른 순서
                arr.add(person);
            }

        }
        //이 배열의 순서는 행이 빠르고 열이 빠른 순서대로이다. 따라서 이 배열에서 앞에서부터 하나씩 꺼내며 앉힐 수 있는제 체크하면 된다.
        return arr;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        sc.nextLine();
        // (1,1) ->  map 위치정보들을  0 ~ size  size+1개의 정보데이터가있지만 사용하는건 1~ size 까지만 사용한다.
        // 왜냐면 (1,1) -> (0,0) 변환하는 식으로하기에는 머리 아프니까  
        // size+1로 크기를 설정해준다.
        int[][] map = new int[size+1][size+1];
        //info는 학생 자기자신의 넘버와 좋아하는 사람의 숫자를 받는 2차원 배열이다.
        int[][] info = new int[size*size][5];
        
        for(int i = 0 ; i < size*size; i++)
        {
            for(int j = 0 ; j < 5 ; j++)
            {
                info[i][j]= sc.nextInt();
            }
        }
        // 가운데에 첫번째 꼴아박아야 함. 행과열이 빠른 위치는 정해져있어요.
        // 문제에서 N은 3이상이라 했으므로 무조건 (2,2)위치에 첫번째 학생을 앉혀야 한다. 빈자리의 수가 최대인 자리는 많이 있겠지만 행과 열이 빠른 건 (2,2)가 제일 빠르기 때문.
        map[2][2] = info[0][0];
        
        //학생 0번째를 넣어줬으므로 info 배열에서 넣어줄 학생의 index 는 1부터 시작한다.
        int index = 1;
        //학생을 하나하나씩 넣어주며 반복문을 실행한다.
        while(index < size*size)
        {
            // 현재까지 index-1번째 학생까지 앉은 map을 바탕으로 count_love 함수를 실행해준다.
            ArrayList<which> love = count_love(map, index, info);
            // 반한된 동적 배열 love는 문제 조건 첫번째를 만족한 학생들의 위치 정보를 담은 배열이다.
            // 데이터는 which라는 클래스로 각각의 which는 int x,y만 클래스 변수로 갖는다.
            // 이 때 x는 행, y는 열이다.
            // 첫번째 조건을 만족한 학생이 1명보다 많다면 두번째 조건으로 넘어가야 한다.
            if(love.size() > 1)
            {
                //2번째 조건을 만족하는 학생들의 위치 정보를 담은 배열을 얻어낸다. 
                ArrayList<which> empty = count_empty(map, love);
                //빈자리의 수가 가장 많은 위치들의 정보를 담은 배열 중에 행과열이 빠른 순서대로 조사함
                for(which person: empty)
                {
                    //지금 조사한 자리가 비어있다면
                    if(map[person.x][person.y] == 0)
                    {
                        //학생을 앉히고 포문을 멈춘다.
                        map[person.x][person.y] = info[index][0];
                        break;
                    }
                    //자리가 비어있지 않으면 넘어가자고.
                }
            }
            //첫번째 조건을 만족한 사람이 1명이면? 생각할 것도 없이 바로 앉힌다.
            else
            {
                which person = love.get(0);
                //위에서는 자리가 비어있는지 검사했는데 여기서는 왜 검사 안하냐면
                //함수 안에서 애초에 비어있는 자리인지 사실 검사했다.
                //까먹고 빈 자리인지 또 체크한거임.
                map[person.x][person.y] = info[index][0];

            }
            //여기까지 왔으면 학생을 무조건 자리에 앉혔다는 뜻이므로 index를 하나 추가해준다.
            index++;
        }
        
        //이제 학생들의 주위에 앉은 수에 따른 만족도를 계산해보자.
        int count_sum = 0;
        for(int i = 1; i <= size; i++)
        {
            for(int j = 1 ; j <= size; j++)
            {
                int count = 0;
                int student_num  = map[i][j];
                for(int k = 0 ; k < size*size; k++)
                {
                    if(info[k][0] == student_num)
                    {
                        int[] love_people = info[k];
                        for(int d=0; d<4; d++)
                        {
                            int next_r = i + directions[d][0];
                            int next_c = j + directions[d][1];
                            if(next_r>=1 && next_r <= size && next_c >=1 && next_c <= size)
                            {
                                for(int stu_num : love_people)
                                {
                                    if(map[next_r][next_c] == stu_num && stu_num != student_num)
                                    {
                                        //System.out.println("지금 나는 "+student_num+"이고 내가 좋아하는 애는 "+stu_num);
                                        count++;
                                    }
                                }
                            }

                        }
                    }
                }
                if(count == 1)
                {
                    count_sum += 1;
                }
                else if(count ==2)
                {
                    count_sum += 10;
                }
                else if(count ==3)
                {
                    count_sum += 100;
                }
                else if(count ==4)
                {
                    count_sum += 1000;
                }
            }
        }
        System.out.println(count_sum);
    }
}
