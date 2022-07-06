//https://www.acmicpc.net/problem/4485
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

data class Node(
    val r: Int,
    val c: Int,
    val dis: Int
)
lateinit var graph: Array<List<Int>>
lateinit var dp: Array<IntArray>

val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)

fun dijkstra(n: Int) {

    val pq = PriorityQueue<Node> { a, b ->
        when {
            a.dis < b.dis -> -1
            a.dis == b.dis -> 0
            else -> 1
        }

    }
    pq.add(Node(0, 0, dp[0][0]))

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (cur.dis > dp[cur.r][cur.c]) continue
        for (i in 0 until 4) {
            val nr = cur.r + dir[i][0]
            val nc = cur.c + dir[i][1]
            if (nr !in 0 until n || nc !in 0 until n) continue
            val nDis = cur.dis + graph[nr][nc]
            if (dp[nr][nc] <= nDis) continue
            dp[nr][nc] = nDis
            pq.add(Node(nr, nc, nDis))
        }

    }

}

fun main() = with(System.out.bufferedWriter()) {

    var idx = 1
    while(true) {
        val n = getInt()
        if(n==0) break
        graph = Array(n) { getIntList() }
        dp = Array(n) { IntArray(n) { Int.MAX_VALUE } }
        dp[0][0] = graph[0][0]
        //solve
        dijkstra(n)
        //output
        write("Problem $idx: ${dp[n - 1][n - 1]}\n")
        idx++
    }
    close()
}
