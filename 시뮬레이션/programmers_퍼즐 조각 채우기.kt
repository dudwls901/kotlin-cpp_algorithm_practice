//https://programmers.co.kr/learn/courses/30/lessons/84021
import java.util.*
/*
1. 퍼즐 셋 생성, 보드 셋 생성
2. 퍼즐 회전 구현
3. 구멍 셋을 기준으로 퍼즐 셋을 맞춰보는 백트래킹
*/
class Solution {
    var n = 0
    var m = 0
    var answer = 0
    lateinit var usedPuzzle: BooleanArray
    val puzzleList = ArrayList<Array<IntArray>>()
    val spaceList = ArrayList<Array<IntArray>>()
    val dir = arrayOf(
        arrayOf(-1, 0),//상
        arrayOf(0, 1),//우
        arrayOf(1, 0),//하
        arrayOf(0, -1)//좌
    )

	// space랑 puzzle 딱 들어맞는지 확인, 퍼즐 맞춘 칸 개수 반환
    fun canMatchBoard(space: Array<IntArray>, idx: Int): Int {
        val puzzle = puzzleList[idx]
        if (space.size != puzzle.size || space[0].size != puzzle[0].size) return 0

        var matchCnt = 0
        for (r in space.indices) {
            for (c in space[r].indices) {
                if (space[r][c] == puzzle[r][c]) {
                    return 0
                }
                if (space[r][c] == 0) matchCnt++
            }
        }
        return matchCnt
    }

    //3. 보드에 퍼즐 맞추기(백트래킹)
    fun backTracking(idx: Int, sum: Int) {
        answer = answer.coerceAtLeast(sum)
        if (idx == spaceList.size) {
            return
        }
        //모든 퍼즐
        for (i in puzzleList.indices) {
            if (usedPuzzle[i]) continue
            //회전
            for (j in 0 until 4) {
                //퍼즐 대보기
                val matchCnt = canMatchBoard(spaceList[idx], i)
                //안 맞으면 돌리기
                if (matchCnt == 0) {
                    puzzleList[i] = rotate(i)
                }
                //맞으면 다음 탐색, 회전 스탑
                else {
                    usedPuzzle[i] = true
                    backTracking(idx + 1, sum + matchCnt)

                    break
                }
            }
        }
        //아무것도 안 맞으면 다음
        backTracking(idx+1, sum)
    }

    //2. 퍼즐 회전
    fun rotate(idx: Int): Array<IntArray> {
        val N = puzzleList[idx][0].size
        val M = puzzleList[idx].size
        val temp = Array(N) { IntArray(M) }

        for (r in 0 until N) {
            for (c in 0 until M) {
                temp[r][c] = puzzleList[idx][M - c - 1][r]
            }
        }
        return temp
    }

    //1.퍼즐 셋 생성, 보드 셋 생성
    //핏하게 저장
    fun makePiece(
        table: Array<IntArray>,
        r: Int,
        c: Int,
        visited: Array<BooleanArray>,
        state: String
    ): Array<IntArray> {
        val rc = ArrayList<Pair<Int, Int>>()
        var minR = r
        var maxR = r
        var minC = c
        var maxC = c
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(Pair(r, c))
        rc.add(Pair(r, c))
        visited[r][c] = true
        while (q.isNotEmpty()) {
            val (cr, cc) = q.poll()
            for (i in 0 until 4) {
                val nr = cr + dir[i][0]
                val nc = cc + dir[i][1]
                if (nr !in 0 until n || nc !in 0 until m) continue
                when (state) {
                    "board" -> {
                        if (table[nr][nc] == 1 || visited[nr][nc]) continue
                    }
                    else -> {
                        if (table[nr][nc] == 0 || visited[nr][nc]) continue
                    }
                }
                q.add(Pair(nr, nc))
                visited[nr][nc] = true
                rc.add(Pair(nr, nc))
                minR = minR.coerceAtMost(nr)
                maxR = maxR.coerceAtLeast(nr)
                minC = minC.coerceAtMost(nc)
                maxC = maxC.coerceAtLeast(nc)
            }
        }
        val piece = when (state) {
            "board" -> {
                Array(maxR - minR + 1) { IntArray(maxC - minC + 1) { 1 } }
            }
            else -> {
                Array(maxR - minR + 1) { IntArray(maxC - minC + 1) }
            }
        }
        for ((rr, cc) in rc) {
            piece[rr - minR][cc - minC] = when (state) {
                "board" -> {
                    0
                }
                else -> {
                    1
                }
            }
        }
        return piece
    }

    fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
        //preset
        n = game_board.size
        m = game_board[0].size

        //make Puzzle set
        var visited = Array(n) { BooleanArray(m) }
        for (r in 0 until n) {
            for (c in 0 until m) {
                if (visited[r][c] || table[r][c] == 0) continue
                puzzleList.add(makePiece(table, r, c, visited, "puzzle"))
            }
        }
        usedPuzzle = BooleanArray(puzzleList.size)
        //make space set
        visited = Array(n) { BooleanArray(m) }
        for (r in 0 until n) {
            for (c in 0 until m) {
                if (visited[r][c] || game_board[r][c] == 1) continue
                spaceList.add(makePiece(game_board, r, c, visited, "board"))
            }
        }
        //solve
        backTracking(0, 0)
        //output
        return answer
    }
}
