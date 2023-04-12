//https://school.programmers.co.kr/learn/courses/30/lessons/169199
import java.util.*
class Solution {
    
    val dir = arrayOf(
        arrayOf(0,1),
        arrayOf(1,0),
        arrayOf(0,-1),
        arrayOf(-1,0)
    )
    
    fun solution(board: Array<String>): Int {
        var answer: Int = 0
        var sr = 0
        var sc = 0
        label@for(r in board.indices){
            for(c in board[r].indices){
                if(board[r][c] == 'R'){
                    sr = r
                    sc = c
                    break@label
                }
            }
        }
        return bfs(sr,sc,board)
    }
    
    fun bfs(sr: Int, sc: Int,board: Array<String>): Int{
        val n = board.size
        val m = board[0].length
        val q: Queue<Pair<Int,Int>> = LinkedList()
        q.add(sr to sc)
        val visited = Array(n){BooleanArray(m)}
        visited[sr][sc] = true
        var cnt = 0
        while(q.isNotEmpty()){
            cnt++
            for(t in 0 until q.size){
                val (cr,cc) = q.poll()
                for(i in 0 until 4){
                    var nr = cr + dir[i][0]
                    var nc = cc + dir[i][1]
                    while(true){
                        if(nr !in 0 until n || nc !in 0 until m || board[nr][nc] == 'D'){
                            nr -=dir[i][0]
                            nc -=dir[i][1]
                            break
                        }
                        nr += dir[i][0]
                        nc += dir[i][1]
                    }
                    if(visited[nr][nc]) continue
                    if(board[nr][nc] == 'G') return cnt
                    q.add(nr to nc)
                    visited[nr][nc] = true
                }
            }
        }
        return -1
    }
}
