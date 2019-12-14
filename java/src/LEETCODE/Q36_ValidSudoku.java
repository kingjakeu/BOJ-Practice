package LEETCODE;

public class Q36_ValidSudoku {
}
class Q36_ValidSudoku_Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] checkRow = new boolean[9];
            boolean[] checkCol = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    int row = board[i][j]-'1';
                    if(checkRow[row]){
                        return false;
                    }else{
                        checkRow[row] = true;
                    }
                }
                if(board[j][i]!='.'){
                    int col = board[j][i]-'1';
                    if(checkCol[col]){
                        return false;
                    }else{
                        checkCol[col] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 9; i=i+3) {
            for (int j = 0; j < 9; j=j+3) {
                boolean[] check = new boolean[9];
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        if(board[k][l]!='.'){
                            int num = board[k][l]-'1';
                            if(check[num]){
                                return false;
                            }else{
                                check[num] = true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}