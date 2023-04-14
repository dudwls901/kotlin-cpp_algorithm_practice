//https://school.programmers.co.kr/learn/courses/30/lessons/150369
import java.util.*
//어떤 집의 배달할 택배가 4개라면 꼭 한 번에 4개를 모두 배송해야 하는 건 아님
class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0L
        val goStack = Stack<Pair<Int,Int>>()
        val backStack = Stack<Pair<Int,Int>>()
        for(i in deliveries.indices){
            if(deliveries[i]!=0)
            goStack.push(deliveries[i] to i+1)
            if(pickups[i]!=0)
            backStack.push(pickups[i] to i+1)
        }
        while(goStack.isNotEmpty() || backStack.isNotEmpty()){
            var curGo = cap
            var curBack = cap
            val goTop = if(goStack.isEmpty()) 0 else goStack.peek().second
            val backTop = if(backStack.isEmpty()) 0 else backStack.peek().second
            answer += goTop.coerceAtLeast(backTop) * 2
            while(goStack.isNotEmpty() && goStack.peek().first <= curGo){
                curGo-=goStack.pop().first
            }
            if(goStack.isNotEmpty() && curGo!=0){
                val (cnt, idx) = goStack.pop()
                goStack.push(cnt-curGo to idx)
            }
            
            while(backStack.isNotEmpty() && backStack.peek().first <= curBack){
                curBack -= backStack.pop().first
            }
            if(backStack.isNotEmpty() && curBack!=0){
                val (cnt, idx) = backStack.pop()
                backStack.push(cnt-curBack to idx)
            }
        }
        return answer
    }
}
