//https://www.acmicpc.net/problem/21317
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val INF = 1_000_000
    val n = getInt()
    val bridge = Array(n + 4) { Pair(0, 0) }
    val dp = Array(n + 4) { IntArray(2) { INF } }
    for (i in 1 until n) {
        val (a, b) = getIntList()
        bridge[i] = Pair(a, b)
    }
    val k = getInt()
    //solve
    dp[1][0] = 0
    for(i in 1 .. n){
        dp[i+1][0] = dp[i+1][0].coerceAtMost(dp[i][0] + bridge[i].first)
        dp[i+2][0] = dp[i+2][0].coerceAtMost(dp[i][0] + bridge[i].second)
        dp[i+3][1] = (dp[i+2][1]+bridge[i+2].first).coerceAtMost(dp[i+1][1]+bridge[i+1].second)
        dp[i+3][1] = dp[i+3][1].coerceAtMost(dp[i][0]+k)
    }
    //output
    write("${dp[n][0].coerceAtMost(dp[n][1])}")
    close()
}
