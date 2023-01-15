//https://www.acmicpc.net/problem/2194
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()
lateinit var graph: Array<IntArray>
val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)

data class Node(
    val r: Int,
    val c: Int,
    val cnt: Int,
)

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, m, a, b, k) = getIntList()
    graph = Array(n) { IntArray(m) }
    repeat(k) {
        val (r, c) = getIntList()
        graph[r - 1][c - 1] = 2
    }
    val (sr, sc) = getIntList()
    val (er, ec) = getIntList()
    write("${bfs(n, m, a, b, sr - 1, sc - 1, er - 1, ec - 1)}")
    close()
}

fun bfs(n: Int, m: Int, a: Int, b: Int, sr: Int, sc: Int, er: Int, ec: Int): Int {
    val q: Queue<Node> = LinkedList()
    q.add(Node(sr, sc, 0))
    graph[sr][sc] = 1
    while (q.isNotEmpty()) {
        val (cr, cc, cCnt) = q.poll()
        for (i in 0 until 4) {
            val nr = cr + dir[i][0]
            val nc = cc + dir[i][1]
            val nCnt = cCnt + 1
            if (nr !in 0 until n || nc !in 0 until m) continue
            if (graph[nr][nc] != 0) continue
            if (!checkCanMove(nr, nc, a, b, n, m)) continue
            if (nr == er && nc == ec) return nCnt
            q.add(Node(nr, nc, nCnt))
            graph[nr][nc] = 1
        }
    }
    return -1
}

fun checkCanMove(sr: Int, sc: Int, a: Int, b: Int, n: Int, m: Int): Boolean {
    for (r in sr until sr + a) {
        if (r !in 0 until n) return false
        for (c in sc until sc + b) {
            if (c !in 0 until m) return false
            if (graph[r][c] == 2) return false
        }
    }
    return true
}
