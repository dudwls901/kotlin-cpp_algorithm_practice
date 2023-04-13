//https://school.programmers.co.kr/learn/courses/30/lessons/181188
class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 0
        targets.sortBy{it[1]}
        var destination = -1
        //exclusive
        for(target in targets){
            println(target.joinToString(" "))
            val (s,e) = target
            if(destination < s){
                destination = e-1
                answer++
            }
        }
        return answer
    }
}
