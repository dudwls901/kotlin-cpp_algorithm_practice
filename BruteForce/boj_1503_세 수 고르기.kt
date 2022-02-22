//https://www.acmicpc.net/problem/1503
import java.lang.Math.abs
import java.util.*

val br = System.`in`.bufferedReader()
const val MAX = 1002

fun main() = with(System.out.bufferedWriter()){

    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val out = BooleanArray(MAX)
    if(m!=0) {
        val tk = StringTokenizer(br.readLine())
        while (tk.hasMoreTokens()) {
            out[tk.nextToken().toInt()] = true
        }
    }
    var answer =Int.MAX_VALUE

    for(i in 1 until MAX){
        if(out[i]) continue
        for(j in 1 until MAX){
            if(out[j]) continue
            for(k in 1 until MAX){
                if(out[k]) continue
                answer = answer.coerceAtMost(abs(n-i*j*k))
            }
        }
        if(answer==0) break
    }
    write("$answer")
    close()
}
