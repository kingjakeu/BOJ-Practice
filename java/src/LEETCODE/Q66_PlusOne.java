package LEETCODE;

import java.math.BigInteger;

/**
 * LeetCode #66 PlusOne
 * 2019.07.19
 * @author kingjakeu
 */
public class Q66_PlusOne {
}
class Q66_PlusOne_Solution {
    public int[] plusOne(int[] digits) {
        int leng = digits.length;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i<leng; i++) {
            str.append(String.valueOf(digits[i]));
        }

        BigInteger num = new BigInteger(str.toString());
        num = num.add(new BigInteger("1"));
        System.out.println(num);
        str = new StringBuilder(num.toString());
        leng = str.length();
        int[] answer = new int[leng];
        for (int i = 0; i < leng; i++) {
            answer[i] = str.charAt(i) - '0';
        }


        return answer;
    }
}