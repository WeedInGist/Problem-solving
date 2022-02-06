package Algo_study.Greedy;
import java.util.Scanner;


class Tank
{
    static int command_count = 1;
    int row, col;
    int[] direction = new int[2];
    Tank(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    public void setLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    public void action(char[][] map, char command)
    {
        // System.out.print(command+" ");
        // System.out.println(command_count+++"번째 명령입니다.");
        int brow = row;
        int bcol = col;
        if(command == 'S')
        {
            // System.out.println("바라보고 있는 방향은"+direction[0]+" "+direction[1]);
            while(true)
            {
                
                int n_brow = brow + direction[0];
                int n_bcol = bcol + direction[1];
                if(n_bcol < 0 || n_bcol >= map[0].length || n_brow < 0 || map.length<=n_brow)
                {
                    // System.out.println("총알의 위치는 "+n_brow+" "+n_bcol);
                    return;
                }
                else
                {
                    brow = n_brow;
                    bcol = n_bcol;
                    if(map[brow][bcol] == '*')
                    {
                        map[brow][bcol] = '.';
                        // System.out.println("벽돌에 부딪침.");
                        
                        return;
                    }
                    else if(map[brow][bcol] == '#')
                    {
                        // System.out.println("강철에 부딪침.");

                        return;
                    }
                }
                brow = n_brow;
                bcol = n_bcol;
            }   
        }
        if(command == 'U')
        {
            direction = Solution_1873_조성민.directions[0];
            int n_row = row + direction[0];
            int n_col = col + direction[1];
            if(n_col < 0 || n_col >= map[0].length || n_row < 0 || map.length <=n_row)
            {
                return;
            }
            else
            {
                if(map[n_row][n_col] == '.')
                {
                    // System.out.println("위쪽으로 이동했음");

                    row = n_row;
                    col = n_col;
                    return;
                }
                else
                    return;
            }
        }
        if(command == 'D')
        {
            direction = Solution_1873_조성민.directions[1];
            int n_row = row + direction[0];
            int n_col = col + direction[1];
            if(n_col < 0 || n_col >= map[0].length || n_row < 0 || map.length<=n_row)
            {
                return;
            }
            else
            {
                if(map[n_row][n_col] == '.')
                {
                    // System.out.println("아래쪽으로 이동했음");

                    row = n_row;
                    col = n_col;
                    return;
                }
                else
                    return;
            }
        }
        if(command == 'L')
        {
            direction = Solution_1873_조성민.directions[2];
            int n_row = row + direction[0];
            int n_col = col + direction[1];
            if(n_col < 0 || n_col >= map[0].length || n_row < 0 || map.length<=n_row)
            {
                return;
            }
            else
            {
                if(map[n_row][n_col] == '.')
                {
                    // System.out.println("왼쪽으로 이동했음");

                    row = n_row;
                    col = n_col;
                    return;
                }
                else
                    return;
            }
        }
        if(command == 'R')
        {
            direction = Solution_1873_조성민.directions[3];
            int n_row = row + direction[0];
            int n_col = col + direction[1];
            if(n_col < 0 || n_col >= map[0].length || n_row < 0 || map.length<=n_row)
            {
                return;
            }
            else
            {
                if(map[n_row][n_col] == '.')
                {
                    // System.out.println("오른쪽으로 이동했음");
                    row = n_row;
                    col = n_col;
                    return;
                }
                else
                    return;
            }
        }
    }
}

class Solution_1873_조성민{
    // 
    static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    static void set_direction(Tank user)
    {
        if(map[user.row][user.col] == '<')
        {
            user.direction=directions[2];
        }
        else if(map[user.row][user.col] == '^')
        {
            user.direction=directions[0];
        }
        else if(map[user.row][user.col] == '>')
        {
            user.direction=directions[3];
        }
        else if(map[user.row][user.col] == 'v')
        {
            user.direction=directions[1];
        }
    }
    static int[] find_direction(Tank user)
    {
        if(map[user.row][user.col] == '<')
        {
            return directions[2];
        }
        else if(map[user.row][user.col] == '^')
        {
            return directions[0];
        }
        else if(map[user.row][user.col] == '>')
        {
            return directions[3];
        }
        else
        {
            return directions[1];
        }
    }
    static int[] find_Start(char[][] map)
    {
        int[] location = new int[2];
        Loop1 : for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(map[i][j] == '<' || map[i][j] == 'v' || map[i][j] == '>' || map[i][j] == '^')
                {
                    location[0] = i;
                    location[1] = j;
                    break Loop1;
                }
            }
        }
        return location;
    }
    static int row;
    static int col;
    static char[][] map;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1 ; i <= T; i++)
        {
            row = sc.nextInt();
            col = sc.nextInt();
            map = new char[row][col];
            sc.nextLine();
            for(int j = 0 ; j < row ; j++)
            {
                map[j] = sc.nextLine().toCharArray();
                // System.out.println(map[j]);
            }
            // for(int a = 0 ; a <row; a++)
            // {
            //     for(int b = 0 ; b < col; b++)
            //         System.out.print(map[a][b]+" ");
            //     System.out.println();
            // }
            int[] start_Location = new int[2];
            start_Location = find_Start(map);
            Tank user = new Tank(start_Location[0], start_Location[1]);
            set_direction(user);
            map[user.row][user.col] ='.';
            int command_size = sc.nextInt();
            sc.nextLine();
            char[] commands = new char[command_size];
            commands = sc.nextLine().toCharArray();
            for(int command = 0; command < command_size; command++)
            {
                user.action(map, commands[command]);
                // System.out.println(user.row+" "+user.col);
            }
            // System.out.println();
            // System.out.println("현재 탱크의 위치는 "+user.row+" "+user.col);
            if(user.direction == directions[0])
                map[user.row][user.col] = '^';
            if(user.direction == directions[1])
                map[user.row][user.col] = 'v';
            if(user.direction == directions[2])
                map[user.row][user.col] = '<';
            if(user.direction == directions[3])
                map[user.row][user.col] = '>';
            System.out.print("#"+i +" ");
                for(int a = 0 ; a <row; a++)
            {
                for(int b = 0 ; b < col; b++)
                    System.out.print(map[a][b]);
                System.out.println();
            }
        }
    }
}