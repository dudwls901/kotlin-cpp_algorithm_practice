//https://www.acmicpc.net/problem/11060
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

const val INF = 987654321
fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    val list = getIntList()

    //solve
    val dp = IntArray(n) { INF }
    dp[0] = 0
    for (i in 0 until n - 1) {
        val ai = list[i]
        for(j in i .. i+ai){
            if(j >=n) break
            dp[j] = dp[j].coerceAtMost(dp[i]+1)
        }
    }
    //output
    write("${if(dp[n-1] == INF) -1 else dp[n-1]}")

    close()
}
