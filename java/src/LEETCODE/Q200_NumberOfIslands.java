package LEETCODE;

public class Q200_NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        Q200_Solution s = new Q200_Solution();
        System.out.println(s.numIslands(grid));
    }


}
class Q200_Solution {
    static int h;
    static int w;
    public int numIslands(char[][] grid) {
        h = grid.length;
        if(h == 0) return 0;
        w = grid[0].length;

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
               if(grid[i][j] == '1'){
                   finding(grid, i, j);
                   count += 1;
               }
            }
        }

        return count;
    }
    public void finding(char[][] grid, int y, int x){
        if(y < 0 || x < 0 || y > h-1 || x > w-1 || grid[y][x] != '1'){
            return;
        }else{
            grid[y][x] = '0';
            finding(grid, y-1, x);
            finding(grid, y+1, x);
            finding(grid, y, x-1);
            finding(grid, y, x+1);
        }
    }
}