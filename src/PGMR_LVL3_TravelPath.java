import java.util.ArrayList;
import java.util.Collections;
public class PGMR_LVL3_TravelPath {

}
class PGMR_LVL3_TravelPath_Solution {
    static ArrayList<String> paths = new ArrayList<>();
    
	public void dfs(String[][] tickets, boolean[] visit, String dest, String path, int count) {
		int leng = tickets.length;
		
		path += dest + ",";
		if(count == leng) {
			paths.add(path);
			return;
		}
		
		for(int i=0; i<leng; i++) {
			if(!visit[i]) {
				if(tickets[i][0].equals(dest)) {
					visit[i] = true;
					dfs(tickets, visit, tickets[i][1],path, count+1);
					visit[i] = false;
				}
			}
		}
	}
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int leng = tickets.length;
        
        for(int i=0; i<leng; i++) {
        	if(tickets[i][0].equals("ICN")) {
            	boolean[] visit = new boolean[leng];
        		visit[i] = true;
        		String path = "ICN,";
        		dfs(tickets,visit,tickets[i][1],path,1);
        	}
        }
        Collections.sort(paths);
        answer = paths.get(0).split(",");
        
        return answer;
    }
}