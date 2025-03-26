//https://school.programmers.co.kr/learn/courses/30/lessons/340212

class Solution {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
        var start = 1
        var end = 0
        for (diff in diffs) {
            end = end.coerceAtLeast(diff)
        }
        var answer = Int.MAX_VALUE
        while (start <= end) {
            val mid = (start + end) / 2
            if (valid(mid, diffs, times, limit)) {
                end = mid -1
                answer = answer.coerceAtMost(mid)
            } else {
                start = mid + 1
            }
        }
        return answer
    }

    fun valid(mid: Int, diffs: IntArray, times: IntArray, limit: Long): Boolean {
        var sum = times[0].toLong()
        for (i in 1 until diffs.size) {
            if (mid < diffs[i]) {
                sum += (diffs[i].toLong() - mid) * (times[i - 1].toLong() + times[i])
            }
            sum += times[i]
            if (sum > limit) return false
        }
        return true
    }
}
