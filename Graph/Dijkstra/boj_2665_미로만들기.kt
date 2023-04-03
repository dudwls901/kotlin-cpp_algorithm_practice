//https://www.acmicpc.net/problem/2665
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getStr() = br.readLine().trim()
fun getInt() = br.readLine().trim().toInt()

data class Node(
    val cnt: Int,
    val r: Int,
    val c: Int
)

val dir = arrayOf(
    arrayOf(0,1),
    arrayOf(1,0),
    arrayOf(0,-1),
    arrayOf(-1,0)
)

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    val graph = Array(n){ getStr() }
    //solve
    //output
    write("${bfs(n,graph)}")
    close()
}
fun bfs(n: Int, graph: Array<String>): Int{
    val pq =  PriorityQueue<Node>{ a, b ->
        a.cnt - b.cnt
    }
    pq.add(Node(0,0,0))
    val visited = Array(n){IntArray(n){Int.MAX_VALUE}}
    visited[0][0] = 0
    while(pq.isNotEmpty()){
        val (cnt, cr, cc) = pq.poll()
        if(cnt > visited[cr][cc]) continue
        for(i in 0 until 4){
            val nr = cr + dir[i][0]
            val nc = cc + dir[i][1]
            if(nr !in 0 until n || nc !in 0 until n) continue
            val nCnt = if(graph[nr][nc] =='0') cnt+1 else cnt
            if(visited[nr][nc] <= nCnt) continue
            visited[nr][nc] = nCnt
            pq.add(Node(nCnt,nr,nc))
        }
    }
    return visited[n-1][n-1]
}
