package Algo_study.Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cube
{
    int z,x,y, distance;
    Cube(int z, int x, int y, int d)
    {
        this.z = z;
        this.x = x;
        this.y = y;
        this.distance = d;
    }
}
public class Boj_6593 {
    static boolean[][][] visited;
    static int[][] directions = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
    static int BFS(char[][][] map, Cube start, Cube end)
    {
        Queue<Cube> queue = new LinkedList<>();
        visited[start.z][start.x][start.y] = true;
        queue.add(new Cube(start.z, start.x, start.y, 0));
        while(queue.isEmpty() == false)
        {
            Cube now = queue.poll();
            if(now.z == end.z && now.x == end.x && now.y == end.y)
            {
                return now.distance;
            }
            for(int i = 0 ; i < 6; i++)
            {
                int next_z = now.z + directions[i][0];
                int next_x = now.x + directions[i][1];
                int next_y = now.y + directions[i][2];
                if(next_z >=0 && next_z < map.length && next_x >= 0 && next_x < map[0].length && next_y >= 0 && next_y < map[0][0].length)
                {
                    if(visited[next_z][next_x][next_y] == false)
                    {
                        if(map[next_z][next_x][next_y] != '#')
                        {
                            visited[next_z][next_x][next_y] = true;
                            queue.add(new Cube(next_z, next_x, next_y, now.distance +1));
                        }
                    }
                }
            }
        }
        return 0;
        

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            int floor = sc.nextInt();
            int row = sc.nextInt();
            int col = sc.nextInt();
            sc.nextLine();
            if(floor == 0 && row == 0)
            {
                break;
            }
            char[][][] building = new char[floor][row][col];
            visited = new boolean[floor][row][col];
            Cube start = new Cube(0,0,0,0);
            Cube end = new Cube(0,0,0,0);
            for(int i = 0; i < floor; i++)
            {
                for(int j = 0 ; j < row; j++)
                {
                    char[] temp = sc.nextLine().toCharArray();
                    for(int k =0; k < col ;k++)
                    {
                        building[i][j][k] = temp[k];
                        if(temp[k] == 'S')
                        {
                            start = new Cube(i,j,k, 0);
                        }
                        if(temp[k] == 'E')
                        {
                           end = new Cube(i,j,k, 0);
                        }
                    }
                }
                sc.nextLine();
            }
            int escape = BFS(building, start, end);
            if(escape !=0)
            {
                System.out.println("Escaped in "+escape+" minute(s).");
            }
            else
            {
                System.out.println("Trapped!");
            }
        }

    }
}
