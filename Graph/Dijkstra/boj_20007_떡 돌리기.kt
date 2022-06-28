//https://www.acmicpc.net/problem/20007
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var edge: Array<ArrayList<Pair<Int, Int>>>
lateinit var dp: IntArray

fun dijkstra(start: Int) {
    val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
        when {
            a.second < b.second -> -1
            a.second == b.second -> 0
            else -> 1
        }

    }
    dp[start] = 0
    pq.add(Pair(start, 0))

    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (dp[cur.first] < cur.second) continue
        for (next in edge[cur.first]) {
            var (nextNum, nextDis) = next
            nextDis += cur.second
            if (dp[nextNum] <= nextDis) continue
            dp[nextNum] = nextDis
            pq.add(Pair(nextNum, nextDis))
        }
    }
}

fun findAnswer(n: Int, x: Int): Int {

    if(dp[n-1]*2>x){
        return -1
    }
    var idx = 0
    var sum = 0
    var answer = 0
    while(idx < n){
        while(idx < n && sum + dp[idx]*2 <= x){
            sum += dp[idx++]*2
        }
        sum = 0
        answer++
    }

    return answer
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, m, x, y) = getIntList()
    edge = Array(n) { ArrayList() }
    dp = IntArray(n) { Int.MAX_VALUE }
    repeat(m) {
        val (from, to, dis) = getIntList()
        edge[from].add(Pair(to, dis))
        edge[to].add(Pair(from, dis))
    }

    //solve
    dijkstra(y)
    dp.sort()
    write("${findAnswer(n,x)}")

    close()
}
