//https://school.programmers.co.kr/learn/courses/30/lessons/159993
import java.util.*
class Solution {
    
    val dir = arrayOf(
        arrayOf(0,1),
        arrayOf(1,0),
        arrayOf(0,-1),
        arrayOf(-1,0)
    )
    
    fun solution(maps: Array<String>): Int {
        var answer: Int = 0
        var sr = 0
        var sc = 0
        var lr = 0
        var lc = 0
        var er = 0
        var ec = 0
        for(r in maps.indices){
            for(c in maps[0].indices){
                if(maps[r][c] == 'S'){
                    sr = r
                    sc = c
                }else if(maps[r][c] =='L'){
                    lr = r
                    lc = c
                }else if(maps[r][c]=='E'){
                    er = r
                    ec = c
                }
            }
        }
        //bfs1 -> l
        //bfs2 -> e
        val ans1 = bfs(sr,sc,lr,lc, maps)
        val ans2 = bfs(lr,lc,er,ec, maps)
        return if(ans1 == -1 || ans2 == -1) -1 else ans1 + ans2 
    }
    
    fun bfs(sr: Int, sc: Int, er: Int, ec: Int, maps: Array<String>): Int{
        val q: Queue<Pair<Int,Int>> = LinkedList()
        q.add(sr to sc)
        val n = maps.size
        val m = maps[0].length
        val visited =Array(n){BooleanArray(m)}
        visited[sr][sc] = true
        var cnt = 0
        while(q.isNotEmpty()){
            val size = q.size
            cnt++
            for(i in 0 until size){
                val (r,c) = q.poll()
                for(j in 0 until 4){
                    val nr = r + dir[j][0]
                    val nc = c + dir[j][1]
                    if(nr !in 0 until n || nc !in 0 until m) continue
                    if(maps[nr][nc] == 'X') continue
                    if(visited[nr][nc]) continue
                    if(nr == er && nc == ec) return cnt
                    visited[nr][nc] = true
                    q.add(nr to nc)
                }
            }
        }
        return -1
    }
}
