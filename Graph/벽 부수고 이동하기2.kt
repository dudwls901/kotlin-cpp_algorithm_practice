//https://www.acmicpc.net/problem/14442
import java.util.*

val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

data class Node(
    val r: Int,
    val c: Int,
    val del: Int,
    val dis: Int

)

lateinit var graph: Array<String>
val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)
lateinit var visited: Array<Array<BooleanArray>>

fun bfs(n: Int, m: Int, k: Int): Int {
    var answer = -1

    //edge case
    if(n-1 ==0 && m-1 ==0) return 1
    
    val q: Queue<Node> = LinkedList()

    q.add(Node(0, 0, 0, 1))
    visited[0][0][0] = true

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0 until 4) {
            val nr = cur.r + dir[i][0]
            val nc = cur.c + dir[i][1]
            if (nr !in 0 until n || nc !in 0 until m) continue
            val nDel = if(graph[nr][nc]=='1') cur.del+1 else cur.del
            if(nDel>k) continue

            if(visited[nDel][nr][nc]) continue

            //end point
            if(nr == n-1 && nc == m-1){
                return cur.dis+1
            }

            visited[nDel][nr][nc] = true
            q.add(Node(nr,nc,nDel, cur.dis+1))
        }
    }


    return answer
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n, m, k) = getIntList()
    graph = Array(n) { br.readLine() }
    visited = Array(k+1) { Array(n) { BooleanArray(m) } }

    //solve, output
    write("${bfs(n, m, k)}")

    close()
}
