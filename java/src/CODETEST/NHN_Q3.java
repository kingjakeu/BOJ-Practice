package CODETEST;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {

    static HashMap<Integer, LinkedList<Integer>> follower = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int playerNum = Integer.parseInt(br.readLine());
        int[] player = new int[playerNum];
        //HashMap<Integer, LinkedList<Integer>> follower = new HashMap<>();

        int idx = 0;
        int everyGetCandy =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String s = st.nextToken();
            if (s.equals("A")){
                player[idx] += 1;
                followerGetCandy(player, idx);
            }else if(s.equals("J")){
                int right = (idx +1 >= playerNum) ? 0 : idx+1;
                int left = (idx -1 < 0) ? playerNum-1 : idx-1;
                player[right] += 1;
                player[left] += 1;
                followerGetCandy(player, right);
                followerGetCandy(player, left);
            }else if(s.equals("K")){
                int f = Integer.parseInt(st.nextToken());
                if(!follower.containsKey(idx)){
                    follower.put(idx, new LinkedList<>());
                }
                follower.get(idx).add(f);
            }else if(s.equals("Q")){
                everyGetCandy += 1;
            }

            idx += 1;
            if(idx >= playerNum){
                idx = 0;
            }
            System.out.println("aa");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playerNum-1; i++) {
            sb.append(String.valueOf(player[i]+everyGetCandy)).append(" ");
        }
        sb.append(String.valueOf(player[playerNum-1]+everyGetCandy));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }
    public static void followerGetCandy(int[] player, int idx){
        if(follower.containsKey(idx)){
            for(int f : follower.get(idx)){
                followerGetCandy(player, f);
                player[f] += 1;
            }
        }else{
            return;
        }
    }
}
public class NHN_Q3 {
}
