//https://www.acmicpc.net/problem/4097
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    while(true){
        val n = getInt()
        if(n == 0) break
        val input = IntArray(n){ getInt()}
        val dp = IntArray(n+1)
        var answer = -10000
        for(i in 1 .. n){
            dp[i] = input[i-1].coerceAtLeast(dp[i-1] + input[i-1])
            answer = answer.coerceAtLeast(dp[i])
        }
       write("$answer\n")
    }
    close()
}
