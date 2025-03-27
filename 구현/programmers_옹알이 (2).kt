//https://school.programmers.co.kr/learn/courses/30/lessons/133499
class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer = 0
        val can = setOf("aya", "ye", "woo", "ma")
        for (sentence in babbling) {
            var before = ""
            var cur = ""
            for (i in sentence.indices) {
                val ch = sentence[i]
                cur += ch
                if (can.contains(cur)) {
                    if (cur == before) break
                    if (i == sentence.length - 1) answer++
                    before = cur
                    cur = ""
                }
            }
        }
        return answer
    }
}
