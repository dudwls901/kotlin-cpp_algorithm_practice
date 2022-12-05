//https://www.acmicpc.net/problem/4991
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

data class Node(
    val r: Int,
    val c: Int,
)

lateinit var graph: Array<String>
lateinit var dests: MutableList<Node>
lateinit var edge: Array<IntArray>
var answer = 0
val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0),
)

fun main() = with(System.out.bufferedWriter()) {
    while (true) {
        //input
        answer = Int.MAX_VALUE
        val (m, n) = getIntList()
        var start = 0
        if (n == 0 && m == 0) break
        dests = mutableListOf()
        graph = Array(n) { r ->
            val line = br.readLine()
            for (c in line.indices) {
                if (line[c] == 'o') {
                    dests.add(Node(r, c))
                    start = dests.size - 1
                } else if (line[c] == '*') {
                    dests.add(Node(r, c))
                }
            }
            line
        }
        //solve
        if(!makeEdge(n, m)){
            write("-1\n")
        }else {
            val visited = BooleanArray(dests.size)
            visited[start] = true
            permutation(1, start, 0, visited)
            //output
            write("$answer\n")
        }
    }
    close()
}

fun permutation(cnt: Int, cur: Int, dis: Int, visited: BooleanArray) {
    if (cnt == dests.size) {
        answer = answer.coerceAtMost(dis)
        return
    }

    for (next in dests.indices) {
        if (visited[next]) continue
        visited[next] = true
        permutation(cnt + 1, next, dis + edge[cur][next], visited)
        visited[next] = false
    }
}

fun makeEdge(n: Int, m: Int): Boolean {
    edge = Array(dests.size) { IntArray(dests.size) }
    for (from in dests.indices) {
        for (to in dests.indices) {
            if (from == to) continue
            edge[from][to] = bfs(from, to, n, m)
            if(edge[from][to] == 0) return false
        }
    }
    return true
}

fun bfs(from: Int, to: Int, n: Int, m: Int): Int {
    val q: Queue<Triple<Int, Int, Int>> = LinkedList()
    val visited = Array(n) { BooleanArray(m) }
    val (r, c) = dests[from]
    q.add(Triple(r, c, 0))
    visited[r][c] = true
    val (er, ec) = dests[to]
    while (q.isNotEmpty()) {
        val (cr, cc, dis) = q.poll()
        for (i in 0 until 4) {
            val nr = cr + dir[i][0]
            val nc = cc + dir[i][1]
            if (nr !in 0 until n || nc !in 0 until m) continue
            if (visited[nr][nc]) continue
            if(graph[nr][nc] == 'x') continue
            if (nr == er && nc == ec) return dis + 1
            q.add(Triple(nr, nc, dis + 1))
            visited[nr][nc] = true
        }
    }
    return 0
}
