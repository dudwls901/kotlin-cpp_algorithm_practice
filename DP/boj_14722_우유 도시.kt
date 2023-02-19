//https://www.acmicpc.net/problem/14722
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

lateinit var graph: Array<List<Int>>
lateinit var dp: Array<Array<IntArray>>
val dir = arrayOf(
    arrayOf(0, -1),
    arrayOf(-1, 0),
)

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    dp = Array(3) { Array(n) { IntArray(n) } }
    graph = Array(n) { r ->
        val list = getIntList()
        list.forEachIndexed { c, value ->
            //0인 칸은 이전 칸들에서 하나도 안 먹고 오면 우유 먹을 수 있으니 무조건 1
            if (value == 0) dp[0][r][c] = 1
        }
        list
    }
    //solve
    for (r in 0 until n) {
        for (c in 0 until n) {
            for (i in dir.indices) {
                val beforeR = r + dir[i][0]
                val beforeC = c + dir[i][1]
                if (beforeR !in 0 until n || beforeC !in 0 until n) continue
                
                val curMilk = graph[r][c]
                val beforeMilk = (curMilk + 2) % 3
                
                //우유 안 먹는 경우
                dp[0][r][c] = dp[0][r][c].coerceAtLeast(dp[0][beforeR][beforeC])
                dp[1][r][c] = dp[1][r][c].coerceAtLeast(dp[1][beforeR][beforeC])
                dp[2][r][c] = dp[2][r][c].coerceAtLeast(dp[2][beforeR][beforeC])
                
                //우유 먹는 경우 (이전 칸에서 최근에 먹은 우유가 beforeMilk일 때 값이 1이상이라면 우유 이어서 먹을 수 있음)
                if (dp[beforeMilk][beforeR][beforeC] > 0) {
                    dp[curMilk][r][c] = dp[curMilk][r][c].coerceAtLeast(dp[beforeMilk][beforeR][beforeC] + 1)
                }
            }
        }
    }
    //output
    val answer = dp[0][n - 1][n - 1].coerceAtLeast(dp[1][n - 1][n - 1]).coerceAtLeast(dp[2][n - 1][n - 1])
    write("$answer")
    close()
}
