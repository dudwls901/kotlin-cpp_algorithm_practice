//https://www.acmicpc.net/problem/2643
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
lateinit var input: Array<Pair<Int, Int>>
lateinit var dp: IntArray
fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    dp = IntArray(n){1}
    input = Array(n) {
        val tk = StringTokenizer(br.readLine())
        val a = tk.nextToken().toInt()
        val b = tk.nextToken().toInt()
        Pair(a.coerceAtLeast(b),a.coerceAtMost(b))
    }
    input.sortWith(compareBy<Pair<Int, Int>> {it.first}.thenBy { it.second } )
    //solve
    var answer=0
    for(i in 0 until n){
        for(j in 0 until i){
            if(input[i].second >= input[j].second){
                dp[i] = dp[i].coerceAtLeast(dp[j]+1)
            }
        }
        answer = answer.coerceAtLeast(dp[i])
    }
    //output
    write("$answer")

    close()
}
