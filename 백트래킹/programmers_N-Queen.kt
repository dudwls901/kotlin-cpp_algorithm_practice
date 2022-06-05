//https://programmers.co.kr/learn/courses/30/lessons/12952
class Solution {

    var answer = 0
    lateinit var colArr: IntArray

    fun check(row: Int, col: Int, n: Int) : Boolean {
        for(r in 0 until row){
            //세로, 대각 있는지 체크
            if(colArr[r] ==col || Math.abs(colArr[r] - col) == Math.abs(r-row) ) {
                return false
            }
        }
        return true
    }

    //백트래킹 함수 뎁스 한 번에 한 행만 탐색 -> 가로는 체크할 필요 없음
    fun backTracking(row: Int, n: Int){
        if(row==n){
            answer++
            return
        }
        for(i in 0 until n){
            if(check(row,i,n)){
                colArr[row] = i
                backTracking(row+1,n)
                colArr[row] = -1
            }
        }
    }

    fun solution(n: Int): Int {
        colArr = IntArray(n){-1}
        backTracking(0, n)
        return answer
    }
}
