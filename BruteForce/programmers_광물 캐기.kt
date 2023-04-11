//https://school.programmers.co.kr/learn/courses/30/lessons/172927
class Solution {
    var answer: Int = Int.MAX_VALUE
    lateinit var cnts: Array<IntArray>
    
    fun String.parseIdx() = when(this){
        "diamond" -> 0
        "iron" -> 1
        else -> 2
    }
    
    fun Int.pickMinerals(cnt: IntArray): Int = when(this){
        0 ->{
            cnt[0] + cnt[1] + cnt[2]
        }
        1 ->{
            cnt[0]*5 + cnt[1] + cnt[2]
        }
        else ->{
            cnt[0]*25 + cnt[1]*5 + cnt[2]
        }
    }
    
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        //prepare
        //5개 단위로 광물 각각 몇 개씩인지 저장
        cnts = Array(    
            if(minerals.size%5 == 0) minerals.size/5 else minerals.size/5 + 1
        ){
            val line = intArrayOf(0,0,0)
            for(i in it*5 until it*5 + 5){
                if(i >= minerals.size) break
                line[minerals[i].parseIdx()] +=1
            }
            line
        }
        //solve
        //매번 다이아,철,돌 모든 곡괭이 선택해서 써보기
        bruteForce(picks,0,0)
        
        return answer
    }
    
    fun bruteForce(picks: IntArray, cntIdx: Int, result: Int){
        //end
        if(cntIdx == cnts.size || picks.count{it==0}  == 3){
            answer = answer.coerceAtMost(result)
            return
        }
        for(i in 0 until 3){
            if(picks[i] == 0) continue
            picks[i] -= 1
            bruteForce(picks, cntIdx+1, result + i.pickMinerals(cnts[cntIdx]))
            picks[i] +=1
        }
    }
}
