//https://www.acmicpc.net/problem/22255
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntArray() = br.readLine().trim().split(' ').map { it.toInt() }.toIntArray()
fun getStr() = br.readLine().trim()
fun getInt() = br.readLine().trim().toInt()

/*
* 그래프 이동
* 다익스트라
* -1벽, 0~300 가중치
* %3 == 0 : 상하좌우, %3 == 1 : 상하, %3 == 2 : 좌우
* */

val dir = arrayOf(
    intArrayOf(1, 0),
    intArrayOf(-1, 0),
    intArrayOf(0, -1),
    intArrayOf(0, 1),
)
val Int.dirRange: IntRange
    get() = when (this % 3) {
        0 -> 0..3
        1 -> 0..1
        else -> 2..3
    }
lateinit var graph: Array<IntArray>
lateinit var visited: Array<Array<IntArray>>

data class Node(
    val r: Int,
    val c: Int,
    val cnt: Int,
    val dis: Int
)

fun dijkstra(n: Int, m: Int, sr: Int, sc: Int, er: Int, ec: Int): Int {
    val pq = PriorityQueue<Node>(compareBy { it.dis })
    pq.add(Node(sr, sc, 1, 0))
    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        for (i in cur.cnt.dirRange) {
            val nr = cur.r + dir[i][0]
            val nc = cur.c + dir[i][1]
            if (nr !in 0 until n || nc !in 0 until m) continue
            if (graph[nr][nc] < 0) continue
            if (visited[cur.cnt % 3][nr][nc] <= cur.dis + graph[nr][nc]) continue
            visited[cur.cnt % 3][nr][nc] = cur.dis + graph[nr][nc]
            if (nr == er && nc == ec) return visited[cur.cnt % 3][nr][nc]
            pq.add(Node(nr, nc, cur.cnt + 1, visited[cur.cnt % 3][nr][nc]))
        }
    }
    return -1
}

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = getIntArray()
    val (sr, sc, er, ec) = getIntArray()
    graph = Array(n) { getIntArray() }
    visited = Array(3) { (Array(n) { IntArray(m) { Int.MAX_VALUE } }) }
    write("${dijkstra(n, m, sr - 1, sc - 1, er - 1, ec - 1)}")
    close()
}
