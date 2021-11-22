//https://www.acmicpc.net/problem/1208
import kotlin.math.*

val dp = IntArray(1000001)
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()
    for(i in 2 .. 1000){
        dp[i*i]= dp[(i-1)*(i-1)]+(i-1)*(i-1)
    }
    var idx =0
    var plus =2
    for(i in 5 .. 1000000){
        //점의 개수가 x*x꼴이면 스킵
        if(dp[i]!=0){
            plus = sqrt(i.toDouble()).toInt()
            idx=0
            continue
        }
        //점을 우측 대각 아래 찍은 경우, 방향 전환
        if(idx==plus){
            dp[i] = dp[i-1]
            idx=1
        }
        //0부터 plus-1까지 더한다.
        else{
            dp[i] = dp[i-1]+idx
            idx++
        }
    }

    write("${dp[n]}")

    close()
}
