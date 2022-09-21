//https://www.acmicpc.net/problem/1633
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()) {
     //input
    val scoreList = ArrayList<List<Int>>()
    var input = br.readLine()
    scoreList.add(emptyList())
    while (!input.isNullOrBlank()) {
        input = input.trim()
        scoreList.add(input.split(' ').map { it.toInt() })
        input = br.readLine()
    }
    val dp = Array(scoreList.size + 1) { Array(16) { IntArray(16) } }
    var answer = 0
    //solve
    for (i in 1 until scoreList.size) {
        for (w in 0..15) {
            for (b in 0..15) {
                val white = if (w > 0) dp[i - 1][w - 1][b] + scoreList[i][0] else 0
                val black = if (b > 0) dp[i - 1][w][b - 1] + scoreList[i][1] else 0
                dp[i][w][b] = dp[i - 1][w][b].coerceAtLeast(white.coerceAtLeast(black))
                if (w == 15 && b == 15) {
                    answer = answer.coerceAtLeast(dp[i][w][b])
                }
            }
        }
    }
    //output
    write("$answer")
    close()
}
