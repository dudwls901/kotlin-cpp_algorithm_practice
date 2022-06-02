//https://programmers.co.kr/learn/courses/30/lessons/92344
class Solution {
    //1 <= n,m <= 1000
    //1 <= 내구도 <=1000
    //1<= skill 개수 <= 250000
    //skill(type,r1,c1,r2,c2,degree)
    //type 1 공격, 2 회복
    //1<= degree <= 500
    lateinit var pSum: Array<IntArray>
    var n = 0
    var m = 0

    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        //preSet
        var answer = 0
        n = board.size
        m = board[0].size
        pSum = Array(n + 1) { IntArray(m + 1) }

        //skill들을 누적합의 약식 형태로 변경
        //1차원이라면  0 ~ 4일 때, deg, 0, 0, 0, 0, -deg
        //2차원이라면 (r1,c1), (r2+1,c2+1) =deg   (r1,c2+1), (r2+1, c1) = -deg
        skill.forEach {
            val type = if (it[0] == 1) -1 else 1
            val r1 = it[1]
            val c1 = it[2]
            val r2 = it[3]
            val c2 = it[4]
            val deg = it[5] * type
            pSum[r1][c1] += deg
            pSum[r2 + 1][c2 + 1] += deg
            pSum[r1][c2 + 1] += -deg
            pSum[r2 + 1][c1] += -deg
        }
        //약식 형태의 누적 합을 누적 합
        //세로 누적 합, 가로 누적 합
        for (t in 0 until 2) {
            for (r in 0 until n) {
                for (c in 0 until m) {
                    if (t == 0) {
                        pSum[r + 1][c] += pSum[r][c]
                    } else {
                        pSum[r][c + 1] += pSum[r][c]
                    }
                }
            }
        }
        //board와 pSum합쳐서 결과 도출
        for(r in 0 until n){
            for(c in 0 until m){
                if(board[r][c] + pSum[r][c] > 0) answer++
            }
        }
        return answer
    }
}
