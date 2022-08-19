//https://www.acmicpc.net/problem/14284
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

var n = 0
var m = 0
var s = 0
var t = 0
lateinit var edge: Array<ArrayList<Pair<Int, Int>>>
lateinit var dp: IntArray

fun dijkstra(): Int {
    val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }
    pq.add(Pair(s, 0))
    dp[s] = 0
    while (pq.isNotEmpty()) {
        val (cur, curDis) = pq.poll()
        if (dp[cur] < curDis) continue
        for ((next, nextDis) in edge[cur]) {
            if (dp[next] <= curDis + nextDis) continue
            dp[next] = curDis + nextDis
            pq.add(Pair(next, curDis + nextDis))
        }
    }
    return dp[t]
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    getIntList().also {
        n = it[0]
        m = it[1]
    }
    dp = IntArray(n + 1) { Int.MAX_VALUE }
    edge = Array(n + 1) { ArrayList() }
    repeat(m) {
        val (from, to, dis) = getIntList()
        edge[from].add(Pair(to, dis))
        edge[to].add(Pair(from, dis))
    }
    getIntList().also {
        s = it[0]
        t = it[1]
    }
    //solve, output
    write("${dijkstra()}")
    close()
}
