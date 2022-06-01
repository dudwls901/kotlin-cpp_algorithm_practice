//https://programmers.co.kr/learn/courses/30/lessons/92345
class Solution {

    val dir = arrayOf(
        arrayOf(0,1),
        arrayOf(1,0),
        arrayOf(0,-1),
        arrayOf(-1,0)
    )

    //누가 이겼는지는 필요 없음
    //하지만 아래 함수만으로도 누가 이겼는지를 알 수 있음
    fun move(board: Array<IntArray>, r1: Int, c1: Int, r2: Int, c2: Int, cnt: Int): Pair<Boolean,Int>{

        //기저사례1
        //이동할 수 있는 칸이 없는 경우 현재 유저가 짐
        var isFinished = true
        for(i in 0 until 4){
            val nr = r1 + dir[i][0]
            val nc = c1 + dir[i][1]
            if(nr !in board.indices || nc !in board[0].indices) continue
            if(board[nr][nc]==0) continue
            isFinished = false
        }
        if(isFinished){
            return Pair(false,0)
        }
        //기저사례2
        //같은 칸을 밟고 있는 경우 현재 유저가 이김
        if(r1 == r2 && c1 == c2){
            return Pair(true,1)
        }

        //현재 있던 칸 0으로 만들고 이동
        board[r1][c1] = 0

        var canWin = false
        var minTurn = Int.MAX_VALUE
        var maxTurn = 0
        for(i in 0 until 4){
            val nr = r1 + dir[i][0]
            val nc = c1 + dir[i][1]
            if(nr !in board.indices || nc !in board[0].indices) continue
            if(board[nr][nc]==0) continue
            val result = move(board, r2, c2, nr, nc,cnt+1)

            //상대방이 이길수 없다는 결과가 나오면 내가 이김
            if(!result.first){
                //내가 이기는 경우에서 가장 적게 움직이는 값 저장
                canWin = true
                minTurn = minTurn.coerceAtMost(result.second)
            }
            else if(!canWin){
                //내가 지는 경우에서 가장 많이 움직이는 값 저장
                maxTurn = maxTurn.coerceAtLeast(result.second)
            }
        }
        board[r1][c1] = 1
        //내가 이긴다면 가장 적은 이동, 내가 진다면 가장 많은 이동을 반환
        //내가 이길 수 있다면 무조건 이기는 선택
        //a부터 시작하므로, 뎁스 0에서 a의 canWin이 true라면 무조건 a가 이기는 선택을 하게됨
        val turn = if(canWin) minTurn else maxTurn
        return Pair(canWin,turn+1)
    }

    fun solution(board: Array<IntArray>, aloc: IntArray, bloc: IntArray): Int {

        return move(board, aloc[0], aloc[1], bloc[0], bloc[1], 0).second
    }
}
