package BAEKJOON;

import java.io.*;
import java.util.*;

public class Q16235_Namu {
    static int n;
    static int[][] offset = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] energy = new int[n][n];
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                energy[i][j] = 5;
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Map<String, LinkedList<Integer>> trees = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int year = Integer.parseInt(st.nextToken());

            String key = x + " "+y;
            LinkedList<Integer> list;

            list = trees.get(key);
            if(list == null) list = new LinkedList<>();
            list.add(year);

            trees.put(key, list);
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = 0;
            int[][] reEnergy = new int[n][n];
            //spring
            Map<String, LinkedList<Integer>> newTrees = new HashMap<>();
            for (Map.Entry<String, LinkedList<Integer>> tree : trees.entrySet()){
                if(i == 0) Collections.sort(tree.getValue());

                String[] str = tree.getKey().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);

                LinkedList<Integer> oldList = tree.getValue();

                LinkedList<Integer> newList = newTrees.get(tree.getKey());
                if(newList == null) newList = new LinkedList<>();

                int bunSik = 0;
                int newSize = 0;
                int oldSize = oldList.size();
                for (int j = 0; j < oldSize; j++) {
                    int year = oldList.pop();
                    if(energy[y][x] - year >= 0){
                        energy[y][x] -= year;
                        newList.addLast(++year);
                        newSize++;
                        if(year > 0 && year % 5 == 0){
                            bunSik += 1;
                        }
                    }else{
                        reEnergy[y][x] += year/2;
                    }
                }
                if(newSize > 0){
                    newTrees.put(tree.getKey(), newList);
                }

                int bunSiked = 0;
                if(bunSik > 0){
                    for (int j = 0; j < 8; j++) {
                        int dx = x + offset[j][0];
                        int dy = y + offset[j][1];
                        if(dx >=0 && dx< n && dy >=0 && dy<n){
                            String key = dx+" "+dy;
                            LinkedList<Integer> list = newTrees.get(key);
                            if(list == null) list = new LinkedList<>();
                            for (int l = 0; l < bunSik; l++) {
                                list.addFirst(1);
                                bunSiked++;
                            }
                            newTrees.put(key, list);
                        }
                    }
                }
                sum += newSize;
                sum += bunSiked;
            }

            // summer && winter
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    energy[j][l] += (reEnergy[j][l] + A[j][l]);
                }
            }
            trees = newTrees;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sum));
        bw.close();
    }
}
