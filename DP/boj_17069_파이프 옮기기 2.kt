//https://www.acmicpc.net/problem/17069
import java.util.*
val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().toInt()
const val MAX = 33
val graph = Array(MAX) { IntArray(MAX) }
val dp = Array(3) { Array(MAX) { LongArray(MAX) } }
fun solve(n: Int): Long {
    dp[0][0][1] = 1
    for (r in 0 until n) {
        for (c in 0 until n) {
            if (r == 0 && c == 0) continue
            if (graph[r][c] == 1) continue
            if (graph[r][c + 1] == 0) //가로
                dp[0][r][c + 1] = dp[0][r][c] + dp[2][r][c]
            if(graph[r+1][c] == 0)//세로
                dp[1][r+1][c] = dp[1][r][c] + dp[2][r][c]
            if(graph[r+1][c+1] == 0 && graph[r][c+1] == 0 && graph[r+1][c] == 0) //대각
                dp[2][r+1][c+1] = dp[0][r][c] + dp[1][r][c] + dp[2][r][c]
        }
    }
    return dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1]
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    for (i in 0 until n) {
        val tk = StringTokenizer(br.readLine())
        var idx = 0
        while (tk.hasMoreTokens()) {
            graph[i][idx++] = tk.nextToken().toInt()
        }
    }
    //solve, output
    write("${solve(n)}")
    close()
}
