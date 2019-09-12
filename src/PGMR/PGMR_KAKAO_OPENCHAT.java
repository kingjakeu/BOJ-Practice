package PGMR;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PGMR_KAKAO_OPENCHAT {
}

class PGMR_KAKAO_OPENCHAT_Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String,String> user = new HashMap<>();
        List<String[]> ansList = new LinkedList<>();
        for(String str : record){
            String[] tmpStr = str.split(" ");
            String[] strArr = new String[2];
            if(tmpStr[0].equals("Enter")){
                user.put(tmpStr[1],tmpStr[2]);
                strArr[0] = tmpStr[1];
                strArr[1] = "님이 들어왔습니다.";
                ansList.add(strArr);
            }else if(tmpStr[0].equals("Change")){
                user.put(tmpStr[1],tmpStr[2]);
            }else if(tmpStr[0].equals("Leave")){
                strArr[0] = tmpStr[1];
                strArr[1] = "님이 나갔습니다.";
                ansList.add(strArr);
            }
        }
        List<String> tmpList = new LinkedList<>();
        for(String[] tmpStr : ansList){
            StringBuilder sb = new StringBuilder(user.get(tmpStr[0])).append(tmpStr[1]);
            tmpList.add( String.valueOf(sb));
        }
        return tmpList.toArray(new String[0]);
    }
}