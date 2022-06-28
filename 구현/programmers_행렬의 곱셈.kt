//https://programmers.co.kr/learn/courses/30/lessons/12949
class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size){IntArray(arr2[0].size)}
        for(r1 in arr1.indices){
            for(c2 in arr2[0].indices){
                var result=0
                for(r2 in arr2.indices){
                    result += arr1[r1][r2]*arr2[r2][c2]
                }
                answer[r1][c2] = result
            }
        }
        return answer
    }
}
