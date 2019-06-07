import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PGMR_LVL3_BestAlbum {

}
class PGMR_LVL3_BestAlbum_Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int leng = genres.length;
        ArrayList<BAMusic> list = new ArrayList<>();
       
        
        for(int i=0; i<leng; i++) {
        	boolean check = false;
        	for(BAMusic mc : list) {
        		if(genres[i].equals(mc.genre)) {
        			check = true;
        			mc.pNums.add(new BAPlayNum(plays[i],i));
        			mc.totalPlay += plays[i];
        		}
        	}
        	if(!check) {
        		list.add(new BAMusic(genres[i],i,plays[i]));
        	}
        }
        
        
        Collections.sort(list, new Comparator<BAMusic>() {
			@Override
			public int compare(BAMusic o1, BAMusic o2) {
				if(o1.totalPlay > o2.totalPlay) {
					return -1;
				}else if(o1.totalPlay < o2.totalPlay){
					return 1;
				}
				return 0;
			}
        });
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(BAMusic mc : list) {
        	Collections.sort(mc.pNums, new Comparator<BAPlayNum>(){
				@Override
				public int compare(BAPlayNum o1, BAPlayNum o2) {
					if(o1.play > o2.play) {
						return -1;
					}else if(o1.play < o2.play) {
						return 1;
					}else {
						if(o1.num < o2.num) {
							return -1;
						}else if(o1.num > o2.num) {
							return 1;
						}
					}
					return 0;
				}
        	});
        	int n = mc.pNums.get(0).num;
        	ans.add(n);
        	if(mc.pNums.size() > 1) {
            	n = mc.pNums.get(1).num;
            	ans.add(n);
        	}
        }
        answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
        	answer[i] = ans.get(i);
        }
        
        return answer;
    }
}
class BAMusic{
	String genre;
	ArrayList<BAPlayNum> pNums;
	int totalPlay;
	public BAMusic(String g, int idx, int play) {
		genre = g;
		pNums = new ArrayList<>();
		pNums.add(new BAPlayNum(play,idx));
		totalPlay = play;
	}
}
class BAPlayNum{
	int play;
	int num;
	public BAPlayNum(int p, int n ){
		play = p;
		num = n;
	}
}