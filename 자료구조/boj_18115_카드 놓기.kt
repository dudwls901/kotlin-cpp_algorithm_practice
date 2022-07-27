//https://www.acmicpc.net/problem/18115
import java.util.*

val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {

    val n = getInt()
    val input = getIntList()

    val dq = ArrayDeque<Int>()
    var num = 1
    for(i in input.size-1 downTo 0){
        val order = input[i]
        when(order){
            1 ->{
                dq.addLast(num++)
            }
            2 ->{
                val temp = dq.pollLast()
                dq.addLast(num++)
                temp?.let{
                    dq.addLast(it)
                }
            }
            else ->{
                dq.addFirst(num++)
            }
        }
    }
    write("${dq.reversed().joinToString(" ")}")
    close()
}
