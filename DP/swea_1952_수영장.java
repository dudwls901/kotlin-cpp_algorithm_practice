//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq
import java.util.StringTokenizer;
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
            int[] cost = new int[4];
            int[] calendar = new int[13];
            int[] dp = new int[13];
            StringTokenizer tk = new StringTokenizer(br.readLine());
            for(int i=0; i<4 ;i++) {
                cost[i] = Integer.parseInt(tk.nextToken());
            }
            tk = new StringTokenizer(br.readLine());
            for(int i=1; i<= 12 ; i++) {
                calendar[i] = Integer.parseInt(tk.nextToken());
            }
             
            //solve
            dp[1] = Math.min(cost[0]*calendar[1], cost[1]);
            dp[2] = dp[1] + Math.min(cost[0]*calendar[2], cost[1]);
            for(int i=3; i<=12; i++ ) {
                //일일권, 한 달 권
                dp[i] = dp[i-1] + Math.min(cost[0]*calendar[i], cost[1]);
                //vs 3달권
                dp[i] = Math.min(dp[i],  dp[i-3] +cost[2] );
            }
            //vs 연간권
            dp[12] = Math.min(dp[12], cost[3]);
             
            // output   
             bw.write("#"+ t + " "+ dp[12]  +"\n");
              
        }
        bw.close();
    }
}
