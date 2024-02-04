//https://www.acmicpc.net/problem/1303
//bfs
import java.util.LinkedList
import java.util.Queue

val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getStr() = br.readLine().trim()

lateinit var graph: Array<CharArray>
lateinit var visited: Array<BooleanArray>

val dir = arrayOf(
    intArrayOf(0, 1),
    intArrayOf(1, 0),
    intArrayOf(0, -1),
    intArrayOf(-1, 0),
)

fun bfs(ch: Char, sr: Int, sc: Int, n: Int, m: Int): Int {
    var sum = 1
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(sr to sc)
    visited[sr][sc] = true

    while (q.isNotEmpty()) {
        val (r, c) = q.poll()
        for (i in 0 until 4) {
            val nr = r + dir[i][0]
            val nc = c + dir[i][1]
            if (nr !in 0 until n || nc !in 0 until m) continue
            if (visited[nr][nc]) continue
            if (graph[nr][nc] != ch) continue
            q.add(nr to nc)
            visited[nr][nc] = true
            sum++
        }
    }

    return sum * sum
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (m, n) = getIntList()
    var w = 0
    var b = 0
    graph = Array(n) { CharArray(m) }
    visited = Array(n) { BooleanArray(m) }
    repeat(n) { r ->
        val line = getStr()
        repeat(m) { c ->
            graph[r][c] = line[c]
        }
    }
    //solve
    for (r in 0 until n) {
        for (c in 0 until m) {
            if (visited[r][c]) continue
            val res = bfs(graph[r][c], r, c, n, m)
            if (graph[r][c] == 'W') {
                w += res
            } else {
                b += res
            }
        }
    }
    //output
    write("$w $b")
    close()
}
