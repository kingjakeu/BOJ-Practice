package PGMR;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class PGMR_KAKAO_FRIEND4BLOCK {
    public static void main(String[] args) {
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(6,6, board));
    }
    public static void shift(String[][] arr, int h, int w){
        for (int i = 0; i < w; i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < h; j++) {
                if(arr[j][i].equals(".")){
                    list.addFirst(".");
                }else{
                    list.add(arr[j][i]);
                }
            }
            for (int j = 0; j < h; j++) {
                arr[j][i] = list.get(j);
            }
        }
    }
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        int[][] dir = {{0, 1}, {1, 0}, {1, 1}};
        String[][] arr = new String[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = board[i].split("");
        }
        while(true){
            boolean check = false;
            String[][] newArr = arr;
            for (int x = 0; x < n-1; x++) {
                for (int y = 0; y < m-1; y++) {
                    String std = arr[y][x];
                    if(!std.equals(".")){
                        int tmpCount = 1;
                        String[][] tmpArr = newArr;
                        tmpArr[y][x] = ".";
                        boolean tmpB = true;
                        for (int i = 0; i < 3; i++) {
                            int dy = y+dir[i][0];
                            int dx = x+dir[i][1];
                            if(arr[dy][dx].equals(std)){
                                tmpArr[dy][dx] = ".";
                                tmpCount += 1;
                            }else{
                                tmpB = false;
                                break;
                            }
                        }
                        if(tmpB){
                            check = true;
                            newArr = tmpArr;
                            answer += tmpCount;
                        }
                    }
                }
            }
            if(check){
                shift(newArr,m,n);
                arr = newArr;
                for(String[] a : arr){
                    for (String s: a){
                        System.out.print(s);
                    }
                    System.out.println();
                }
                System.out.println();
            }else{
                return answer;
            }
        }
    }
}