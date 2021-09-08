//https://programmers.co.kr/learn/courses/30/lessons/72414
import kotlin.math.*
class Solution {
    
    //주어진 시간 문자열을 초 단위로 변환
    fun parseSec(time : List<String>):Int{
        return Integer.parseInt(time[0])*3600 + Integer.parseInt(time[1])*60 + Integer.parseInt(time[2])
    }
    
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        var answer: String = ""
        val pt = play_time.split(":")
        val at = adv_time.split(":")
        val ptSec = parseSec(pt)
        val atSec = parseSec(at)
        val totalTime = IntArray(ptSec+1)
        
        //동영상 전체 재생 구간의 모든 초마다 시청하고 있는 사람의 수 추가
        //동영상은 시작 시간 이상, 종료 시간 미만
        for(i in logs.indices){
            val (a,b) = logs[i].split("-")
            val st = a.split(":")
            val fi = b.split(":")
            val stSec = parseSec(st)
            val fiSec = parseSec(fi)
            for(j in stSec until fiSec){
                totalTime[j]++
            }
        }
        
        //투포인터로 모든 구간에 대해 가장 많은 재생 시간과 그 때의 영상 시작 시간을 구하기
        var start =0
        var end = atSec
        var maxSum=0L
        var ansInt=0
        for(i in 0 until atSec){
            maxSum+=totalTime[i]
        }
        var maxTime=maxSum
        while(end<=ptSec){
            maxSum = maxSum-totalTime[start]+totalTime[end]
            if(maxTime<maxSum){
                maxTime = maxSum
                ansInt=start+1
            }
            start++
            end++
        }
        
        //투 포인터로 구한 영상 시작 시간을 조건에 맞는 포맷으로 리턴
        var hour = ansInt/3600
        ansInt%=3600
        var minute =ansInt/60
        ansInt%=60
        var second = ansInt
        answer = String.format("%02d:%02d:%02d", hour, minute, second)
        return answer
    }
}
