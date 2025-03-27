//https://school.programmers.co.kr/learn/courses/30/lessons/148652
class Solution {

    fun check(num: Long): Boolean {
        if (num % 5 == 2L) return false
        if (num < 5L) return true
        return check(num / 5)
    }

    fun solution(n: Int, l: Long, r: Long): Int {
        return (l - 1..r - 1)
            .filter { check(it) }
            .size
    }
}
