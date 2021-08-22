//https://www.acmicpc.net/problem/1725
import java.util.*
import kotlin.math.*

fun main()= with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    val stk = Stack<Int>()
    var answer = 0L
    val high = IntArray(n+2){0}
    for(i in 1 .. n){
        high[i]=Integer.parseInt(br.readLine())
    }
    stk.push(0)
    for(i in 1 .. n+1){
        while(stk.isNotEmpty() && high[stk.peek()]>high[i]){
            val hIdx = stk.pop()
            answer = max(answer, (high[hIdx]*(i-stk.peek()-1)).toLong())
        }
        stk.push(i)
    }
    write("$answer")
    close()
}
