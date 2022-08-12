//https://www.acmicpc.net/problem/15565
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n,k) = getIntList()
    val tk = StringTokenizer(br.readLine())
    val input = IntArray(n+1){if(it==0) 0 else tk.nextToken().toInt()}
    var answer = Int.MAX_VALUE
    var cnt = 0
    var s = 0
    //solve
    for (e in input.indices) {
        if (input[e] == 1) cnt++
        if (cnt >= k) answer = answer.coerceAtMost(e - s + 1)

        while (cnt >= k && s < e) {
            s++
            answer = answer.coerceAtMost(e - s + 1)
            if(input[s] == 1) cnt--
        }
    }
    //output
    write("${if (answer == Int.MAX_VALUE) -1 else answer}")
    close()
}
