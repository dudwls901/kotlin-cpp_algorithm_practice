//https://www.acmicpc.net/problem/18427
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n,m,h) = getIntList()


    val student = Array(n) {
        val input = getIntList()
        IntArray(input.size + 1).apply {
            for (i in 1 until this.size) {
                this[i] = input[i - 1]
            }
        }
    }
    //solve
    val dp = Array(n) { IntArray(1001) }
    for (i in student[0].indices) {
        dp[0][student[0][i]]++
    }
    for (i in 1 until n) {
        for (j in student[i].indices) {
            for (k in 0..h) {
                if (k - student[i][j] >= 0) {
                   dp[i][k] = (dp[i][k] + dp[i - 1][k - student[i][j]])%10007
                }
            }
        }
    }
    //output
    write("${dp[n - 1][h]}")

    close()
}
