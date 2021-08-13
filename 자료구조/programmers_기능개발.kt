//https://programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*
class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val q : Queue<Int> =LinkedList<Int>()
        for(i in 0 until speeds.size){
            var day = (100-progresses[i])/speeds[i]
            if((100-progresses[i])%speeds[i]==0)
                q.add(day)
            else
                q.add(day+1)
        }
        var cnt=0
        var cur = q.peek()
        while(!q.isEmpty()){
            if(cur<q.peek()){
                cur=q.peek()
                answer.add(cnt)
                cnt=0
            }
            cnt++
            q.poll()
        }
        answer.add(cnt)
        return answer.toIntArray()
    }
}
