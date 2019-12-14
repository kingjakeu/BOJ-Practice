package LEETCODE;

import java.util.HashSet;

public class Q804_UniqueMorseCodeWords {
}
class Q804_UniqueMorseCodeWords_Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] alpha = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            int length = word.length();
            for (int i = 0; i < length; i++) {
                sb.append(alpha[word.charAt(i)-97]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}