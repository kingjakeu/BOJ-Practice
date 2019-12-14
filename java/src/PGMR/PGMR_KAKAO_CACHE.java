package PGMR;

import java.util.HashSet;
import java.util.LinkedList;

public class PGMR_KAKAO_CACHE {
}
class PGMR_KAKAO_CACHE_Solution {
    public int solution(int cacheSize, String[] cities) {
        int HIT = 1, MISS = 5;
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        int leng = cities.length;
        if(cacheSize==0||leng<=cacheSize){
            return leng*MISS;
        }else{
            for (int i = 0; i < leng; i++) {
                if(cache.contains(cities[i].toUpperCase())){
                    answer += HIT;
                    cache.remove(cities[i].toUpperCase());
                }else{
                    if(cache.size()>=cacheSize){
                        cache.poll();
                    }
                    answer += MISS;
                }
                cache.add(cities[i].toUpperCase());
            }
        }
        return answer;
    }
}