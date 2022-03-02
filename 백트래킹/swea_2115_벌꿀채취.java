//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

	// 3<=n<=10
	// 1<=m<=5
	// 10<=c<=30
	//1. 두 팀 선택 (backtracking)
	//2. 팀 선택 표시  (setSelect)
	//3.1 c이하 최댓값 설정 (setMax)
	//3.2 c이하 최댓값 설정 (combination)
	//selected[i][j] i,j번째 칸의 상태
	//1 = 1팀 
	//2 = 2팀
	
	static int[][] selected;
	static int[][] graph;
	static int N,M,C;
	static int answer;
	static int[] max = new int[3];

	static void combination(int cnt, int r, int c, int sum, int cost) {

		if(sum>C) {
			return;
		}
		
		max[cnt] = Math.max(max[cnt],cost);
		
		if(c>=N) return;
		if(selected[r][c]!=cnt) return;
		combination(cnt,r,c+1,sum+graph[r][c],cost + graph[r][c]*graph[r][c]);
		combination(cnt,r,c+1,sum,cost);
	}
	
	
	static void setSelect(int cnt, int r, int c) {
		for(int i=0; i<M; i++) {
			//select 설정
			if(selected[r][c+i]==0) {
				selected[r][c+i] = cnt;
			}
			//select 해제
			else{
				selected[r][c+i] = 0;
			}
		}
	}
	
	static void setMax() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(selected[i][j]==1) {
					if(max[1]!=0) continue;
					combination(1,i,j,0,0);
				}
				else if(selected[i][j]==2) {
					if(max[2]!=0) continue;
					combination(2,i,j,0,0);
				}
			}
		}
	}
	
	static void backtracking(int cnt, int idx) {
		//두 팀 만들어진 경우
		if(cnt==3) {
			//max 초기화
			max[1] = max[2] = 0;
			setMax();
			answer = Math.max(answer, max[1] + max[2]);
			return;
		}
		//그래프 끝에 도착
		if(idx>=N*N) return;
		
		int r = idx/N;
		int c = idx%N;
		
		//그래프 넘어가는 경우 다음 행으로 패쓰
		if(c+M>N) {
			backtracking(cnt,(idx+M) - (idx+M)%N);
		}
		else {
			//선택하고 다음 팀 고르기
			setSelect(cnt,r,c);
			backtracking(cnt+1,idx+M);
			setSelect(cnt,r,c);
			//선택하지 않고 다음 칸에서 현재 팀 고르기
			backtracking(cnt,idx+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			//input
			StringTokenizer tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			M = Integer.parseInt(tk.nextToken());
			C = Integer.parseInt(tk.nextToken());
			selected = new int[N][N];
			graph = new int[N][N];
			answer=0;
			for(int i=0; i<N; i++) {
				tk = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					graph[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			//solve
			backtracking(1,0);
			
			//output
			bw.write("#" + t+ " " + answer +'\n');
		}
		bw.close();
	}
}
