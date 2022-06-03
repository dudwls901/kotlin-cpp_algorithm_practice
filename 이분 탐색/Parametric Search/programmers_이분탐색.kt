//https://programmers.co.kr/learn/courses/30/lessons/43236

class Solution {

    lateinit var diffArr: IntArray

    //sort
    //binarySearch (ParametricSearch)
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        //preset
        var s = 1
        var e = distance
        var answer = 0
        rocks.sort()
        diffArr = IntArray(rocks.size+1)
        diffArr[0] = rocks[0]
        diffArr[rocks.size] = distance-rocks[rocks.size-1]
        for(i in 0 until rocks.size-1){
            diffArr[i+1] = rocks[i+1]-rocks[i]
        }
        //solve
        while(s<=e){
            val mid = (s+e)/2
            var cur=0
            var removed=0

            //mid보다 작은 것들 삭제
            for(i in diffArr.indices){
                cur += diffArr[i]
                if(cur < mid) removed++
                else cur = 0
            }
            if(n<removed){
                e = mid-1
            }
            else{
                answer = mid
                s = mid+1
            }

        }
        return answer
    }
}
