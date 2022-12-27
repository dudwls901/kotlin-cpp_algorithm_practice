//https://school.programmers.co.kr/learn/courses/30/lessons/147354
class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        var answer: Int = 0
        data.sortWith(
            compareBy<IntArray>{
                it[col-1]
            }
            .thenByDescending{
                it[0]
            }
        )
        var sum = -1
        for(r in row_begin-1 .. row_end-1){
            val line = data[r].sumOf{it%(r+1)}
            if(sum == -1){
                sum = line
            }else{
                sum = sum xor line
            }
        }
        return sum
    }
}
