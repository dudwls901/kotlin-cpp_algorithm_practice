//https://www.acmicpc.net/problem/2294
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    val (n,k) = getIntList()
    val dp = IntArray(k+1){Int.MAX_VALUE}
    dp[0] = 0
    repeat(n){
        val coin = getInt()
        for(i in coin .. k){
            if(dp[i-coin]!=Int.MAX_VALUE) {
                dp[i] = dp[i].coerceAtMost(dp[i-coin]+1)
            }
        }
    }
    if(dp[k]==Int.MAX_VALUE){
        write("-1")
    }
    else {
        write("${dp[k]}")
    }
    close()
}
