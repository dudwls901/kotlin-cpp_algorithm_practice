//https://programmers.co.kr/learn/courses/30/lessons/68646

import kotlin.math.*
class Solution {
    fun solution(a: IntArray): Int {
        var answer: Int = 0
        var leftMin = IntArray(a.size)
        var rightMin = IntArray(a.size)
        leftMin[0] = a[0]
        for(i in 1 until a.size){
            leftMin[i]=min(leftMin[i-1],a[i])
        }
        rightMin[a.size-1]=a[a.size-1]
        for(i in a.size-2 downTo 0){
            rightMin[i]=min(rightMin[i+1],a[i])
        }
        for(i in a.indices){
            if(i==0 || i==a.size-1){
                answer++
                continue
            }
            if(a[i]<leftMin[i-1] || a[i]<rightMin[i+1] ){
                answer++
            }
        }
        return answer
    }
}
