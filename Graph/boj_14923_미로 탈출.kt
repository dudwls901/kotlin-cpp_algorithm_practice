//https://www.acmicpc.net/problem/14923
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

data class Node(
    val r: Int,
    val c: Int,
    val isBroken: Int = 0,
    val cnt: Int = 0,
)

val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)

fun bfs(n: Int, m: Int, sr: Int, sc: Int, er: Int, ec: Int, graph: Array<List<Int>>) : Int {
    val visited = Array(2){ Array(n) { BooleanArray(m) } }
    val q: Queue<Node> = LinkedList()
    q.add(Node(sr - 1, sc - 1))
    visited[0][sr - 1][sc - 1] = true
    while (q.isNotEmpty()) {
        val cur = q.poll()
        for (i in 0 until 4) {
            val nr = cur.r + dir[i][0]
            val nc = cur.c + dir[i][1]
            if(nr !in 0 until n || nc !in 0 until m) continue
            if (visited[cur.isBroken][nr][nc]) continue
            if (nr == er - 1 && nc == ec - 1) return cur.cnt + 1
            if (graph[nr][nc] == 1) {
                if (cur.isBroken == 1) continue
                q.add(Node(nr, nc, 1, cur.cnt + 1))
                visited[1][nr][nc] = true
            } else {
                q.add(Node(nr, nc, cur.isBroken, cur.cnt + 1))
                visited[cur.isBroken][nr][nc] = true
            }
        }
    }
    return -1
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, m) = getIntList()
    val (sr, sc) = getIntList()
    val (er, ec) = getIntList()
    val graph = Array(n){ getIntList() }
    //solve
    write("${bfs(n, m, sr, sc, er, ec,graph)}")

    close()
}
