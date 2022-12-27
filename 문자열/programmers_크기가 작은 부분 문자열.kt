//https://school.programmers.co.kr/learn/courses/30/lessons/147355#
class Solution {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0
        for(i in p.length .. t.length){
            if(t.substring(i-p.length,i).toLong() <= p.toLong() ) {
                answer++
            }
        }
        return answer
    }
}
