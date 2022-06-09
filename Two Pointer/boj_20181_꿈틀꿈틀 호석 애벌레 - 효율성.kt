//https://www.acmicpc.net/problem/20181
import java.util.*
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var graph: List<Long>
lateinit var dp: LongArray

fun main() = with(System.out.bufferedWriter()){
    //input
    val (n, k) = getIntList()
    val tk = StringTokenizer(br.readLine())
    graph = List(n+1){
        if(it==0)
            0
        else
            tk.nextToken().toLong()
    }

    dp =  LongArray(n+1)

    //solve
    //twoPointer
    var s = 0

    var sum = 0L
    for(e in 1 .. n){
        sum += graph[e]
        dp[e] = dp[e].coerceAtLeast(dp[e-1])
        while(sum >= k){
            dp[e] = dp[e].coerceAtLeast(dp[s] + sum-k)
            sum -= graph[++s]
        }
    }
    //output
    write("${dp[n]}")

    close()
}
