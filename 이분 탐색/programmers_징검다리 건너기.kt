//https://programmers.co.kr/learn/courses/30/lessons/64062
class Solution {
    var e = 0
    var answer = 0

    fun check(mid: Int, stones: IntArray, k: Int): Boolean {
        val temp = IntArray(stones.size) {
            stones[it] - mid
        }
        var idx = -1
        for (i in temp.indices) {
            if (temp[i] > 0) {
                    if (i - idx > k) return false
                idx = i
            }
        }
        if(idx<0) return false
        if(temp.size-idx>k) return false
        return true
    }

    fun solution(stones: IntArray, k: Int): Int {
        e = stones.maxOrNull()!!

        var s = 1

        while(s<e){
            val mid = (s+e)/2
            if(check(mid,stones,k)){
                answer = mid
                s = mid+1
            }
            else{
                e = mid
            }
        }
        return answer+1
    }
}
