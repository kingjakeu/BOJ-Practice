package CODETEST;
import java.io.*;
import java.util.*;

class NHNQ2_Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new LinkedHashMap<>();

        LinkedList<Integer> que = new LinkedList<>();


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(str.contains("enqueue")){
                String[] split = str.split(" ");
                int key = Integer.parseInt(split[1]);
                if(map.containsKey(key)){
                    map.put(key, map.get(key)+1);
                }else{
                    map.put(key, 1);
                }
                que.add(key);
            }else{
                LinkedList<Integer> tmpList = new LinkedList<>();
                tmpList.addAll(que);
                Collections.sort(tmpList, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if(map.get(o1) > map.get(o2)){
                            return -1;
                        }else if(map.get(o1) < map.get(o2)){
                            return 1;
                        }else{

                            return 0;
                        }
                    }
                });
                int poll = tmpList.poll();
                map.put(poll, map.get(poll)-1);
                que.remove(que.indexOf(poll));
                sb.append(poll).append(" ");
            }
        }
        int leng = sb.length()-1;
        String answer = sb.toString();
        if(sb.substring(leng).equals(" ")){
             answer = sb.substring(0, leng);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer);
        bw.close();
    }
}
class FQElement{
    int key;
    int frequency;
    FQElement(int k){
        key = k;
        frequency = 1;
    }
}
public class NHN_Q2 {
}
