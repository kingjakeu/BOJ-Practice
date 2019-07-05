package PGMR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PGMR_IslandConnect {
}
class Solution_PGMR_IslandConnect {
	static int[] visit = new int[101];
	public int find(int i) {
		if(i == visit[i]) {
			return i;
		}else {
			visit[i] = find(visit[i]);
			return visit[i];
		}
	}
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int leng = costs.length;
        
        ArrayList<Island> list = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
        	visit[i] = i;
        }
        
        for(int i=0; i<leng; i++) {
        	list.add(new Island(costs[i][0],costs[i][1],costs[i][2]));
        }
        Collections.sort(list, new Comparator<Island>() {
			@Override
			public int compare(Island o1, Island o2) {
				if(o1.cost < o2.cost) {
					return -1;
				}else if(o1.cost > o2.cost) {
					return 1;
				}
				return 0;
			}  	
        });
       
        for(int i=0; i<leng; i++) {
        	int s = find(list.get(i).start);
        	int e = find(list.get(i).end);
        	int c = list.get(i).cost;
        	
        	if(s != e) {
        		visit[s] = e;
        		answer += c;
        	}
        }
        
        return answer;
    }
}
class Island{
	int start;
	int end;
	int cost;
	public Island(int s, int e, int c) {
		start = s;
		end = e;
		cost = c;
	}
}