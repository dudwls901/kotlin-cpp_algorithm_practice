//https://school.programmers.co.kr/learn/courses/30/lessons/152996
class Solution {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        val weightCnt = LongArray(1001)
        for(i in weights.indices){
            weightCnt[weights[i]]++
        }
        
        for(i in 100 .. 1000){
            val leftCnt = weightCnt[i]
            if(leftCnt==0L) continue
            //각 무게마다 어떤 몸무게랑 짝이 될 수 있는지
            //1:1
            if(leftCnt>=2L){
                answer += leftCnt * (leftCnt-1)/2
            }
            //1:2
            if(i*2 <=1000){
                answer += leftCnt * (weightCnt[i*2])
            }
            //2:3
            var right = i*3/2 
            if((i*3)%2 ==0 && right <= 1000){
                answer += leftCnt * (weightCnt[right])
            }
            //3:4
            right = i*4/3
            if((i*4)%3 == 0 && right <= 1000){
                answer += leftCnt * (weightCnt[right])
            }
        }
        return answer
    }
}
