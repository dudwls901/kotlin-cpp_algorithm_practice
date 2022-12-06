//https://www.acmicpc.net/problem/4991
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

lateinit var graph: Array<String>
lateinit var dirty: Array<IntArray>
lateinit var visited: Array<Array<IntArray>>

val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0),
)

data class Node(
    val r: Int,
    val c: Int,
    val state: Int,
)

fun main() = with(System.out.bufferedWriter()) {
    //input
    while (true) {
        val (m, n) = getIntList()
        if (n == 0 && m == 0) break
        var cnt = 0
        var sr = 0
        var sc = 0
        dirty = Array(n){ IntArray(m) }
        graph = Array(n) { r ->
            val line = br.readLine()
            for (c in line.indices) {
                if (line[c] == '*') {
                    dirty[r][c] = cnt++
                } else if (line[c] == 'o') {
                    sr = r
                    sc = c
                }
            }
            line
        }
        visited = Array(1 shl cnt) { Array(n) { IntArray(m) } }
        write("${bfs(sr, sc, n, m)}\n")
    }

    close()
}

fun bfs(sr: Int, sc: Int, n: Int, m: Int): Int {
    val q: Queue<Node> = LinkedList()
    q.add(Node(sr, sc, 0))
    while (q.isNotEmpty()) {
        val (cr, cc, cs) = q.poll()
        for (i in 0 until 4) {
            val nr = cr + dir[i][0]
            val nc = cc + dir[i][1]
            var ns = cs
            if (nr !in 0 until n || nc !in 0 until m) continue
            if (graph[nr][nc] == 'x') continue
            if (graph[nr][nc] == '*') {
                ns = cs or (1 shl dirty[nr][nc])
            }
            if (visited[ns][nr][nc] > 0) continue
            if (ns == visited.size-1){
                return visited[cs][cr][cc] + 1
            }
            visited[ns][nr][nc] = visited[cs][cr][cc] + 1
            q.add(Node(nr, nc,ns))
        }
    }
    return -1
}
