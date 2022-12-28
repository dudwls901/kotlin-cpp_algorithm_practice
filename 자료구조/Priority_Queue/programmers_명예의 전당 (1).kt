//https://school.programmers.co.kr/learn/courses/30/lessons/138477
import java.util.*
class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer = IntArray(score.size)
        val pq = PriorityQueue<Int>{ a,b -> a-b }
        for(day in score.indices){
            pq.add(score[day])
            if(pq.size>k){
                pq.poll()
            }
            answer[day] = pq.peek()
        }
        return answer
    }
}
