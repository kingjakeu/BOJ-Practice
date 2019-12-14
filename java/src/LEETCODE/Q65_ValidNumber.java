package LEETCODE;

public class Q65_ValidNumber {
}
class Q65_ValidNumber_Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean numOn = false;
        boolean e = false;
        boolean dot = false;
        char bf = '!';
        for(char ch : s.toCharArray()){
            if(ch >='0' && ch <='9'){
                if(!numOn){
                    numOn = true;
                }
            }else if(ch == 'e'){
                if(e || !numOn){
                    return false;
                }
                e = true;
                numOn = false;
            }else if(ch == '.'){
                if(dot){
                    return false;
                }
                if(e){
                    return false;
                }
                dot = true;
            }else if(ch == '+' || ch == '-'){
                if(bf != '!' && bf !='e'){
                    return false;
                }
            }else{
                return false;
            }
            bf = ch;
        }
        if(!numOn){
            return false;
        }
        return true;
    }
}