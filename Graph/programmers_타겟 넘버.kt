//https://programmers.co.kr/learn/courses/30/lessons/43165

class Solution {
    var answer = 0
    
    fun dfs(idx : Int, forTarget :Int, numbers : IntArray,target : Int){
        if(idx==numbers.size){
           if(forTarget ==target)
            answer++
            return
        }
        val nextTarget1 = forTarget+numbers[idx]
        val nextTarget2 = forTarget-numbers[idx]
        dfs(idx+1,nextTarget1,numbers,target)
        dfs(idx+1,nextTarget2,numbers,target)
    }
    fun solution(numbers: IntArray, target: Int): Int {
        dfs(0,0,numbers,target)
        return answer
    }
}
