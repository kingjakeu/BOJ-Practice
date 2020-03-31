package LEETCODE.medium.dfs;

import java.util.Stack;

public class Q130_SurroundedRegions {
    public static void main(String[] args) {
        
    }
    class Solution {
        int[][] offset = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int height;
        int width;
        boolean[][] visited;
        public void solve(char[][] board) {
            height = board.length;
            if(height == 0) return;
            width = board[0].length;
            visited = new boolean[height][width];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(board[i][j] == 'O' && !visited[i][j]){
                        change(new Dot(i, j), new Stack<>(), board);
                    }
                }
            }
        }

        public void change(Dot dot, Stack<Dot> stack, char[][] board){
            board[dot.y][dot.x] = 'X';
            visited[dot.y][dot.x] = true;
            stack.add(dot);
            for (int i = 0; i < 4; i++) {
                int dx = dot.x + offset[i][0];
                int dy = dot.y + offset[i][1];
                if(dx >= 0 && dx < width && dy >= 0 && dy < height){
                    if(board[dy][dx] == 'O'){
                        if(visited[dy][dx]){
                            rollBack(stack, board);
                        }else{
                            change(new Dot(dy, dx), stack, board);
                        }
                    }
                }else{
                    rollBack(stack, board);
                    return;
                }
            }
        }
        public void rollBack(Stack<Dot> stack, char[][] board){
            while(!stack.isEmpty()){
                Dot pop = stack.pop();
                board[pop.y][pop.x] = 'O';
            }
        }
    }

    class Dot{
        int y;
        int x;
        Dot(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
