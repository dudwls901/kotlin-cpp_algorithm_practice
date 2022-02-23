//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18KWf6ItECFAZN
//무지성 완탐했는데, lcp(최장 공통 접두사)로 풀어보기 (접미사 배열 + lcp)
//https://idea-sketch.tistory.com/25
import java.util.Iterator;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// input
			int k =Integer.parseInt(br.readLine());
			String input = br.readLine();
			TreeSet<String> set = new TreeSet();
			// solve
			for(int i=0; i< input.length();i++) {
				for(int j= i+1; j<= input.length(); j++) {
					set.add(input.substring(i,j));
				}
			}
			String answer="none";
			int i=0;
			Iterator it = set.iterator();
			while(it.hasNext()) {
				answer=(String) it.next();
				i++;
				if(i==k) {
					break;
				}
			}
			if(i!=k) answer ="none";
			// output
			System.out.println("#" + t +" "+ answer);			
		}
	}
}
