//https://school.programmers.co.kr/learn/courses/30/lessons/181187
import kotlin.math.*
class Solution {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0
        
        //2사분면만 더하고 나중에 곱하기 4 ()
        for(r in 1 .. r2){
            //r2,r1이 대각, r은 높이
            //r == 1, 2, 3일 때 점의 수
            val upper = floor(sqrt(r2*r2.toDouble() - r*r.toDouble())).toLong()
            val lower = ceil(sqrt(r1*r1.toDouble() - r*r.toDouble())).toLong()
            // println("r: $r upper : $upper lower : ${lower}")
            // println("${upper-lower +1}")
            answer += upper - lower + 1
        }
        return 4 * answer
    }
}
