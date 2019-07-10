package LEETCODE;

import java.math.BigInteger;
/**
 * LeetCode #2 AddTwoNumbers
 * 2019.07.10
 * @author kingjakeu
 * */
public class Q2_AddTwoNumbers {
}
class Q2_AddTwoNumbers_Solution {
	 public BigInteger addList(AddTwoNumbers_ListNode node) {
		AddTwoNumbers_ListNode tmpNode = node;
	    int pow = 0;
	    BigInteger sum = BigInteger.ZERO;
	    while(tmpNode != null) {
	    	BigInteger t = BigInteger.valueOf(tmpNode.val);
            BigInteger mul = BigInteger.ONE;
            for(int i=0; i<pow; i++){
                mul = mul.multiply(BigInteger.TEN);
            }
	    	t = t.multiply(mul);
	    	sum = sum.add(t);
	        pow++;
	        tmpNode = tmpNode.next;
	    }
	    return sum;
	 }
     public AddTwoNumbers_ListNode addTwoNumbers(AddTwoNumbers_ListNode l1, AddTwoNumbers_ListNode l2) {
    	BigInteger sum = addList(l1);
    	sum = sum.add(addList(l2));
    	String total = String.valueOf(sum);
    	int leng = total.length();
    	AddTwoNumbers_ListNode answer = new AddTwoNumbers_ListNode(Integer.parseInt(total.substring(leng-1,leng)));
    	AddTwoNumbers_ListNode tmpNode = answer;
    	for(int i=leng-1; i>0; i--) {
    		tmpNode.next = new AddTwoNumbers_ListNode(Integer.parseInt(total.substring(i-1,i)));
            tmpNode = tmpNode.next;
    	}
    	return answer;
    }
}
class AddTwoNumbers_ListNode {
	 int val;
	 AddTwoNumbers_ListNode next;
	 AddTwoNumbers_ListNode(int x) { val = x; }
}