//https://www.acmicpc.net/problem/1068
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	
	static ArrayList<Integer>[] edge;
	static int n;
	static int delete;
	static int root;
	
	static int dfs(int cur) {
		if(edge[cur].isEmpty()) {
			return 1;
		}
		int sum=0;
		int cnt=0;
		for(int i=0; i<edge[cur].size();i++) {
			int next = edge[cur].get(i);
			if(next==delete) continue;
			cnt++;
			sum+=dfs(next);
		}
		if(cnt==0) return 1;
		return sum;
	}
	
	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		n = Integer.parseInt(br.readLine());
		edge = new ArrayList[n];
		for(int i=0; i<n; i++) {
			edge[i] = new ArrayList();
		}
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0; i<n;i++) {
			int num = Integer.parseInt(tk.nextToken());
			if(num<0) {
				root = i;
				continue;
			}
			edge[num].add(i);
		}
		delete = Integer.parseInt(br.readLine());
		if(delete==root) {
			System.out.println(0);
			br.close();
			return;
		}
		//solve,output
		System.out.println(dfs(root));
		br.close();
	
		return;
	}	
}
