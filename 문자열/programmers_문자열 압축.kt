//https://programmers.co.kr/learn/courses/30/lessons/60057
import kotlin.math.*
class Solution {
    fun solution(s: String): Int {
        var answer = 987654321
        //1부터 s/2중에 s%i==0인 것만
        for( i in 1 .. s.length/2){

            var len=i
            var cur= s.substring(0,i)
            var isSame = 1
            var rest=0
            print(i)
            for(j in i .. s.length-i step i){
                rest = s.length-(j+i)
                if(cur==s.substring(j,j+i)){
                    isSame++
                }
                else{
                    if(isSame>1){
                        len+= isSame.toString().length
                        isSame=1
                    }
                    len+=i
                    cur = s.substring(j,j+i)
                }
            }
            if(isSame>1)
            len+= isSame.toString().length
            
            len+=rest
            answer = min(answer,len)
            println(len)
        }
        if(answer==987654321)
            return 1
        else
            return answer
        
        
    }
}
