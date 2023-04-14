//https://school.programmers.co.kr/learn/courses/30/lessons/118668
//그래프 문제가 아닌데 그래프처럼 푼 것, dp로도 가능
import java.util.*

class Solution {
    var er = 0
    var ec = 0
    val edge = ArrayList<Edge>()
    lateinit var visited: Array<IntArray>
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        var answer: Int = 0
        edge.add(Edge(0,0,1,0,1))
        edge.add(Edge(0,0,0,1,1))
        for(problem in problems){
            val (r,c,pr,pc,dis) = problem
            //목적지 설정
            er = er.coerceAtLeast(r)
            ec = ec.coerceAtLeast(c)
            edge.add(Edge(r,c,pr,pc,dis))
        }
        visited = Array(151){IntArray(151){Int.MAX_VALUE}}
        //해도 되고 안 해도 됨
        edge.sortBy{it.dis}
        
        return dijkstra(alp,cop)
    }
    
    fun dijkstra(sr: Int, sc: Int) : Int{
        var answer = Int.MAX_VALUE
        val pq = PriorityQueue<Node>(compareBy{it.dis})
        pq.add(Node(sr,sc,0))
        visited[sr][sc] = 0
        while(pq.isNotEmpty()){
            val (cr,cc,cd) = pq.poll()
            if(cr >= er && cc >= ec) return cd
            if(cd > visited[cr][cc]) continue
            for(e in edge){
                if(cr < e.reqR || cc < e.reqC) continue
                val nr = (cr + e.r).coerceAtMost(150)
                val nc = (cc + e.c).coerceAtMost(150)
                val nd = cd + e.dis
                if(visited[nr][nc] <= nd) continue
                visited[nr][nc] = nd
                pq.add(Node(nr,nc,nd))
            }
        }
        
        return answer
    }
}

data class Node(
    val r: Int,
    val c: Int,
    val dis: Int
)

data class Edge(
    val reqR: Int,
    val reqC: Int,
    val r: Int,
    val c: Int,
    val dis: Int
)
