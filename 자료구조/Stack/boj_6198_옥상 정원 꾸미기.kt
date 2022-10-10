//https://www.acmicpc.net/problem/6198
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){
    //input
    val stk = Stack<Int>()
    var answer = 0L
    repeat(getInt()){ _ ->
        with(getInt()){
            while(stk.isNotEmpty() && stk.peek() <= this){
                stk.pop()
            }
            answer += stk.size
            stk.push(this)
        }
    }

    write("$answer")

    close()
}
