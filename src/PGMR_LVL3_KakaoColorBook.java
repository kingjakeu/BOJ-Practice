import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PGMR_LVL3_KakaoColorBook {

}
class PGMR_LVL3_KakaoColorBook_Solution {
	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
	    int maxSizeOfOneArea = 0;  
	    int[] answer = new int[2];
	    
	    int w = n;
	    int h = m;
	    int[][] offset = {{0,1},{1,0},{-1,0},{0,-1}}; 
	    boolean[][] visit = new boolean[h][w];
	    Queue<KCBookDOT> que = new LinkedList<>();
	    ArrayList<Integer> sizeList = new ArrayList<>();
	    
	    for(int i=0; i<h; i++) {
	    	for(int j=0; j<w; j++) {
	    		if(picture[i][j]>0 && !visit[i][j]) {
	    			que.add(new KCBookDOT(i,j));
	    			int color = picture[i][j];
	    			int count = 0;
	    			while(!que.isEmpty()) {
	    				count++;
	    				KCBookDOT dot = que.poll();
	    				for(int dir=0; dir<4; dir++) {
	    					int dx = dot.x+offset[dir][0];
	    					int dy = dot.y+offset[dir][1];
	    					if(dx>=0 && dx<w && dy>=0 && dy<h) {
	    						if(picture[dy][dx] == color && !visit[dy][dx]) {
	    							visit[dy][dx] = true;
	    							que.add(new KCBookDOT(dy,dx));
	    						}
	    					}
	    				}
	    			}
	    			sizeList.add(--count);
	    		}
	    	}
	    }
	    for(int i : sizeList) {
	    	maxSizeOfOneArea = Math.max(maxSizeOfOneArea, i);;
	    	numberOfArea++;
	    }
	    
	    
	    answer[0] = numberOfArea;
	    answer[1] = maxSizeOfOneArea;
	    return answer;
	}
}
class KCBookDOT{
	int y;
	int x;
	public KCBookDOT(int _y, int _x) {
		y = _y;
		x = _x;
	}
}