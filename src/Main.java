import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int[][] start = new int[3][2];
	static int[][] end = new int[3][2];
	static int[][] map;
	static int[][] offset = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args){
    	CustomScanner sc = new CustomScanner();
    	String tmp  = sc.readLine();
    	int n = Integer.parseInt(tmp);
    	map = new int[n][n];
    	
    	
    	
    	int s = 0;
    	int e = 0;
    	
    	for(int i=0; i<n; i++) {
    		tmp = sc.readLine();
    		for(int j=0; j<n; j++) {
    			map[i][j] = tmp.charAt(j);
    			if(map[i][j] == 'B') {
    				start[s][0] = i;
    				start[s][1] = j;
    				s++;
    			}
    			if(map[i][j] == 'E') {
    				end[e][0] = i;
    				end[e][1] = j;
    				e++;
    			}
    		}
    	}
    	B0011
    	B0000
    	B0000
    	11000
    	EEE00
    	
    	B2311
    	22400
    	34450
    	11450
    	EEE00
    	
    }
    static boolean isValid() {
    	boolean b = false;
    	for(int i=0; i<3; i++) {
    		for(int j=0; j<4; j++) {
    			
    		}
    	}
    	
    	return b;
    }
    static class CustomScanner{
    	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	static StringBuilder sb = new StringBuilder("");
    	
    	static String readLine() {
    		try {
    			return br.readLine();
    		}catch(IOException e) {
    			return null;
    		}
    	}
    }
}
