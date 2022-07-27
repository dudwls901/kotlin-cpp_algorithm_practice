//https://www.acmicpc.net/problem/17396
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

var n = 0
var m = 0
lateinit var canLook: IntArray
lateinit var edge: Array<ArrayList<Pair<Int, Long>>>
lateinit var dp: LongArray
fun dijkstra(): Long {

    val pq = PriorityQueue<Pair<Int, Long>> { before, after ->
        when {
            before.second < after.second -> -1
            before.second == after.second -> 0
            else -> 1
        }
    }

    pq.add(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (cur.second > dp[cur.first]) continue
        for (next in edge[cur.first]) {
            if (canLook[next.first] == 1 && next.first != n - 1) continue

            val nextCost = cur.second + next.second
            if (dp[next.first] <= nextCost) continue
            dp[next.first] = nextCost
            pq.add(Pair(next.first, nextCost))
        }
    }

    return dp[n - 1]
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    getIntList().also {
        n = it[0]
        m = it[1]
    }
    canLook = getIntList().toIntArray()
    edge = Array(n) { ArrayList<Pair<Int, Long>>() }
    dp = LongArray(n) { Long.MAX_VALUE }
    repeat(m){
        val (a, b, t) = getIntList()
        edge[a].add(Pair(b, t.toLong()))
        edge[b].add(Pair(a, t.toLong()))
    }
    //solve
    var answer: Long = dijkstra()

    //output
    if (answer == Long.MAX_VALUE) {
        answer = -1L
    }
    write("$answer")
    close()
}
