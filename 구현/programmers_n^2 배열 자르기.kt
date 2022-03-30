//https://programmers.co.kr/learn/courses/30/lessons/87390
class Solution {
    
    
    fun solution(n: Int, left: Long, right: Long): IntArray {
         
        var answer = IntArray((right-left).toInt()+1)
        
        var idx = left
        
        for(i in answer.indices){
            val r = (idx/n.toLong()).toInt()
            val c = (idx%n.toLong()).toInt()
            answer[i] = r.coerceAtLeast(c) +1
            idx++
        }
        
        return answer
    }
}
