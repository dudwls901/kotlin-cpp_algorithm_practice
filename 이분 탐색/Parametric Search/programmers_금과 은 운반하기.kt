//https://programmers.co.kr/learn/courses/30/lessons/86053
import kotlin.math.*
class Solution {
    
    fun check(mid : Long, a : Int, b : Int, g : IntArray, s : IntArray, w : IntArray, t : IntArray ):Boolean{
        
        var tot=0L
        var gCarry=0L
        var sCarry=0L
        for(i in w.indices){
            //전체 시간을 한 번 왕복하는 시간으로 나누면 운반 가능 횟수
            var cnt : Long = mid / (t[i]*2)
            //편도로 한 번 더 갈 수 있는 경우 1추가
            if(mid%(t[i]*2)>=t[i]) cnt++
            //금+은 한 번에 이동 가능한 최대 운반량은 트럭 한 번 운반 무게 * 운반 횟수 vs 금 + 은 최대량
            val maxCarry : Long = min(cnt*w[i], (g[i]+s[i]).toLong())    
            //금 운반 최대량은 각 도시의 (금 최대량 vs 최대 운반량) 누적
            gCarry += min(g[i].toLong(),maxCarry)
            //은 운반 최대량은 각 도시의 (은 최대량 vs 최대 운반량) 누적
            sCarry += min(s[i].toLong(),maxCarry)
            //금+은 최대 운반량
            tot+=maxCarry
        }
        
        if(tot>=(a+b).toLong() && gCarry>=a && sCarry>=b){
            //println("${tot} $gCarry $sCarry")
            return true
        }
        return false
        
    }
    
    fun solution(a: Int, b: Int, g: IntArray, s: IntArray, w: IntArray, t: IntArray): Long {
        
        //시간 기준으로 이분 탐색
        //mid(시간)안에 운반 가능한지
        
        var start = 1L
        var end = 400000000000000L
        while(start<end){
            val mid : Long = (start+end)/2
            if(check(mid,a,b,g,s,w,t)){
                end=mid 
            }
            else{
                start=mid+1
            }
        }
        return end
    }
}
