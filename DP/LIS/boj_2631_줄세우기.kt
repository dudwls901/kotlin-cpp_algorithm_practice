//https://www.acmicpc.net/problem/2631
val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()) {
    var answer = 0
    val children = IntArray(getInt()) { getInt() }
    val dp = IntArray(children.size) { 1 }
    for (i in children.indices) {
        var before = 0
        for (j in 0 until i) {
            if (children[j] < children[i]) {
                before = before.coerceAtLeast(dp[j])
            }
        }
        dp[i] = dp[i].coerceAtLeast(before + 1)
        answer = answer.coerceAtLeast(dp[i])
    }
    write("${children.size - answer}")
    close()
}
