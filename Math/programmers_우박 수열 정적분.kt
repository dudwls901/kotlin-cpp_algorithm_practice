//https://school.programmers.co.kr/learn/courses/30/lessons/134239
class Solution {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        //before vs after 낮은 거
        //max-min * 0.5
        //min
        var cur = k.toDouble()
        val areaList = ArrayList<Double>()
        //우박수열 각 칸마다 넓이 구하기
        while(cur!=1.0){
            val next = move(cur)
            var min = 0.0
            var max = 0.0
            if(next > cur){
                max = next
                min = cur
            }else{
                max = cur
                min = next
            }
            areaList.add((max-min)*0.5 + min)
            cur = next
        }
        
        //정적분 구하기
        val n = areaList.size
        val result = DoubleArray(ranges.size){
            val (s,e) = ranges[it]
            var sum = 0.0
            if(s>n+e){
                -1.0
            }
            else {
                for (i in s until n + e) {
                    sum += areaList[i]
                }
                sum
            }
        }
        return result
    }

    private fun move(cur: Double): Double {
        return if(cur % 2 == 0.0) cur/2
        else cur*3+1
    }
}
