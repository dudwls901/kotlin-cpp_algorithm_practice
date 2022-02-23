//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14jJh6ACYCFAYD
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution {
 
    static int[] cnt;
 
    static void printCnt(String str, int num) {
        for (int i = 0; i < cnt[num]; i++) {
            System.out.print(str + " ");
        }
    }
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // input
            br.readLine();
            StringTokenizer tk = new StringTokenizer(br.readLine());
            cnt = new int[10];
            while (tk.hasMoreTokens()) {
                switch (tk.nextToken()) {
                case "ZRO":
                    cnt[0]++;
                    break;
                case "ONE":
                    cnt[1]++;
                    break;
                case "TWO":
                    cnt[2]++;
                    break;
                case "THR":
                    cnt[3]++;
                    break;
                case "FOR":
                    cnt[4]++;
                    break;
                case "FIV":
                    cnt[5]++;
                    break;
                case "SIX":
                    cnt[6]++;
                    break;
                case "SVN":
                    cnt[7]++;
                    break;
                case "EGT":
                    cnt[8]++;
                    break;
                case "NIN":
                    cnt[9]++;
                    break;
                }
            }
             
            // solve
            // output
            System.out.println("#" + t);            
            printCnt("ZRO",0);
            printCnt("ONE",1);
            printCnt("TWO",2);
            printCnt("THR",3);
            printCnt("FOR",4);
            printCnt("FIV",5);
            printCnt("SIX",6);
            printCnt("SVN",7);
            printCnt("EGT",8);
            printCnt("NIN",9);
        }
    }
}
