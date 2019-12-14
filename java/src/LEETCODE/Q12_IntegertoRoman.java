package LEETCODE;

public class Q12_IntegertoRoman {
}
class Q12_IntegertoRoman_Solution {
    public String intToRoman(int num) {
        String[] symbol = {"I", "V", "X", "L", "C", "D", "M"};
        int[] value = {1, 5, 10, 50, 100, 500, 1000};
        StringBuilder sb = new StringBuilder("");
        for(int i = 6; i >= 0; i = i-2){
            int divd = num/value[i];
            num = num%value[i];
            if(divd==9){
                sb.append(symbol[i]);
                sb.append(symbol[i+2]);
            }else if(divd==4){
                sb.append(symbol[i]);
                sb.append(symbol[i+1]);
            }else{
                if(divd>=5){
                    sb.append(symbol[i+1]);
                    divd = divd-5;
                    num = num%value[i+1];
                }
                for (int j = 0; j < divd; j++) {
                    sb.append(symbol[i]);
                }
            }

        }
        return sb.toString();
    }
}