//https://www.acmicpc.net/problem/2660
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var dp: Array<IntArray>
const val INF = 1000
fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    dp = Array(n + 1) {r ->
        IntArray(n + 1) {c ->
            if(r==c) 0
            else INF
        }
    }
    //solve
    while (true) {
        val tk = StringTokenizer(br.readLine())
        val (from, to) = List(2) { tk.nextToken().toInt() }
        if (from == -1) break
        dp[from][to] = 1
        dp[to][from] = 1
    }
    
    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                dp[i][j] = dp[i][j].coerceAtMost(dp[i][k] + dp[k][j])
            }
        }
    }
    var minScore = Int.MAX_VALUE
    for (i in 1..n) {
        var maxScore = 0
        for(j in 1..n){
            if(i!=j){
                maxScore = maxScore.coerceAtLeast(dp[i][j])
            }
        }
        minScore = minScore.coerceAtMost(maxScore!!)
    }
    var candidateArr = ArrayList<Int>()
    for( i in 1..n){
        var maxScore = 0
        for(j in 1..n){
            if(i!=j){
                maxScore = maxScore.coerceAtLeast(dp[i][j])
            }
        }
        if(minScore == maxScore){
            candidateArr.add(i)
        }
    }

    write("$minScore ${candidateArr.size}\n${candidateArr.sorted().joinToString(" ")}")

    close()
}
