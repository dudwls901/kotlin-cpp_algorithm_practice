//https://programmers.co.kr/learn/courses/30/lessons/70129
class Solution {
    fun solution(s: String): IntArray {
        val answer = intArrayOf(0,0)

        var str = s
        while(str!="1"){
            answer[0]++
            str.count{it=='0'}.apply {
                answer[1]+=this
                //1의 길이
                str = Integer.toBinaryString(str.length - this)
            }
        }
        return answer
    }
}
