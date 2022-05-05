//https://programmers.co.kr/learn/courses/30/lessons/12914
//피보나치
class Solution {

    fun solution(n: Int): Long {
        var dp = LongArray(n+1)
        dp[0]=1
        dp[1]=1
        if(n<2) return dp[n]
        for(i in 2 ..n){
            dp[i] = (dp[i-1]+dp[i-2])%123_456_7
        }

        return dp[n]
    }
}
