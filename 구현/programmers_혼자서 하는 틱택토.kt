//https://school.programmers.co.kr/learn/courses/30/lessons/160585
class Solution {
    fun solution(board: Array<String>): Int {
        var o = 0
        var x = 0
        for(r in board.indices){
            for(c in board.indices){
                if(board[r][c] == 'O') o++ else if(board[r][c]=='X') x++   
            }
        }
        //x를 더 두었는지
        if(o < x) return 0
        val oCanBingo = canBingo('O',board)
        val xCanBingo = canBingo('X',board)
        //둘 다 빙고인 경우
        if(oCanBingo && xCanBingo) return 0
        //o빙고인데 o-x가 1이 아닌 경우
        if(oCanBingo && o - x != 1) return 0
        //x빙고인데 x-0이 0이 아닌 경우
        if(xCanBingo && x != o) return 0
        //그냥 o-x가 0..1이 아닌 경우
        if(o-x !in 0..1) return 0
        return 1
    }
    
    fun canBingo(ch: Char, board: Array<String>): Boolean{
        var horizonBingoCnt = 0
        var verticalBingoCnt = 0
        for(r in 0 until 3){
            var horizonCnt = 0
            var verticalCnt = 0
            for(c in 0 until 3){
                if(board[r][c] == ch) horizonCnt++
                if(board[c][r] == ch) verticalCnt++
            }
            
            if(horizonCnt == 3) horizonBingoCnt++
            if(verticalCnt == 3) verticalBingoCnt++
        }
        //더블 빙고도 겹치면 가능
        if(horizonBingoCnt == 1 && horizonBingoCnt == verticalBingoCnt) return true
        if(horizonBingoCnt >1 || verticalBingoCnt > 1) return false
        if(horizonBingoCnt == 1 && verticalBingoCnt == 0) return true
        if(verticalBingoCnt == 1 && horizonBingoCnt == 0) return true
        if(ch == board[0][0] && ch == board[1][1] && ch == board[2][2]) return true
        if(ch == board[0][2] && ch == board[1][1] && ch == board[2][0]) return true
        return false
    }
}
