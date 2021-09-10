//www.acmicpc.net/problem/11053
import java.util.*
import kotlin.math.*
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    val arr = IntArray(n)
    val dp = IntArray(n)
    val tk = StringTokenizer(br.readLine())
    dp[0]=1
    arr[0] = Integer.parseInt(tk.nextToken())
    var answer=1
    for(i in 1 until n){
        arr[i] = Integer.parseInt(tk.nextToken())
        for(j in i-1 downTo 0){
            if(arr[i]>arr[j]){
                dp[i]= max(dp[i],dp[j]+1)
            }
        }
        if(dp[i]==0){
            dp[i]=1
        }
        answer = max(answer,dp[i])
    }
    write("$answer")
    close()
}
