//https://www.acmicpc.net/problem/1504
//다익스트라로 다시 풀기
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

data class Node(
    val num: Int,
    val dis: Long,
    val visited: HashSet<Int>
)

lateinit var edge: Array<ArrayList<Pair<Int, Int>>>
lateinit var dp: Array<LongArray>
fun dijkstra(n: Int, essential1: Int, essential2: Int) {

    val q: Queue<Node> = LinkedList()
    val startHashSet = HashSet<Int>()
    if (essential1 == 1) {
        startHashSet.add(essential1)
    }
    if (essential2 == 1) {
        startHashSet.add(essential2)
    }
    val visitState =
        if (startHashSet.contains(essential1)) 1 else if (startHashSet.contains(essential2)) 2 else 0
    q.add(Node(1, 0, startHashSet))
    dp[visitState][1] = 0
    while (q.isNotEmpty()) {
        val cur = q.poll()
        var cVisitState =
            if (cur.visited.contains(essential1)) 1 else if (cur.visited.contains(essential2)) 2 else 0
        cVisitState = if(cur.visited.contains(essential1) && cur.visited.contains(essential2)) 3 else cVisitState
        if (dp[cVisitState][cur.num] < cur.dis) continue
        for (next in edge[cur.num]) {
            val nNum = next.first
            val nDis = cur.dis + next.second
            val nVisited = HashSet<Int>().apply {
                addAll(cur.visited)
                if (nNum == essential1) add(nNum)
                if (nNum == essential2) add(nNum)
            }
            var nVisitState =
                if (nVisited.contains(essential1)) 1 else if (nVisited.contains(essential2)) 2 else 0
                nVisitState = if(nVisited.contains(essential1) && nVisited.contains(essential2)) 3 else nVisitState
                if (dp[nVisitState][nNum] <= nDis) continue
            dp[nVisitState][nNum] = nDis
            q.add(Node(nNum, nDis, nVisited))
        }
    }
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, e) = getIntList()
    edge = Array(n + 1) { ArrayList() }
    dp = Array(4) { LongArray(n + 1) { Long.MAX_VALUE } }
    repeat(e) {
        val (node1, node2, dis) = getIntList()
        edge[node1].add(Pair(node2, dis))
        edge[node2].add(Pair(node1, dis))
    }
    //solve,output
    val (essential1, essential2) = getIntList()
    dijkstra(n, essential1, essential2)
    //output
    write("${if (dp[3][n] == Long.MAX_VALUE) -1 else dp[3][n]}")
    close()
}
