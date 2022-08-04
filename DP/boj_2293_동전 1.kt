//https://www.acmicpc.net/problem/2293
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    val (n,k) = getIntList()
    val dp = IntArray(k + 1)
    dp[0] = 1
    repeat (n) {
        val coin = getInt()
        for (i in coin..k) {
            dp[i] += dp[i - coin]
        }
    }
    write("${dp[k]}")
    close()
}
