//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeRZV6kBUDFAVH
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class Solution {
         
    static int n;
    static int operators[] = new int[4];
    static int nums[];
    static int minVal,maxVal;
    static boolean visited[];
     
    static int cal(int before,int after, int idx) {     
        switch(idx) {
            case 0: return before + after;
            case 1: return before - after;
            case 2: return before * after;
            case 3: return before / after;
        }
        return -1;
    }
     
    //연산자를 기준으로 순열
    static void permutation(int idx, int result) {
        if(idx==n-1) {
            minVal = Math.min(minVal, result);
            maxVal = Math.max(maxVal, result);
            return;
        }
         
        for(int i=0; i<4; i++) {
            if(operators[i]<1) continue;
            operators[i]--;
            permutation(idx+1,cal(result,nums[idx+1],i));
            operators[i]++;
        }
    }
     
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            //input
            n = Integer.parseInt(br.readLine());
            nums = new int[n];
            visited = new boolean[n];
            minVal = Integer.MAX_VALUE;
            maxVal = Integer.MIN_VALUE;
            StringTokenizer tk = new StringTokenizer(br.readLine());
            for(int i=0; i< 4; i++) {
                operators[i] = Integer.parseInt(tk.nextToken());
            }
            tk = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                nums[i] = Integer.parseInt(tk.nextToken());
            }
             
            //solve
            permutation(0,nums[0]);
            // output   
             bw.write("#"+ t + " "+ (maxVal-minVal)  +"\n");
 
        }
        bw.close();
    }
}
