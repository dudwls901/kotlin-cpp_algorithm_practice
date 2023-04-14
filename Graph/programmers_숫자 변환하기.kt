//https://school.programmers.co.kr/learn/courses/30/lessons/154538
import java.util.*

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        return bfs(x,y,n)
    }
    fun bfs(s: Int, e: Int, n: Int): Int{
        val q: Queue<Int> = LinkedList()
        q.add(s)
        val visited = BooleanArray(e+1)
        visited[s] = true
        var cnt = 0
        while(q.isNotEmpty()){
            val size = q.size
            for(i in 0 until size){
                val cur = q.poll()
                if(cur == e) return cnt
                var next = cur *2
                if(next <= e && visited[next].not()){
                    visited[next] = true
                    q.add(next)
                }
                next = cur * 3
                if(next <= e && visited[next].not()){
                    visited[next] = true
                    q.add(next)
                }
                next = cur + n
                if(next <= e && visited[next].not()){
                    visited[next] = true
                    q.add(next)
                }
            }
            cnt++
        }
        return -1
    }
}
