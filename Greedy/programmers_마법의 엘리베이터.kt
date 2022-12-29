//https://school.programmers.co.kr/learn/courses/30/lessons/148653#
class Solution {
    fun solution(storey: Int): Int {
        return solve(storey)
    }
    fun solve(storey: Int): Int{
        var tempStorey = storey
        var cnt = 0
        while(tempStorey>0){
            val ext = tempStorey%10
            tempStorey/=10
            cnt += if(ext==5){
                if(tempStorey%10 >=5) {
                    tempStorey++
                    10-ext
                }
                else {
                    ext
                }
            }else if(ext > 5) {
                tempStorey++
                10 - ext
            }
            else {
                ext
            }
        }
        return cnt
    }
}
