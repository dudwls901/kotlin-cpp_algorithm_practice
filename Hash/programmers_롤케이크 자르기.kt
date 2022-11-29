//https://school.programmers.co.kr/learn/courses/30/lessons/132265
class Solution {
    fun solution(topping: IntArray): Int {
        var answer = 0
        val n = 10_000
        val right = mutableMapOf<Int,Int>()
        for(num in topping){
            right[num] = right.getOrDefault(num,0)+1
        }
        val left = mutableSetOf<Int>()
        for(num in topping){
            left.add(num)
            if(right[num] != null && right[num] == 1) right.remove(num)
            else right[num] = right[num]!!-1
            if(left.size == right.size) answer++
        }
        return answer
    }
}
