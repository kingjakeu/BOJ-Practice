package PGMR;

import javax.annotation.PostConstruct;
import java.util.*;

public class PGMR_KAKAO_MUZIMUKBANG {
    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] food = {3, 1, 2};
//        s.solution(food,5);
    }
}
class PGMR_KAKAO_MUZIMUKBANG_Solution {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        List<MuziFood> list = new LinkedList<>();
        int count = 0;
        for (int food : food_times){
            count += 1;
            list.add(new MuziFood(count,food));
        }
        Collections.sort(list, new Comparator<MuziFood>() {
            @Override
            public int compare(MuziFood o1, MuziFood o2) {
                if(o1.time<o2.time){
                    return -1;
                }else if(o1.time>o2.time){
                    return 1;
                }
                return 0;
            }
        });
        Queue<MuziFood> que = new LinkedList<>();
        que.addAll(list);

        long divd = k/count;
        int rmdr = (int)(k%count);
        while (!que.isEmpty()){
            if(que.peek().time<=divd){
                que.poll();
            }else{
                break;
            }
        }
        if(que.isEmpty()){
            return -1;
        }
        for (int i = 0; i < rmdr; i++) {
            MuziFood food = que.poll();
            food.time-=divd;
            food.time-=1;
            if(food.time>0){
                que.add(food);
            }
            if(que.isEmpty()){
                return -1;
            }
        }
        return que.peek().seq;
    }
}
class MuziFood{
    int seq;
    int time;
    MuziFood(int s, int t){
        seq=s;
        time=t;
    }
}