//https://school.programmers.co.kr/learn/courses/30/lessons/154538
const val INF = 987654321
class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        var answer: Int = 0
        val dp = IntArray(y+1){INF}
        dp[x] = 0
        for(i in x .. y){
            if(i-n >= 0)
            dp[i] = dp[i].coerceAtMost(dp[i-n]+1)
            if(i%2 == 0)
            dp[i] = dp[i].coerceAtMost(dp[i/2]+1)
            if(i%3 == 0)
            dp[i] = dp[i].coerceAtMost(dp[i/3]+1)
        }
        return if(dp[y] == INF) -1 else dp[y]
    }
}
