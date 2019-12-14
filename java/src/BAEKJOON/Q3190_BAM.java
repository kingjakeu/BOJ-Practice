package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3190_BAM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[n][n];
        boolean[][] snakeIn = new boolean[n][n];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] arr = br.readLine().split(" ");
            map[Integer.parseInt(arr[0])-1][Integer.parseInt(arr[1])-1] = true;
        }

        int l = Integer.parseInt(br.readLine());
        Queue<BAM> way = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            String[] arr = br.readLine().split(" ");
            way.add(new BAM(Integer.parseInt(arr[0]), arr[1]));
        }
        LinkedList<BAM> snake = new LinkedList<>();
        int count = 0;
        snake.add(new BAM(0,0));
        snakeIn[0][0] = true;

        String[] dirArr = {"R","D","L","U"};
        int dirIdx = 0;
        while (true){
            String dir = dirArr[dirIdx];
            count += 1;
            int x = snake.getFirst().x;
            int y = snake.getFirst().y;
            if(dir.equals("U")){
                y -= 1;
            }else if(dir.equals("D")){
                y += 1;
            }else if(dir.equals("L")){
                x -= 1;
            }else if(dir.equals("R")){
                x += 1;
            }else{
                break;
            }
            if(!(x >= 0 && x < n && y >= 0 && y < n)){
                break;
            }
            if(snakeIn[y][x]){
                break;
            }
            snake.addFirst(new BAM(y,x));
            snakeIn[y][x] = true;
            if(map[y][x]){
                map[y][x] = false;
            }else{
                BAM b = snake.getLast();
                snakeIn[b.y][b.x] = false;
                snake.remove(snake.getLast());
            }


            if (!way.isEmpty()){
                if (count == way.peek().sec){
                    if(way.peek().dir.equals("D")){
                        dirIdx += 1;
                        if(dirIdx>=4) dirIdx = 0;
                    }else{
                        dirIdx -= 1;
                        if(dirIdx<0) dirIdx = 3;
                    }
                    way.poll();
                }
            }

        }
        System.out.println(count);
    }
}
class BAM{
    int y;
    int x;
    String  dir;
    int sec;
    BAM(int _y, int _x){
        y = _y;
        x = _x;
    }
    BAM(int s, String d){
        sec = s;
        dir = d;
    }
}
