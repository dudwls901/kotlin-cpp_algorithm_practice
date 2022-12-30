//https://school.programmers.co.kr/learn/courses/30/lessons/132267
class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer = 0
        var tempN = n
        while(tempN >=a){
            answer += tempN/a*b 
            tempN = tempN/a*b + tempN%a
        }
        return answer
    }
}
