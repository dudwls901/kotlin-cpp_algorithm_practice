//https://www.acmicpc.net/problem/1715
import java.util.*

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    //input
    val n =br.readLine().toInt()
    val pq = PriorityQueue<Int>().apply {
        repeat(n){
            add(br.readLine().toInt())
        }
    }
    //solve
    var answer=0
    while(pq.isNotEmpty()){
        val a = pq.poll()
        if(pq.isNotEmpty()){
            val b = pq.poll()
            answer += a+b
            pq.add(a+b)
        }
    }
    //output
    write("$answer")

    close()
}
