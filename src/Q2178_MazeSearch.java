import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

/**
 * BOJ #2178 미로탐색
 * 분류: BFS
 */ 


public class Q2178_MazeSearch {
    public static void main(String[] args){
        CustomScanner cs = new CustomScanner();
        int m = cs.nextInt();
        int n = cs.nextInt();
        int[][] maze = new int[m][n];
        int[][] offset = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0; i<m; i++){
            String s = cs.readLine();
            String[] str = s.split("");
            for(int j=0; j<n; j++) {
            	maze[i][j] = Integer.parseInt(str[j]);
            }
        }
        Queue<DOT> que = new LinkedList<>();
        que.offer(new DOT(0,0));

        while(!que.isEmpty()){
            DOT dot = que.poll(); 
            boolean b = false;
            for(int i=0; i<4; i++){
            	int x = dot.x;
            	int y = dot.y;
            	x += offset[i][1];
                y += offset[i][0];
                if(y>=0 && y< m && x>=0 &&x<n){
                    if(maze[y][x] == 1){
                        b = true;
                        maze[y][x] = maze[dot.y][dot.x] +1;
                        DOT t = new DOT(x,y);
                        que.offer(t);
                    }
                }
            }
        }
        System.out.println(maze[m-1][n-1]);
    }
    static class CustomScanner{
        private static BufferedReader br;
        private static StringTokenizer st;
    
        CustomScanner(){
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }
        static String readLine(){
            try{
                return br.readLine();
            }catch(IOException e){
                return null;
            }
        }
        static String next(){
            while(!st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                }
            }
            return st.nextToken();
        }
        static int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
//class DOT{
//    int x;
//    int y;
//    DOT(int _x, int _y){
//        x = _x;
//        y = _y;
//    }
//}
