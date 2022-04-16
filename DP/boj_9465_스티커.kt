//https://www.acmicpc.net/problem/9465
import java.util.*
val br = System.`in`.bufferedReader()
fun main() = with(System.out.bufferedWriter()){

    val t= br.readLine().toInt()
    repeat(t){
        //input
        val n = br.readLine().toInt()
        val dp = Array(2){
            val tk = StringTokenizer(br.readLine())
            IntArray(n+1){
                if(it==0){
                    0
                }
                else{
                    tk.nextToken().toInt()
                }
            }
        }
        //solve
        for(c in 2 .. n){
            val pre = dp[0][c-2].coerceAtLeast(dp[1][c-2])
            dp[0][c] += dp[1][c-1].coerceAtLeast(pre)
            dp[1][c] += dp[0][c-1].coerceAtLeast(pre)
        }
        var answer = dp[0][n].coerceAtLeast(dp[1][n])
        //output
        write("$answer\n")
    }

    close()
}
