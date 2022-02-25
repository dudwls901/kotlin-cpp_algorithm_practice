//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18OR16IuUCFAZN 
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class Solution {
     
    static char[][] graph;
    static int[][] subMatrix = new int[21][2];
    static int[][] dp = new int[21][21];
    static int[] d = new int[21];
    static int mCnt =0;
    static int n;
     
    static void getSubMatrix(int i, int j) {
        int r=0,c=0;
        for(; i+r<n && graph[i+r][j]!='0'; r++) {
            for(c=0; j+c<n && graph[i+r][j+c]!='0'; c++) {
                graph[i+r][j+c] ='0';
            }
        }
        subMatrix[mCnt][0] = r;
        subMatrix[mCnt][1] = c;
        mCnt++;
    }
     
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // input
            mCnt=0;
            n =Integer.parseInt(br.readLine());
            graph = new char[n][n];
            for(int i=0; i<n; i++) {
                StringTokenizer tk = new StringTokenizer(br.readLine());
                for(int j=0; j<n ;j++) {
                    graph[i][j] = tk.nextToken().charAt(0);
                }
            }
            //solve
            //getsubMatrix
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(graph[i][j]!='0') {
                        getSubMatrix(i,j);
                    }
                }
            }
 
            int start;
            for(start=0; start< mCnt; start++) {
                 
                 
                int j;
                for(j=0; j< mCnt;j++) {
                    if(subMatrix[start][0] == subMatrix[j][1]) break;
                }
                //수행 가능한 행렬 곱셈 순서가 없는 경우
                if(j==mCnt) break;
                 
            }
            //연쇄 행렬로부터 d값 추출
            //d는 매트릭스를 곱셈 순서에 맞게 행렬 곱셉에 필요한 가운데 값을 저장한다.
            //ex) aXb * bXc 에서 b를 저장한다. 단, 시작 점인 d[0]은 시작 행렬의 aXb에서 a를 저장 
            d[0] = subMatrix[start][0];
             
            for(int i=0; i<mCnt; i++) {
                for(int j=0; j< mCnt; j++) {
                    if(subMatrix[j][0] == d[i]) {
                        d[i+1] = subMatrix[j][1];
                        break;
                    }
                }
            }
             
            //dp 초기화
            for(int i=0; i<= mCnt;i++) {
                for(int j=0; j<= mCnt; j++) {
                    if(i==j) {
                        dp[i][j] = 0;
                    }
                    else {
                        dp[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
 
            //점화식으로 dp 채워넣기
            //dp[i][j] ==  i에서 j까지 연결했을 때의 최소 행렬 곱셈
            for(int x=1; x<= mCnt; x++) {
                for(int i=1; i<= mCnt-x; i++) {
                    int j= i+x;
                    int temp;
                    for(int k=i; k<=j-1; k++) {
                        temp = dp[i][k] + dp[k+1][j] + d[i-1]*d[k]*d[j];
                        if(temp < dp[i][j]) {
                            dp[i][j] = temp;
                        }
                    }
                }
            }
            // output   
             bw.write("#"+ t + " " +dp[1][mCnt] +"\n");
        }
        bw.close();
    }
}
