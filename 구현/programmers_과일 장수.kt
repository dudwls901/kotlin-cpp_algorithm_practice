//https://school.programmers.co.kr/learn/courses/30/lessons/135808
class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        score.sort()
        var answer = 0
        for(i in score.size-1 downTo 0 step m){
            if(i - m+1 < 0) break
            answer += score[i-m+1]*m
        }
        return answer
    }
}
