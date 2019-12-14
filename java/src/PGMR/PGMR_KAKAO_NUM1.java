package PGMR;

public class PGMR_KAKAO_NUM1 {
    public static void main(String[] args) {
        PGMR_KAKAO_NUM1_Solution s = new PGMR_KAKAO_NUM1_Solution();
        s.solution("aabbaccc");
    }
}
class PGMR_KAKAO_NUM1_Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = length;
        for (int i = 1; i <= length; i++) {
            int rmdr = length%i;
            String std = s.substring(0,i);
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < length-rmdr; j+=i) {
                String tmp = s.substring(j, j+i);
                if(std.equals(tmp)){
                    count += 1;
                }else{
                    if(count > 1){
                        sb.append(count).append(std);
                    }else{
                        sb.append(std);
                    }
                    std = tmp;
                    count = 1;
                }
            }
            if(count>1){
                sb.append(count).append(std);
            }else{
                sb.append(std);
            }
            sb.append(s.substring(length-rmdr, length));
            answer = Math.min(answer,sb.length());
            System.out.println(sb);
            System.out.println(answer);
        }
        return answer;
    }
}