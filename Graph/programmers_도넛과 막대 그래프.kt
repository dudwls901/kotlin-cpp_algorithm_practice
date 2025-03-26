//https://school.programmers.co.kr/learn/courses/30/lessons/258711
class Solution {
    fun solution(edges: Array<IntArray>): IntArray {
        val answer = intArrayOf(0, 0, 0, 0)
        val degrees = Array(1_000_001) { intArrayOf(0, 0) }
        edges.forEach {
            val (from, to) = it
            degrees[from][1]++
            degrees[to][0]++
        }
        degrees.forEachIndexed { node, degree ->
            if (degree[0] == 0 && degree[1] >= 2) answer[0] = node //시작
            else if (degree[0] >= 1 && degree[1] == 0) answer[2]++ //막대
            else if (degree[0] >= 2 && degree[1] == 2) answer[3]++  //8자
        }
        answer[1] = degrees[answer[0]][1] - (answer[2] + answer[3])
        return answer
    }
}
