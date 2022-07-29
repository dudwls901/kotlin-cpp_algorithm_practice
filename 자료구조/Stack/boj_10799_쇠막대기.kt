//https://www.acmicpc.net/problem/10799
import java.util.*
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val input = br.readLine()
    var answer = 0
    var base = 0
    var idx = 0
    val stk = Stack<Char>()
    while (idx < input.length) {
        val ch = input[idx]
        when (ch) {
            '(' -> {
                if (idx + 1 < input.length && input[idx + 1] == ')') {
                    answer += stk.size
                    idx++
                } else {
                    stk.add(ch)
                    base++
                }
            }
            else -> {
                if(stk.isNotEmpty()) {
                    stk.pop()
                }
            }
        }
        idx++
    }
    write("${answer + base}")
    close()
}
