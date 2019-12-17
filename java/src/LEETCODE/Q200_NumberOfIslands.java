package LEETCODE;

public class Q200_NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        Q200_Solution s = new Q200_Solution();
        s.numIslands(grid);
    }


}
class Q200_Solution {
    public int numIslands(char[][] grid) {
        int h = grid.length;
        if(h == 0){
            return 0;
        }
        int w = grid[0].length;
        int[][] unionMap = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                unionMap[i][j] = 0;
                for (int k = 0; k < h; k++) {
                    for (int l = 0; l < w; l++) {
                        System.out.print(unionMap[k][l]+' ');
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }

        int[][] offset = {{0,-1}, {-1,0}};
        int count = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(grid[i][j] == '1'){
                    for (int k = 0; k < 2; k++) {
                        int dy = i+offset[k][0];
                        int dx = j+offset[k][1];
                        if(dy>=0 && dx >=0){
                            if(grid[dy][dx] == '1'){
                                unionMap[i][j] = unionMap[dy][dx];
                                break;
                            }
                        }
                    }
                    if(unionMap[i][j] == 0){
                        unionMap[i][j] = count;
                        System.out.println(i+" "+j+" "+count);
                        count += 1;
                    }
                    for (int k = 0; k < h; k++) {
                        for (int l = 0; l < w; l++) {
                            System.out.print(unionMap[k][l]+' ');
                        }
                        System.out.println();
                    }
                    System.out.println();
                }

            }
        }
        return count-1;
    }
}