//https://www.acmicpc.net/problem/7579
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getLongList() = br.readLine().split(' ').map { it.toInt() }

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, m) = getIntList()
    val bytes = getLongList()
    val costs = getLongList()
    val dp = Array(n+1){LongArray(100001)}

    for(i in 1 .. n){
        for(j in dp[0].indices){
            if(costs[i-1]<=j){
                dp[i][j] = (dp[i-1][j]).coerceAtLeast(dp[i-1][j-costs[i-1]]+bytes[i-1])
            }
            else{
                dp[i][j] = dp[i-1][j]
            }
        }
    }
    var answer = 0
    for(i in dp[n].indices){
        if(dp[n][i]>=m){
            answer = i
            break
        }
    }
    write("$answer")
    close()
}
