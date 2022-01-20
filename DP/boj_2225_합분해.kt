//https://www.acmicpc.net/problem/2225
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val dp = Array(k+1){LongArray(n+1){1} }
    for(i in 2 ..k){
        for(j in 1 ..n){
            dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000000
        }
    }
    write("${dp[k][n]}")

    close()
}
