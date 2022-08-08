//https://www.acmicpc.net/problem/2812
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, k) = getIntList()
    val input = br.readLine()
    val stk = Stack<Int>()
    var idx = 0
    var cnt = 0
    var sb = StringBuilder()
    for (i in input.indices) {
        val num = Character.getNumericValue(input.get(i))
        if (stk.isEmpty()) {
            stk.add(num)
        } else {
            while (cnt < k && stk.isNotEmpty() && stk.peek() < num) {
                stk.pop()
                cnt++
            }
            stk.add(num)
        }
    }
    //남은 작은 수 제거
    while(cnt < k && stk.isNotEmpty()){
        stk.pop()
        cnt++
    }
    for (num in stk) {
        sb.append(num.toString())
    }
    write("${sb}")
    close()
}
