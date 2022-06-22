//https://www.acmicpc.net/problem/1535
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    val bad = getIntList()
    val good = getIntList()
    val dp = Array(n + 1) { IntArray(100) } // i 번째 사람과 인사했을 때 최댓값
    //solve
    for (i in 1..n) {
        for(j in 1 until 100){
            //인사를 할 수 있을 때
            if (j>=bad[i-1]){
                //인사를 할 때, 인사를 안 할 때의 최댓값을 저장
                dp[i][j] = dp[i-1][j].coerceAtLeast(dp[i-1][j-bad[i-1]] + good[i-1])
            }
            //인사를 할 수 없을 때
            else{
                dp[i][j] = dp[i-1][j]
            }
        }
    }
    //output
    write("${dp[n][99]}")
    close()
}
