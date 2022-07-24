//https://www.acmicpc.net/problem/11055
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    val n = getInt()
    val input = getIntList()
    val dp = IntArray(n)
    var answer = 0
    for (i in 0 until n) {
        dp[i] = input[i]
        for(j in 0 until i){
            if(input[i] > input[j]){
                if(dp[i] < dp[j]+input[i]){
                    dp[i] = dp[j] + input[i]
                }
            }
        }
        answer = answer.coerceAtLeast(dp[i])
    }
    write("$answer")
    close()
}
