//https://www.acmicpc.net/problem/17485
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getStr() = br.readLine().trim()
fun getInt() = br.readLine().trim().toInt()

lateinit var graph: Array<List<Int>>

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, m) = getIntList()
    graph = Array(n) { getIntList() }
    val dp = Array(n + 1) { Array(m) { IntArray(3) { Int.MAX_VALUE } } }
    for (c in 0 until m) {
        dp[0][c].fill(0)
    }
    //solve
    for (r in 1..n) {
        for (c in 0 until m) {
            if (r - 1 in 0 until n && c + 1 in 0 until m)
            dp[r][c][0] = dp[r][c][0].coerceAtMost(dp[r - 1][c + 1][1].coerceAtMost(dp[r - 1][c + 1][2]) + graph[r - 1][c])
            if (r - 1 in 0 until n)
            dp[r][c][1] = dp[r][c][1].coerceAtMost(dp[r - 1][c][0].coerceAtMost(dp[r - 1][c][2]) + graph[r - 1][c])
            if (r - 1 in 0 until n && c - 1 in 0 until m)
            dp[r][c][2] = dp[r][c][2].coerceAtMost(dp[r - 1][c - 1][0].coerceAtMost(dp[r - 1][c - 1][1]) + graph[r - 1][c])
        }
    }
    var answer = Int.MAX_VALUE
    for (c in 0 until m) {
        answer = answer.coerceAtMost(dp[n][c].minOrNull()!!)
    }
    //output
    write("$answer")
    close()
}
