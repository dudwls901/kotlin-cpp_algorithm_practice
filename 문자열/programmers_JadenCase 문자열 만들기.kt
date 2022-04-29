//https://programmers.co.kr/learn/courses/30/lessons/12951
class Solution {
    fun solution(s: String): String {
        val answer = s.split(' ').map{
            if(it.isNotEmpty()) {
                var chArr = it.lowercase().toCharArray()
                if (chArr[0].isLetter()) chArr[0] = chArr[0].uppercaseChar()
                String(chArr)
            }
            else{
                it
            }
        }.joinToString(" ")

        return answer
    }
}
