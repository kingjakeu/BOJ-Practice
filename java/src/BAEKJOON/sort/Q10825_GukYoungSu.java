package BAEKJOON.sort;

import java.io.*;
import java.util.StringTokenizer;

public class Q10825_GukYoungSu {
    static Info[] infos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        infos = new Info[n];

        Info[] arr = new Info[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Info(br.readLine());
        }
        if(n <= 1){
            infos = arr;
        }else{
            sort(0, n-1, arr);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            bw.write(infos[i].name);
            bw.newLine();
        }
        bw.close();
    }

    public static void sort(int low, int high, Info[] arr){
        if(low < high){
            int mid = (low + high)/2;
            sort(low, mid, arr);
            sort(mid+1 , high, arr);
            merge(low, mid, high, arr);
        }
    }

    public static void merge(int low, int mid, int high, Info[] arr){
        int left = low;
        int right = mid+1;

        for (int i = low; i <= high; i++) {
            if(left > mid) infos[i] = arr[right++];
            else if(right > high) infos[i] = arr[left++];
            else{
                if(arr[left].guk > arr[right].guk){
                    infos[i] = arr[left++];
                }else if(arr[left].guk < arr[right].guk){
                    infos[i] = arr[right++];
                }else {
                    if(arr[left].young < arr[right].young){
                        infos[i] = arr[left++];
                    }else if(arr[left].young > arr[right].young){
                        infos[i] = arr[right++];
                    }else{
                        if(arr[left].su > arr[right].su){
                            infos[i] = arr[left++];
                        }else if(arr[left].su < arr[right].su){
                            infos[i] = arr[right++];
                        }else{
                            if(arr[left].name.compareTo(arr[right].name) < 0){
                                infos[i] = arr[left++];
                            }else{
                                infos[i] = arr[right++];
                            }
                        }
                    }
                }
            }
        }

        for (int i = low; i <= high; i++) {
            arr[i] = infos[i];
        }
    }

    static class Info{
        String name;
        int guk;
        int young;
        int su;

        Info(String line){
            StringTokenizer st = new StringTokenizer(line);
            name = st.nextToken();
            guk = Integer.parseInt(st.nextToken());
            young = Integer.parseInt(st.nextToken());
            su = Integer.parseInt(st.nextToken());
        }
    }
}


