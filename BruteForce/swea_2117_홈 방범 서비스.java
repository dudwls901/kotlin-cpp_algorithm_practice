//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
class Solution {
 
    static int n,m;
    static int[][] graph;
    static int[][] homePos;
    static int homeCnt;
    static int k;
     
    static int solve() {
        int answer=0;
        //찾아도 바로 끝내면 안 되고 현재 k까진 다 돌려봐야 최댓값을 뽑을 수 있다.
        while(k-->0) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    int cnt=0;
                    //맨하탄 거리가 k보다 작다면 방범 서비스에 포함
                    for(int idx=0; idx<homeCnt;idx++) {
                        int r,c;
                        r = homePos[idx][0];
                        c = homePos[idx][1];
                        if(Math.abs(i-r)+Math.abs(j-c)<k)cnt++;
                    }
                    if(k*k+(k-1)*(k-1)<= cnt*m && answer<cnt)
                        answer = cnt;
                }
            }
            if(answer>0) return answer;
        }
        return 0;
    }
     
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            //input
            StringTokenizer tk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(tk.nextToken());
            m = Integer.parseInt(tk.nextToken());
            k = n+2;
            graph = new int[n][n];
            homePos = new int[n*n][2];
            homeCnt=0;
            for(int i=0; i<n; i++) {
                tk = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    graph[i][j] = Integer.parseInt(tk.nextToken());
                }
            }
            //solve
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(graph[i][j]==1) {
                        homePos[homeCnt][0]=i;
                        homePos[homeCnt++][1]=j;
                    }
                }
            }
            int answer = solve();
            //output
            bw.write("#" + t+ " " + answer +'\n');
        }
        bw.close(); 
    }
}
