package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q10217_KCMTravel {
    static int des = 0;
    static int maxCost = 0;
    static int minTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int airportNum = Integer.parseInt(st.nextToken());
            int totalCost = Integer.parseInt(st.nextToken());
            int ticketNum = Integer.parseInt(st.nextToken());

            KCMAirport[] airports = new KCMAirport[airportNum];

            for (int i = 0; i < ticketNum; i++) {
                st = new StringTokenizer(br.readLine());
                int tmpStart = Integer.parseInt(st.nextToken())-1;
                int tmpEnd = Integer.parseInt(st.nextToken())-1;
                int tmpCost = Integer.parseInt(st.nextToken());
                int tmpTime = Integer.parseInt(st.nextToken());
                airports[tmpStart].ticket.add(new KCMTicket(tmpEnd,tmpCost,tmpTime));
                airports[tmpEnd].degree += 1;
            }
            des = airportNum-1;
            Queue<KCMAirport> que = new LinkedList<>();
            que.add(airports[0]);
            while(!que.isEmpty()){
                KCMAirport port = que.poll();
                for(KCMTicket ticket : port.ticket){

                    airports[ticket.end].degree -= 1;
                }
            }
        }
    }
}
class KCMAirport{
    int degree = 0;
    LinkedList<KCMTicket> ticket = new LinkedList<>();
}
class KCMTicket{
    int end;
    int cost;
    int time;
    KCMTicket(int e, int c, int t){
        end = e;
        cost = c;
        time = t;
    }
}

