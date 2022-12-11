//https://school.programmers.co.kr/learn/courses/30/lessons/140107
class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer = 0L
        for(a in 0 .. d.toLong() step k.toLong()){
            val bb = d.toLong()*d - a * a
            var b = Math.sqrt(bb.toDouble()).toLong()/k.toLong()+1
            answer += b
        }
        return answer
    }
}
