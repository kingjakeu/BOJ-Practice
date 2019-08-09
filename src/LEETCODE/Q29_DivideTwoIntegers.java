package LEETCODE;

import java.math.BigInteger;

public class Q29_DivideTwoIntegers {
}
class Q29_DivideTwoIntegers_Solution {
    public int divide(int dividend, int divisor) {
        BigInteger divd = new BigInteger(String.valueOf(dividend));
        BigInteger divr = new BigInteger(String.valueOf(divisor));
        String max = String.valueOf(Integer.MAX_VALUE);
        String min = String.valueOf(Integer.MIN_VALUE);

        divd = divd.divide(divr);
        if(divd.compareTo(new BigInteger(max)) == 1){
            return Integer.parseInt(max);
        }
        if(divd.compareTo(new BigInteger(min)) == -1){
            return Integer.parseInt(min);
        }

        String str = divd.toString();
        return Integer.parseInt(str);
    }
}