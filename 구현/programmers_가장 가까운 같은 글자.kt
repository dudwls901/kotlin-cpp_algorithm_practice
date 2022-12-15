//https://school.programmers.co.kr/learn/courses/30/lessons/142086
class Solution {
    fun solution(s: String): IntArray {
        val charPositions = IntArray(26){-1}
        return IntArray(s.length){
            val ret = if(charPositions[s[it]-'a'] == -1) -1 else it-charPositions[s[it]-'a']
            charPositions[s[it]-'a'] = it
            ret
        }
    }
}
