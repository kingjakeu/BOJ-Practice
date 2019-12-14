package PGMR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class PGMR_LVL3_Ranking {
}

class PGMR_LVL3_Ranking_Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<RankNode> list = new ArrayList<>();
        list.add(new RankNode(0));
        for(int i=1; i<=n; i++) {
        	list.add(new RankNode(i));
        }
        for(int[] r : results) {
        	list.get(r[1]).lose.add(r[0]);
        	list.get(r[0]).win.add(r[1]);
        }
        for(int k=0; k<2; k++) {
        	 for(int i=1; i<=n; i++) {
             	RankNode rn = list.get(i);
             	HashSet<Integer> tmp = new HashSet<>();
             	for(Integer win : rn.win) {
             		for(Integer w: list.get(win).win) {
                 		tmp.add(w);
             		}
             	}
             	rn.win.addAll(tmp);
             	tmp = new HashSet<>();
             	for(Integer lose: rn.lose) {
             		for(Integer l: list.get(lose).lose) {
                 		tmp.add(l);
             		}
             	}
             	rn.lose.addAll(tmp);
             }
        }
        for(RankNode rn : list) {
        	int size = rn.win.size();
        	size += rn.lose.size();
        	if(size>=n-1) {
        		answer++;
        	}
        }
        return answer;
    }
}
class RankNode{
	int key;
	HashSet<Integer> lose; 
	HashSet<Integer> win; 
	boolean isRank;
	
	public RankNode(int k) {
		key = k;
		lose= new HashSet<>();
		win= new HashSet<>();
		isRank = false;
	}
}