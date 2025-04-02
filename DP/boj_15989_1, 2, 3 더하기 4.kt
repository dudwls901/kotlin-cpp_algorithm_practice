//https://www.acmicpc.net/problem/15989
val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().trim().toInt()
fun main() = with(System.out.bufferedWriter()) {
    val dp = IntArray(10001) { 1 }
    for (i in 2 until dp.size) {
        dp[i] += dp[i - 2]
    }
    for (i in 3 until dp.size){
        dp[i] += dp[i - 3]
    }
    repeat(getInt()) {
        write("${dp[getInt()]}\n")
    }
    close()
}
