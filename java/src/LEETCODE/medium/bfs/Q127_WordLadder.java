package LEETCODE.medium.bfs;

import java.util.*;

public class Q127_WordLadder {
    class Solution {
        int length;
        int listSize;
        int answer = Integer.MAX_VALUE;
        boolean[] visited;
        Map<String, Integer> map = new HashMap<>();
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            length = beginWord.length();
            listSize = wordList.size();
            visited = new boolean[listSize];
            for (int i = 0; i < listSize; i++) {
                map.put(wordList.get(i), i);
            }
            if(map.get(endWord)==null) return 0;
            search(beginWord.toCharArray(), endWord, 0);
            return answer;
        }

        public void search(char[] keyWord, String endWord, int count){
            System.out.println(keyWord);
            if(String.valueOf(keyWord).equals(endWord)){
                answer = Math.min(answer, count);
                return;
            }

            for (int i = 0; i < length; i++) {
                if(keyWord[i] != endWord.charAt(i)){
                    char tmpChar = keyWord[i];
                    keyWord[i] = endWord.charAt(i);
                    String newKey = String.valueOf(keyWord);
                    Integer val = map.get(newKey);
                    if(val != null && !visited[val]){
                        visited[val] = true;
                        search(keyWord, endWord, count+1);
                        visited[val] = false;
                    }
                    keyWord[i] = tmpChar;
                }
            }

        }
    }


    class Item{
        char[] word;
        int count;
        Item(char[] w, int c){
            this.word = w;
            this.count = c;
        }
    }
}
