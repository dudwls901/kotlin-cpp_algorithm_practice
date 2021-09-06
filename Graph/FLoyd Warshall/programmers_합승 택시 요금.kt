//https://programmers.co.kr/learn/courses/30/lessons/72413
import kotlin.math.*
class Solution {
    val INF = 11111111
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
    
        var answer: Int = INF
        val dp = Array<IntArray>(n+1){IntArray(n+1)}
        for(i in 0 .. n){
            for(j in 0 .. n){
                if(i==j) dp[i][j]=0
                else{
                    dp[i][j]=INF
                }
            }
        }
        for(i in fares.indices){
            dp[fares[i][0]][fares[i][1]]=fares[i][2]
            dp[fares[i][1]][fares[i][0]]=fares[i][2]
        }
        
        for(k in 0 .. n){
            for(i in 0 ..n){
                for(j in 0 ..n){
                    dp[i][j] = min(dp[i][j],dp[i][k]+dp[k][j])
                }
            }
        }
        for(i in 0 .. n){
            answer = min(answer,dp[s][i]+dp[i][a]+dp[i][b])
        }
        
        return answer
    }
}
