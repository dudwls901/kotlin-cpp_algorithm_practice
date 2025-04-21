//https://www.acmicpc.net/problem/1663
val br = System.`in`.bufferedReader()
fun getStr() = br.readLine().trim()
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()) {
    val case = getInt()
    val n = getInt()
    val dp = LongArray(101)
    val cnts = Array(101) { LongArray(3) }
    dp[1] = 1
    dp[2] = 2
    dp[3] = 2
    cnts[1][0] = 1
    cnts[2][1] = 1
    cnts[2][2] = 1
    cnts[3][0] = 1
    cnts[3][2] = 1

    for (i in 4..n) {
        dp[i] = dp[i - 3] + dp[i - 2]
        for (j in 0 until 3) {
            cnts[i][j] = cnts[i - 3][j] + cnts[i - 2][j]
        }
    }
    when (case) {
        1 -> { //f(n)의 길이는?
            write("${dp[n]}")
        }
        2 -> { //f(n)에서 k번째 문자는?
            val base = arrayOf(
                "X",
                "YZ",
                "ZX",
            )
            var nn = n
            var k = br.readLine().toLong()
            //f(n)이 f(3)이 될 때 까지
            while (nn > 3) {
                val left = dp[nn - 3]
                if (left < k) {
                    nn -= 2
                    k -= left
                } else {
                    nn -= 3
                }
            }
            write("${base[nn-1][k.toInt()-1]}")
        }
        3 -> { //f(n)에서 ch는 몇 개?
            val ch = getStr()[0]
            write("${cnts[n][ch-'X']}")
        }
    }
    close()
}
