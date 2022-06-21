//https://programmers.co.kr/learn/courses/30/lessons/84512
class Solution {

    val charArr = charArrayOf('A','E','I','O','U')
    val resultSet = ArrayList<String>()
    fun permutation(len: Int, end: Int, result: StringBuilder){
        if(result.isNotEmpty()) {
            resultSet.add(result.toString())
        }
        if(len==end) return
        for(i in 0 until 5){
            result.append(charArr[i])
            permutation(len+1, end, result)
            result.deleteCharAt(result.lastIndex)
        }
    }

    fun solution(word: String): Int {
        permutation(0,5,StringBuilder())
        return resultSet.indexOf(word)+1
    }
}
