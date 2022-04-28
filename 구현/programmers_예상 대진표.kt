//https://programmers.co.kr/learn/courses/30/lessons/12985
class Solution {

    fun solution(n: Int, aa: Int, bb: Int): Int {

        var a = aa
        var b = bb
        var turn =0
        while(a!=b){
            a = (a+1)/2
            b = (b+1)/2
            turn++
        }

        return turn
    }
}
