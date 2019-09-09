package LEETCODE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q79_WordSearch {
    public static void main(String[] args) {
    }
}
class Q79_WordSearch_Solution {
    int h = 0;
    int w = 0;
    int end = 0;
    String wrd = "";
    boolean[][] visit;

    public boolean exist(char[][] board, String word) {
        h = board.length;
        w = board[0].length;
        visit = new boolean[h][w];
        wrd = word;
        end = word.length();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(word.charAt(0) == board[i][j]&&find(board,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean find(char[][] board, int y, int x, int idx){
        if(idx == end) return true;
        if(y<0||x<0||y>h-1||x>w-1) return false;
        if(board[y][x] != wrd.charAt(idx) || visit[y][x]) return false;
        visit[y][x] = true;
        if(find(board,y-1, x, idx+1)||find(board,y+1, x, idx+1)
        ||find(board,y, x-1, idx+1)||find(board,y, x+1, idx+1)){
            return true;
        }
        visit[y][x] = false;
        return false;
    }
}