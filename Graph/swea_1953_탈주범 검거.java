//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Node {
	public int r,c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}

}

class Solution {

	static int n,m,sr,sc,l;
	static int[][] graph;
	static boolean[][] visited;
	static int answer;
	static int t;
	//상우하좌
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][] haveDir = {
			{},//0
			{0,1,2,3},//1
			{0,2},//2
			{1,3},//3
			{0,1},//4
			{1,2},//5
			{2,3},//6
			{0,3}//7
	};
	
	static boolean canGo(int r, int c, int direct) {
		int curDir = graph[r][c];
		for(int d : haveDir[curDir]) {
			if(d==direct) 
				return true;
		}
		return false;
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(sr,sc));
		visited[sr][sc] = true;
		int time=1;
		
		if(time==l) return;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int s =0; s<size; s++) {
				Node cur = q.poll();
				int curTunnel = graph[cur.r][cur.c];

				for(int i=0; i<haveDir[curTunnel].length;i++) {
					int curDir = haveDir[curTunnel][i];
					int nr = cur.r + dir[curDir][0];
					int nc = cur.c + dir[curDir][1];
				
					if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
					if(graph[nr][nc]==0) continue;
					//다음 노드가 반대 방향 가지고 있으면 canGo == true 
					if(!canGo(nr,nc,(curDir+2)%4)) continue;
					if(visited[nr][nc]) continue;

					visited[nr][nc] = true;
					answer++;
					q.add(new Node(nr,nc));
				}
			}
			if(++time==l) return;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		for(t=1; t<=T; t++) {
			//input
			answer=1;
			StringTokenizer tk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tk.nextToken());
			m = Integer.parseInt(tk.nextToken());
		    sr = Integer.parseInt(tk.nextToken());
			sc = Integer.parseInt(tk.nextToken());
			l = Integer.parseInt(tk.nextToken());
			
			graph = new int[n][m]; 
			visited = new boolean[n][m];
		
			for(int i=0; i<n; i++) {
				tk = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					graph[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			
			//solve
			bfs();

			//output
			bw.write("#" + t+ " " + answer +'\n');
		}
		bw.close();	
	}
}
