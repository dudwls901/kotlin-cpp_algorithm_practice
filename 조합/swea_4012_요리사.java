//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

	static int[][] edge;
	static boolean[] selects;
	static int n;
	static int answer;
	
	static int cal() {
		int x=0;
		int y=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				if(selects[i] && selects[j]) {
					x+=edge[i][j];
				}
				else if(!selects[i] && !selects[j]){
					y+=edge[i][j];
				}
			}
		}
		return Math.abs(x-y);
	}
	
	static void combination(int idx, int cnt) {
		if(cnt==n/2) {
			answer = Math.min(answer,cal());
			return;
		}
		
		for(int i=idx; i< n; i++) {
			selects[i]=true;
			combination(i+1,cnt+1);
			selects[i]=false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			//input
			n = Integer.parseInt(br.readLine());
			edge = new int[n][n];
			selects = new boolean[n];
			answer = Integer.MAX_VALUE;
			
			for(int i=0; i<n; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					edge[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			//solve
			combination(0,0);
			
			//output
			bw.write("#" + t+ " " + answer +'\n');
		}
		bw.close();	
	}   
}
