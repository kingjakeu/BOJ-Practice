package LEETCODE;

import java.util.LinkedList;
import java.util.List;

public class Q51_NQueen {
}
class Q51_NQueen_Solution {
    List<List<String>> answer = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        findQueen(board, 0, n);
        return answer;
    }
    public void findQueen(char[][] board, int colIdx, int endCol){
        if(colIdx == endCol){
            addAnswer(board,endCol);
        }else{
            for (int i = 0; i < endCol; i++) {
                if(isValid(board,colIdx,i,endCol)){
                    board[colIdx][i] = 'Q';
                    findQueen(board,colIdx+1, endCol);
                    board[colIdx][i] = '.';
                }
            }
        }
    }
    public void addAnswer(char[][] board, int n){
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            ans.add(sb.toString());
        }
        answer.add(ans);
    }
    public boolean isValid(char[][] board, int y, int x, int n){
        for (int i = 0; i < n; i++) {
            if(board[i][x] == 'Q'){
                return false;
            }
            if(y-i >= 0 && x-i >= 0){
                if(board[y-i][x-i] == 'Q'){
                    return false;
                }
            }
            if(y+i < n && x+i<n){
                if(board[y+i][x+i] == 'Q'){
                    return false;
                }
            }
            if(y-i >= 0 && x+i<n){
                if(board[y-i][x+i] == 'Q'){
                    return false;
                }
            }
            if(y+i < n && x-i>=0){
                if(board[y+i][x-i] == 'Q'){
                    return false;
                }
            }
        }
        return true;
    }
}