//https://school.programmers.co.kr/learn/courses/30/lessons/154539
import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val stk = Stack<Pair<Int,Int>>()
        var answer= IntArray(numbers.size){-1}
        stk.push(numbers[0] to 0)
        for(i in 1 until numbers.size){
            val num = numbers[i]
            while(stk.isNotEmpty() && num > stk.peek().first){
                answer[stk.pop().second] = num
            }
            stk.push(num to i)
        }
        return answer
    }
}
