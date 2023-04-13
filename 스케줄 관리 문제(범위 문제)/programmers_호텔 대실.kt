//https://school.programmers.co.kr/learn/courses/30/lessons/155651
//prefixSum O(N)
class Solution {
    val prefixSum = IntArray(24*60+11)
    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = 0
        for(bt in book_time){
            for(i in bt[0].toMinute()+1 .. bt[1].toMinute()+10){
                prefixSum[i]++
                answer = answer.coerceAtLeast(prefixSum[i])
            }
        }
        return answer
    }

    fun String.toMinute(): Int{
        val (h,m) = this.split(":").map{it.toInt()}
        return h*60 + m
    }
}
//pq O(N*NlogN) pq : 삽입,삭제 logN(힙 정렬 유지해야 함) N개 삽입해서 NlogN
import java.util.*
class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var answer = 0
        //시작 시간으로 정렬
        val bookTimes = book_time.map{
            Time(
                it[0].toMinute(),
                it[1].toMinute()+10
            )
        }.sortedBy{it.s}
        //pq는 종료 시간으로 정렬
        val pq = PriorityQueue<Int>()
        //pq의 top은 현재 생성된 방 중 가장 빨리 끝나는 방을 의미
        for(time in bookTimes){
            //가장 빨리 끝나는 방들을 다 빼버리고 새로운 방으로 갱신
            while(pq.isNotEmpty() && pq.peek() <= time.s) pq.poll()
            pq.add(time.e)
            answer = answer.coerceAtLeast(pq.size)
        }
        return answer
    }
    fun String.toMinute(): Int{
        val (h,m) = this.split(":").map{it.toInt()}
        return h*60 + m
    }
}
data class Time(
    val s: Int,
    val e: Int
)
