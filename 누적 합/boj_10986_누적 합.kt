//https://www.acmicpc.net/problem/10986
import java.util.*

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val tk = StringTokenizer(br.readLine())
    val preSum = LongArray(n+1)
    var idx=1
    val cnt = LongArray(m)

    while(tk.hasMoreTokens()){
        preSum[idx] = tk.nextToken().toLong()
        preSum[idx] = (preSum[idx]+preSum[idx-1])%m
        cnt[preSum[idx++].toInt()]++
    }
    var answer = cnt[0]

    for(i in 0 until m){
        answer += cnt[i] * (cnt[i]-1) /2
    }
    write("$answer")
    close()
}
