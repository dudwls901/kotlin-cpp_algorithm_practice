//https://school.programmers.co.kr/learn/courses/30/lessons/154540
import java.util.*
class Solution {
    
    val dir = arrayOf(
        arrayOf(0,1),
        arrayOf(1,0),
        arrayOf(0,-1),
        arrayOf(-1,0)
    )
    
    lateinit var visited: Array<BooleanArray>
    fun solution(maps: Array<String>): IntArray {
        val answer = ArrayList<Int>()
        val n = maps.size
        val m = maps[0].length
        visited = Array(n){BooleanArray(m)}
        for(r in 0 until n){
            for(c in 0 until m){
                if(visited[r][c]) continue
                if(maps[r][c] =='X') continue
                answer.add(bfs(r,c,n,m,maps))
            }
        }
        return if(answer.isEmpty()) intArrayOf(-1) else answer.sorted().toIntArray()
    }
    fun bfs(sr: Int, sc: Int, n: Int, m: Int, maps: Array<String>): Int{
        var days = 0
        val q: Queue<Pair<Int,Int>> = LinkedList()
        visited[sr][sc] = true
        q.add(sr to sc)
        while(q.isNotEmpty()){
            val (r,c) = q.poll()
            days += maps[r][c].digitToInt()
            for(i in 0 until 4){
                val nr = r + dir[i][0]
                val nc = c + dir[i][1]
                if(nr !in 0 until n|| nc !in 0 until m) continue
                if(maps[nr][nc] =='X') continue
                if(visited[nr][nc]) continue
                q.add(nr to nc)
                visited[nr][nc] = true
            }
        }
        return days
    }
}
