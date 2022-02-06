package Algo_study.Implementation;

import java.util.ArrayList;
import java.util.Scanner;

class which{
    int x,y;
    which(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public String toString()
    {
        String s = "지금 현재의 위치는 "+x+" "+y;
        return s;
    }
}
//주위에 좋아하는 사람 의 수 -> 그 다음에 주위에 빈자리가 많은 순서 -> 행이 빠른 순-> 열이 빠른 순 
public class Boj_21608 {
    static int size;
    static int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};


    static ArrayList<which> count_love(int[][] map, int index, int[][] info)
    {
        ArrayList<which> arr = new ArrayList<which>();
        int love_max = -1;
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
                    if(love_count == love_max)
                    {
                        arr.add(new which(i,j));
                    }
                }
            }      
        }
        // 좋아하는 사람이 최대로 있는 자리의 위치 정보 행과 열이 담긴 배열 순서가 그냥 행과 열이 빠른 순
        return arr;
    }
 
    static ArrayList<which> count_empty(int[][] map, ArrayList<which> info)
    {
        //좋아하는 사람들의 수가 최대치인 위치정보들의 배열을 받고
        //그 배열 속의 위치정보들만 조사할거임. 왜냐면 좋아하는 사람 수-> 빈자리 많은 순서

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
            if(empty_max <= empty_count)
            {
                empty_max = empty_count;
            }
        }
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
            if(empty_max == empty_count)
            {
                //이 때 배열의 위치정보들의 순서는 행과 열이 빠른 순서
                arr.add(person);
            }

        }
        return arr;
    }

    // static int count(int[][] map, int[][] info)
    // {
    //     int count = 0;
    //     for(int i =1; i<=size; i++)
    //     {
    //         for(int j = 1; j<=size; j++)
    //         {
    //             int next_r = i + directions[i][0];
    //             int next_c = j + directions[i][1];
    //             if(next_r>=1 && next_r <= size && next_c >=1 && next_c <= size)
    //             {
    //                 for(int k=1 ; k < 5; k++)
    //                 {
    //                     if( map[next_r][next_c] == info[index][k])
    //                     {
    //                         love_count++;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    // }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        sc.nextLine();
        // (1,1) ->  map 위치정보들을  0 ~ size  size+1개의 정보데이터가있지만 사용하는건 1~ size 까지만 사용한다.
        //왜냐면 (1,1) -> (0,0) 변환하는 식으로하기에는 머리 아프니까  
        int[][] map = new int[size+1][size+1];
        int[][] info = new int[size*size][5];
        for(int i = 0 ; i < size*size; i++)
        {
            for(int j = 0 ; j < 5 ; j++)
            {
                info[i][j]= sc.nextInt();
            }
        }
        // 가운데에 첫번째 꼴아박아야 함. 행과열이 빠른 위치는 정해져있어요.
        // N 크기가 홀수일 떄 짝수일 때가 달라요 
        //좋아하는 사람의 수가 다 0이에요. 모두 빈칸 -> 빈자리의 수를 체크해야되는데 8방이 다 비어있는 모든 자리 -> 행과열이 빠른 순서
        
       
            map[2][2] = info[0][0];

        
        int index = 1;
        while(index < size*size)
        {
            // 학생이 1명만 앉은 자리배치도에서 좋아하는 사람의 수가 최대인 자리들의 배열
            ArrayList<which> love = count_love(map, index, info);
            // System.out.println("0 지금 인덱스는 "+index);
            // for(which a : love)
            // {
            //     System.out.println(a);
            // }

            if(love.size() > 1)
            {
                // System.out.println("1 지금 인덱스는 "+index);
                ArrayList<which> empty = count_empty(map, love);
                //빈자리의 수가 가장 많은 위치들의 정보를 담은 배열 중에 행과열이 빠른 순서대로 조사함
                for(which person: empty)
                {
                    if(map[person.x][person.y] == 0)
                    {
                        map[person.x][person.y] = info[index][0];
                        break;
                    }
                }
            }
            else
            {
                // System.out.println("2 지금 인덱스는 "+index);

                which person = love.get(0);
                map[person.x][person.y] = info[index][0];

            }
            index++;
        }

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
                                        System.out.println("지금 나는 "+student_num+"이고 내가 좋아하는 애는 "+stu_num);
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
//좋아하는 사람의 수의 최대와 그에 따른 행과열 정보들을 반환해주는 함수 하나
//그걸 바탕으로 빈자리의 최대와 그에 따른 행과열 정보들을 반환해주는 함수 하나
// 4 5 8 
// 2 9 1
// 3 6 7