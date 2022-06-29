//https://www.acmicpc.net/problem/1613
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()){
    //input
    val (n,m) = getIntList()
    val dp = Array(n+1){IntArray(n+1)}
    repeat(m){
        val (to,from) = getIntList()
        dp[to][from] = -1
        dp[from][to] = 1
    }
    for(k in 1 .. n){
        for(i in 1 .. n){
            for(j in 1 .. n){
                if(dp[i][k] == -1 && dp[k][j] == -1){
                    dp[i][j] = -1
                }
                else if(dp[i][k] == 1 && dp[k][j] == 1){
                    dp[i][j] = 1
                }
            }
        }
    }

    //solve, output
    repeat(getInt()){
        val (a,b) = getIntList()
        write("${dp[a][b]}\n")
    }
    close()
}
