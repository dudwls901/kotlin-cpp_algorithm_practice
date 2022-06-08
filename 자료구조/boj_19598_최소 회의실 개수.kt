//https://www.acmicpc.net/problem/19598
import java.util.*

val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {

    //input
    val n = getInt()
    val input = Array(n) { Pair(0, 0) }
    for (i in 0 until n) {
        val (s, e) = getIntList()
        input[i] = Pair(s, e)
    }

    //solve
    input.sortBy{it.first}
    val pq = PriorityQueue<Int> { a, b ->
        when {
            a < b -> -1
            a == b -> 0
            else -> 1
        }
    }
    pq.add(input[0].second)
    for (i in 1 until n) {
        //시작 시간이 현재 종료 시간보다 큰 경우
        if(pq.peek() <= input[i].first){
            pq.poll()
        }
        pq.add(input[i].second)
    }

    write("${pq.size}")

    close()
}
