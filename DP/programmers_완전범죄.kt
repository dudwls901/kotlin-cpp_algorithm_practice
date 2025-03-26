//https://school.programmers.co.kr/learn/courses/30/lessons/389480
class Solution {
    fun solution(info: Array<IntArray>, n: Int, m: Int): Int {
        //dp[i][x][y] i개까지 훔쳤을 때 a의 누적 흔적이 x, b의 누적 흔적이 y일 때 가능한지
        val dp = Array(info.size+1){
            Array(n){
                BooleanArray(m){false}
            }
        }
        dp[0][0][0] = true
        for(i in info.indices){
            for(a in 0 until n){
                for(b in 0 until m){
                    if(dp[i][a][b].not()) continue
                    val nA = a + info[i][0]
                    val nB = b + info[i][1]
                    if(nA < n) dp[i+1][nA][b] = true
                    if(nB < m) dp[i+1][a][nB] = true
                }
            }
        }

        dp[info.size].forEachIndexed { idx, arr ->
            if(arr.contains(true)) return idx
        }
        return -1
    }
}
