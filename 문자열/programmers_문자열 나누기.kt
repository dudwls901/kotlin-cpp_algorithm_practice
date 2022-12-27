//https://school.programmers.co.kr/learn/courses/30/lessons/140108
class Solution {
    fun solution(s: String): Int {
        var x = ' '
        var answer = 0 
        var xCnt = 0
        var otherCnt = 0
        for(i in s.indices){   
            if(x ==' '){
                x = s[i]
                xCnt++
            }else{
                if(s[i] ==x){
                    xCnt++
                }else{
                    otherCnt++
                }
            }
            if(xCnt == otherCnt){
                answer++
                x = ' '
                xCnt = 0
                otherCnt = 0
            }
        }
        return if(xCnt > 0) answer+1 else answer
    }
}
