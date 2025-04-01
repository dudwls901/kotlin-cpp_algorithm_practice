//https://www.acmicpc.net/problem/10431
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntArray() = br.readLine().trim().split(' ').map { it.toInt() }.toIntArray()
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()) {
    repeat(getInt()) {
        val stk = Stack<Int>()
        val tempStk = Stack<Int>()
        var popCnt = 0
        getIntArray().forEachIndexed { idx, num ->
            if (idx == 0) write("$num ")
            else {
                while (stk.isNotEmpty() && stk.peek() > num) {
                    tempStk.push(stk.pop())
                    popCnt++
                }
                stk.push(num)
                while (tempStk.isNotEmpty()) {
                    stk.push(tempStk.pop())
                }
            }
        }
        write("${popCnt}\n")
    }
    close()
}
