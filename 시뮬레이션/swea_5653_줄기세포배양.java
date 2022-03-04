// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRJ8EKe48DFAUo 
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Node{
	public int r,c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
}

class Solution {
	 
    static int n,m,k;
    static int[][] graph;
    static int[][] visited;
    static final int MAX =410;
    static final int DEFAULT =150;
    static final int INF = -999;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static Queue<Node> q;
    static int t;
    static int answer=0;
    //visited !=0 && graph !=0 비활성화 상태
    //visited ==0 && graph !=0 활성화 상태
    //visited ==-1 && graph !=0 번식
    //visited == -x == graph 죽은 상태 
    static void bfs() {
    	int time=0;
    	
    	while(!q.isEmpty()) {
    		if(time++==k) {
    			return;
    		}
    		int size = q.size();
    		//매 턴
    		int [][] temp = new int[MAX][MAX];
    		for(int i=0; i<size; i++) {
    			Node curNode = q.poll();
    			int cr = curNode.r;
    			int cc = curNode.c;
    			
    			visited[cr][cc]--;

    			//번식
    			if(visited[cr][cc]==-1) {
    				for(int d =0; d<4; d++) {
    					int nr = cr + dir[d][0];
    					int nc = cc + dir[d][1];
    					//다음 칸에 이미 뭐가 있으면 스킵 or 덮ㄷ기
    					if(graph[nr][nc]>0) {
    						//만약 동시에 들어온 경우 비교
    						if(temp[nr][nc]>0 && graph[nr][nc] == visited[nr][nc]) {
    							
    							if(graph[nr][nc]<graph[cr][cc]) {
    								graph[nr][nc] = graph[cr][cc];
    								visited[nr][nc] = graph[cr][cc];
    								temp[nr][nc]=graph[cr][cc];
    							}
    						}
    					}
    					else {
    						if(graph[nr][nc]==INF) continue;
        					if(graph[nr][nc]==0) {
        					graph[nr][nc] = graph[cr][cc];
        					visited[nr][nc] = graph[cr][cc];
        					temp[nr][nc]=graph[cr][cc];
        					}	
    					}
    				}
    			}
    				//die
    				if(visited[cr][cc]== -graph[cr][cc]) {
    					graph[cr][cc] =INF;
    				}
    				temp[cr][cc]=graph[cr][cc];
    		}
    		q.clear();
    		answer=0;
    		for(int i=0; i<MAX;i++) {
    			for(int j=0; j<MAX;j++) {
    				if(temp[i][j]>0) {
    					answer++;
    					q.add(new Node(i,j));
    				}
    			}
    		}
    	}
    	
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        int T = Integer.parseInt(br.readLine());
        for(t=1; t<=T; t++) {
            //input
            graph = new int[MAX][MAX];
            visited = new int[MAX][MAX];
            q = new LinkedList<Node>();
            StringTokenizer tk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(tk.nextToken());
            m = Integer.parseInt(tk.nextToken());
            k = Integer.parseInt(tk.nextToken());
            
            for(int i=0; i<n; i++) {
            	tk = new StringTokenizer(br.readLine());
            	for(int j=0; j<m;j ++) {
            		int num = Integer.parseInt(tk.nextToken());
            		if(num>0) 
            			q.add(new Node(DEFAULT+i, DEFAULT+j));
            		
            		visited[DEFAULT+i][DEFAULT+j] = num;
            		graph[DEFAULT+i][DEFAULT+j] = num;
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
