//https://programmers.co.kr/learn/courses/30/lessons/92341
import java.util.*

class Solution {
    var pTime = 0
    var pCost = 0
    var aTime = 0
    var aCost = 0

    val inMap = mutableMapOf<String, Int>()
    val resultTime = TreeMap<String, Int>()

    fun calCost(t: Int): Int{
        var cost = pCost
        var time = t
        time -= pTime
        //기본 시간 이상이라현 더 청구
        if(time>0){
            var overTime = if(time%aTime==0) time/aTime else time/aTime+1
            cost += overTime*aCost
        }
        return cost
    }

    fun solution(fees: IntArray, records: Array<String>): IntArray {

        //preset
        pTime = fees[0]
        pCost = fees[1]
        aTime = fees[2]
        aCost = fees[3]


        for (record in records) {
            val (tt, car, action) = record.split(' ')
            var t = 0
            tt.split(':').map { it.toInt() }.apply {
                t += this[0]*60 + this[1]
            }

            if(action=="IN"){
                inMap[car]=t
            }
            else{
                resultTime[car]= resultTime.getOrDefault(car,0)+t-inMap[car]!!
                inMap.remove(car)
            }

        }
        inMap.forEach { car, t ->
            resultTime[car]= resultTime.getOrDefault(car,0)+(23*60 + 59)-t
        }
        var answer = IntArray(resultTime.size)
        var idx=0

        resultTime.forEach { s, i ->
            answer[idx++] = calCost(i)
        }

        return answer
    }
}
