//https://www.acmicpc.net/problem/16194
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){

    //input
    val n = getInt()
    val list = getIntList()
    val dp = IntArray(n+1)
    //solve
    for(i in 1 .. n){
        dp[i] = list[i-1]
        for(j in 1 until i){
            dp[i] = dp[i].coerceAtMost(dp[i-j] + dp[j])
        }
    }
    //solve
    write("${dp[n]}")

    close()
}
