package PGMR;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

public class PGMR_KAKAO_ChuSukTraffic {
}
class PGMR_KAKAO_ChuSukTraffic_Solution {
    public int solution(String[] lines) {
        int answer = 1;
        int length = lines.length;
        for (int i = 0; i < length; i++) {
            String[] strArr = lines[i].split(" ");
            LocalTime lt = LocalTime.parse(strArr[1]);
            LocalTime maxLt = LocalTime.MAX;

            if(lt.isBefore(maxLt.minusSeconds(1))){
                maxLt = lt.plusSeconds(1);
            }
            int traffic = 1;
            for (int j = i+1; j < length; j++) {
                String[] tempStrArr = lines[j].split(" ");
                LocalTime tempLt = LocalTime.parse(tempStrArr[1]);
                LocalTime tempMinLt = LocalTime.MIN;
                String tempNanoStr = tempStrArr[2].replace("s","");
                long tempNanoSec = (long)(Double.parseDouble(tempNanoStr)*1000)-1;
                if(tempLt.isAfter(LocalTime.MIN.plus(tempNanoSec,ChronoUnit.MILLIS))){
                    tempMinLt = tempLt.minus(tempNanoSec, ChronoUnit.MILLIS);
                }

                if (tempMinLt.isBefore(maxLt)){
                    traffic+=1;
                }
            }
            answer = Math.max(traffic,answer);
        }
        return answer;
    }
}