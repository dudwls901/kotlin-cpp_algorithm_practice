//https://www.acmicpc.net/problem/1158
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n,k) = getIntList()
    val q: Queue<Int> = LinkedList()
    for(i in 1 .. n){
        q.add(i)
    }
    write("<")
    while(q.isNotEmpty()){
        var move = 0
        while(q.isNotEmpty() && move < k-1){
            val front = q.poll()
            q.add(front)
            move++
        }
        write("${q.poll()}")
        if(q.isNotEmpty()){
            write(", ")
        }
    }
    write(">")
    close()
}
