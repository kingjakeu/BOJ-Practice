package PGMR;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class PGMR_KAKAO_NEWSCLUSTER {
    public static void main(String[] args) {
        solution("aa1+aa2","AAAA12");
    }
    public static int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String, Integer> one = preProcess(str1);
        HashMap<String, Integer> two = preProcess(str2);
        if(one.isEmpty() && two.isEmpty()){
            return 65536;
        }
        HashMap<String, Integer> union = one;
        HashMap<String, Integer> inter = new HashMap<>();
        two.entrySet().forEach(entry->{
            if(one.containsKey(entry.getKey())){
                inter.put(entry.getKey(), Math.min(one.get(entry.getKey()),entry.getValue()));
            }

        });
        two.entrySet().forEach(entry->{
            if(!one.containsKey(entry.getKey())){
                union.put(entry.getKey(), entry.getValue());
            }else{
                union.put(entry .getKey(), Math.max(entry.getValue(), union.get(entry.getKey())));
            }
        });
        double interNum = inter.values().stream().mapToInt(i->i).sum();
        double unionNum = union.values().stream().mapToInt(i->i).sum();
        answer = (int)((interNum/unionNum)*65536);
        return answer;
    }
    public static HashMap<String, Integer> preProcess(String str){
        int length = str.length();
        HashMap<String, Integer>  list = new HashMap<>();
        for (int i = 1; i < length; i++) {
            String tmp = str.substring(i-1,i+1);
            if(Pattern.matches("[a-zA-z]*",tmp)){
                tmp = tmp.toUpperCase();
                if(!list.containsKey(tmp)){
                    list.put(tmp,1);
                }else{
                    list.put(tmp,list.get(tmp)+1);
                }
            }
        }
        return list;
    }
}
