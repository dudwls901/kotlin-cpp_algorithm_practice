//https://school.programmers.co.kr/learn/courses/30/lessons/131705
class Solution {
    fun solution(number: IntArray): Int {
        var answer =0 
        for(a in number.indices){
            for(b in a + 1 until number.size){
                for(c in b + 1 until number.size){
                    if(number[a]+number[b]+number[c] == 0) answer++
                }
            }
        }
        return answer
    }
}
