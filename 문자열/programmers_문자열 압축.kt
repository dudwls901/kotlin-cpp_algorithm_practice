//https://programmers.co.kr/learn/courses/30/lessons/60057
//+ 2022-05-27
/*
class Solution {
    fun solution(s: String): Int {
        var answer = s.length

        //solve
        for (len in 1..s.length / 2) {
            var result = 0
            //기준 문자열
            //계속 바뀜
            var cur = ""
            var pressCount = 0
            var rest = 0
            for (i in  0 .. s.length-len step len) {
                val next = s.substring(i, i + len)
                rest = s.length-len-i
                //같으면 다음
                if (cur == next) {
                    pressCount++
                }
                //다르면 길이 더하기
                else {
                    result += len
                    //압축 가능하면 추가로 +
                    if (pressCount > 1) {
                        result += pressCount.toString().length

                    }
                    //기준 문자열 갱신
                    cur = s.substring(i, i + len)
                    //압축 가능 상태 초기화
                    pressCount = 1
                }
            }
            //남은 문자열이 압축 가능한 상태면+

            if (pressCount > 1)
                result += pressCount.toString().length
            //result + 남은 문자열 길이로 비교
            answer = answer.coerceAtMost(result + rest)
        }

        return answer
    }
}
*/ 
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
