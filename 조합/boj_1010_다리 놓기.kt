//https://www.acmicpc.net/problem/1010
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var t = br.readLine().toInt()
    val dp = Array(31){LongArray(31)}
    for(i in 1 .. 30){
        dp[i][1]=i.toLong()
        for(j in 2 until i){
            dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
        }
        dp[i][i]=1
    }
    while(t-->0){
        val (r,n) = br.readLine().split(' ').map{it.toInt()}
        write("${dp[n][r]}\n")
    }

    close()
}
