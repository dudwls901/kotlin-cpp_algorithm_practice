//https://www.acmicpc.net/problem/5972
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

lateinit var edge: Array<ArrayList<Node>>
lateinit var dp: IntArray

data class Node(
    val num: Int,
    val dis: Int
)

fun dijkstra(n: Int): Int {
    val pq = PriorityQueue<Node> { a, b -> a.dis - b.dis }
    pq.add(Node(1, 0))
    dp[1] = 0
    while (pq.isNotEmpty()) {
        val (cn, cd) = pq.poll()
        if (dp[cn] < cd) continue
        if (cn == n) return cd
        for ((nn, nd) in edge[cn]) {
            if (cd + nd >= dp[nn]) continue
            dp[nn] = cd + nd
            pq.add(Node(nn, cd + nd))
        }
    }
    return -1
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n,m) = getIntList()
    edge = Array(n + 1) { ArrayList() }
    dp = IntArray(n + 1) { Int.MAX_VALUE }
    Array(m){ getIntList()}.apply{
        this.forEach {
            val (from, to, dis) = it
            edge[from].add(Node(to, dis))
            edge[to].add(Node(from, dis))
        }
    }
    //solve, output
    write("${dijkstra(n)}")
    close()
}
