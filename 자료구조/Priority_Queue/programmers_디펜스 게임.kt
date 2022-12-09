//https://school.programmers.co.kr/learn/courses/30/lessons/142085
import java.util.*
class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        val pq = PriorityQueue<Int> { a, b -> b - a }
        var sum = 0
        var cnt = 0
        var kCnt = 0
        for (ene in enemy) {
            if (sum + ene > n) {
                if (kCnt >= k) break
                if (pq.isEmpty() || ene > pq.peek()) {
                    kCnt++
                } else {
                    while (kCnt < k && pq.isNotEmpty() && sum + ene > n) {
                        sum -= pq.poll()
                        kCnt++
                    }
                    sum += ene
                    pq.add(ene)
                }
            } else {
                sum += ene
                cnt++
                pq.add(ene)
            }
        }
        return cnt + kCnt
    }
}
