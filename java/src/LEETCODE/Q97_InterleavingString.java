package LEETCODE;

public class Q97_InterleavingString {
}
class Q97_InterleavingString_Solution {

    char[] ch1;
    char[] ch2;
    char[] ch3;
    int leng1, leng2, leng3;
    public boolean isInterleave(String s1, String s2, String s3) {
        ch1 = s1.toCharArray();
        ch2 = s2.toCharArray();
        ch3 = s3.toCharArray();
        leng1 = s1.length();
        leng2 = s2.length();
        leng3 = s3.length();
        return search(0, 0, 0);
    }
    public boolean search(int idx1, int idx2, int idx3){
        if(idx1==leng1 && idx2==leng2 && idx3==leng3){
            return true;
        }
        if(idx3 < leng3) {
            return ((idx1 < leng1) && (ch1[idx1] == ch3[idx3]) && search(idx1 + 1, idx2, idx3 + 1))
                    || ((idx2 < leng2) && (ch2[idx2] == ch3[idx3]) && search(idx1, idx2 + 1, idx3 + 1));
        }else{
            return false;
        }
    }
}
