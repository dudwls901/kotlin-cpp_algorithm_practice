https://school.programmers.co.kr/learn/courses/30/lessons/389478
class Solution {
    fun solution(n: Int, w: Int, num: Int): Int {
        var answer: Int = 0
        var element = 1
        val graph = Array(100) { r ->
            IntArray(w) {
                if (element <= n) element++ else 0
            }.apply {
                if (r % 2 != 0) reverse()
            }
        }
        var dr = -1
        var dc = -1
        for (r in graph.indices) {
            for (c in graph[0].indices) {
                if (graph[r][c] == num) {
                    dr = r
                    dc = c
                }
                if (c == dc && graph[r][c] != 0) answer++
            }
        }

        return answer
    }
}
