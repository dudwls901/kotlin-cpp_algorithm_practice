//https://www.acmicpc.net/problem/2589
import java.util.*

val br = System.`in`.bufferedReader()
val dir = arrayOf(arrayOf(1, 0), arrayOf(0, 1), arrayOf(-1, 0), arrayOf(0, -1))
lateinit var graph: Array<String>

data class Node(
    val r: Int,
    val c: Int,
    val dis: Int
)

fun bfs(r: Int, c: Int, n: Int, m: Int, visited: Array<BooleanArray>): Int {
    val q: Queue<Node> = LinkedList()
    q.add(Node(r, c, 0))
    visited[r][c] = true
    var answer = 0

    while (q.isNotEmpty()) {
 
        val (cr, cc,dis) = q.poll()
        answer = answer.coerceAtLeast(dis)
        for (j in dir.indices) {
            val nr = cr + dir[j][0]
            val nc = cc + dir[j][1]
            if (nr !in 0 until n || nc !in 0 until m) continue
            if (visited[nr][nc]) continue
            if (graph[nr][nc] == 'W') continue
            q.add(Node(nr, nc,dis+1))
            visited[nr][nc] = true
        }

    }

    return answer
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    graph = Array(n) { br.readLine() }
    var answer = 0

    //solve
    //그래프의 모든 L에서 bfs 시작 최대 50 * 50 * 50
    var lCnt = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 'L') {
                answer = answer.coerceAtLeast(bfs(i, j, n, m, Array(n) { BooleanArray(m) }))
                lCnt++
            }
        }
    }
    //output
    write("$answer")
    close()
}
