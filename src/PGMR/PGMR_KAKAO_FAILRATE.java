package PGMR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PGMR_KAKAO_FAILRATE {
}
class PGMR_KAKAO_FAILRATE_Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        List<FrStage> list = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            list.add(new FrStage(i+1,0,0));
        }
        for(int st : stages){
            for (int i = 0; i < Math.min(N,st); i++) {
                list.get(i).total += 1;
            }
            if(st<=N){
                list.get(st-1).fail += 1;
            }
        }
        for(FrStage fr : list){
            if(fr.total==0){
                fr.rate = 0;
            }else{
                fr.rate = (double)fr.fail/(double)fr.total;
            }
        }
        Collections.sort(list, new Comparator<FrStage>() {
            @Override
            public int compare(FrStage o1, FrStage o2) {
                if(o1.rate<o2.rate){
                    return 1;
                }else if(o1.rate>o2.rate){
                    return -1;
                }
                return 0;
            }
        });
        answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).stage;
        }
        return answer;
    }
}
class FrStage{
    int stage;
    int total;
    int fail;
    double rate = 0;
    FrStage(int s, int f, int t){
        stage =  s;
        total = t;
        fail = f;
    }
}