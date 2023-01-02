//https://school.programmers.co.kr/learn/courses/30/lessons/131128
class Solution {
    fun solution(X: String, Y: String): String {
        val sb = StringBuilder()
        val counts = IntArray(10)
        val xCounts = IntArray(10)
        val yCounts = IntArray(10)
        for(i in 0 until X.length.coerceAtLeast(Y.length)){
            val xIdx = X.length-1-i
            val yIdx = Y.length-1-i
            if(xIdx >= 0) xCounts[X[xIdx]-'0']++
            if(yIdx >= 0) yCounts[Y[yIdx]-'0']++
        }
        for(i in 9 downTo 1){
            repeat(xCounts[i].coerceAtMost(yCounts[i])){
                sb.append(i)
            }
        }
        val zeroCount = xCounts[0].coerceAtMost(yCounts[0]) 
        if(sb.length == 0){
            if(zeroCount > 0) sb.append(0)
        }else{
            repeat(zeroCount){
                sb.append(0)
            }
        }
       
        return  if(sb.length == 0) "-1" else sb.toString()
    }
}
