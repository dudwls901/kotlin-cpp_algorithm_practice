//https://www.acmicpc.net/problem/1174
import java.util.*

const val MAX = 9876543210

val br = System.`in`.bufferedReader()

fun bfs(n: Int): Long {
    var cnt=0

    val q: Queue<Long> = LinkedList()
    for (i in 0 .. 9) {
        q.add(i.toLong())
        cnt++
        if(cnt==n){
            return i.toLong()
        }
    }

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0 until cur % 10) {
            val next = cur*10+i
            if(next>MAX) continue
            q.add(next)
            cnt++
            if(cnt==n){
                return next
            }
        }
    }
    return -1
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = br.readLine().toInt()

    // solve, output
    write("${bfs(n)}")
    close()
}
