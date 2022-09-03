//https://www.acmicpc.net/problem/1890
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {

    //input
    val n = getInt()
    val input = Array(n){ getIntList()}

    val dp = Array(n) { LongArray(n) }
    dp[0][0] = 1L

    for (r in 0 until n) {
        for (c in 0 until n) {
            if (dp[r][c] == 0L || (r == n - 1 && c == n - 1)) continue
            val nr = r + input[r][c]
            if (nr in 0 until n) {
                dp[nr][c]+=dp[r][c]
            }
            val nc = c + input[r][c]
            if (nc in 0 until n) {
                dp[r][nc]+=dp[r][c]
            }
        }
    }

    write("${dp[n - 1][n - 1]}")
    close()
}
