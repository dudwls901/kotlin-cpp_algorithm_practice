//https://www.acmicpc.net/problem/1931
import java.util.*
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    //input
    val n = br.readLine().toInt()
    //end시간 기준 오름차순, 같으면 start시간 기준 오름차순
    val pq = PriorityQueue<Pair<Int,Int>>{a,b -> when{
        a.second < b.second -> -1
        a.second == b.second -> {
            when{
                a.first < b.first -> -1
                else -> 1
            }
        }
        else -> 1
    }}

    repeat(n){
        val (from, to) = br.readLine().split(' ').map{it.toInt()}
        pq.add(Pair(from,to))
    }

    var cur=0
    var answer=0
    while(pq.isNotEmpty()){
        val (start,end) = pq.poll()
        if(start<cur)continue
        answer++
        cur=end
    }
    write("$answer")

    close()
}
