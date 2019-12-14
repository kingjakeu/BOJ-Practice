package LEETCODE;
/**
 * LeetCode #6 ZigZagConversion
 * 2019.07.11
 * @author kingjakeu
 * */
public class Q6_ZigZagConversion {

}
class Q6_ZigZagConversion_Solution {
    static char[] sen;
    static int[] offCount;
    static int offset, leng, idx;
    public String convert(String s, int numRows) {
        leng = s.length();
        offset = numRows+numRows-2;
        offCount = new int[offset];
        sen = new char[leng];
        idx = 0;
        if(numRows <= 1){
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            colToRow(s, i);
        }

        return String.valueOf(sen);
    }
    public void colToRow(String s, int row){
        int tmpIndex = offCount[row]*offset+row;
        int offIndex = offset - (2*row);
        while(tmpIndex<leng){
            int extraIndex = tmpIndex+offIndex;
            sen[idx++] = s.charAt(tmpIndex);
            offCount[row]++;
            if(offIndex >0 && offIndex < offset && extraIndex < leng){
                sen[idx++] = s.charAt(extraIndex);
                offCount[offset-row]++;
            }
            tmpIndex = offCount[row]*offset+row;
        }
    }
}