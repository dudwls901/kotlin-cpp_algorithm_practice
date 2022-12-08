//https://school.programmers.co.kr/learn/courses/30/lessons/131704
import java.util.*
class Solution {
    fun solution(order: IntArray): Int {
        var cnt = 0
        val stk = Stack<Int>()
        for (item in 1 .. order.size) {
            if (item == order[cnt]) {
                cnt++
            } else {
                cnt = popInSecondBelt(stk,order, cnt)
                stk.push(item)
            }
        }
        cnt = popInSecondBelt(stk,order, cnt)

        return cnt
    }

    private fun popInSecondBelt(stk: Stack<Int>,order: IntArray, cnt: Int): Int {
        var tempCnt = cnt
        while (stk.isNotEmpty() && tempCnt < order.size &&order[tempCnt] == stk.peek()) {
            stk.pop()
            tempCnt++
        }
        return tempCnt
    }
}
