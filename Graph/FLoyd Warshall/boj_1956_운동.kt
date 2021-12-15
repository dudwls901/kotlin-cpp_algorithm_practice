//https://www.acmicpc.net/problem/1956
import kotlin.math.*
val INF = 987654321
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (v,e) = br.readLine().split(' ').map{it.toInt()}
    val dp = Array(v+1){IntArray(v+1){INF} }
    for(i in 0 until e){
        val (from, to, dis) = br.readLine().split(' ').map{it.toInt()}
        dp[from][to] = dis
    }

    for(k in 1 .. v){
        for(i in 1 .. v){
            for(j in 1 .. v){
                dp[i][j] = min(dp[i][j],dp[i][k]+dp[k][j])
            }
        }
    }
    var answer = INF
    for(i in 1 ..v){
        answer = min(dp[i][i],answer)
    }
    if(answer==INF) answer= -1
    write("${answer}")
    close()
}
