//https://www.acmicpc.net/problem/17140
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()


//개수 오름차순
//수 오름차순

var er = 0
var ec = 0
var k = 0

fun getRCSize(graph: Array<IntArray>): Pair<Int, Int> {
    var rSize = 0
    var cSize = 0
    for (r in 0 until 100) {
        for (c in 0 until 100) {
            if (graph[r][c] != 0) {
                rSize = rSize.coerceAtLeast(r + 1)
                cSize = cSize.coerceAtLeast(c + 1)
            }
        }
    }
    return Pair(rSize, cSize)
}

data class Node(
    val num: Int,
    val cnt: Int
)

fun sortR(graph: Array<IntArray>, size: Int): Array<IntArray> {
    val newGraph = Array(100) { IntArray(100) }
    for (r in 0 until size) {
        val map = mutableMapOf<Int, Int>()
        for (c in 0 until size) {
            if(graph[r][c]==0) continue
            map[graph[r][c]] = map.getOrDefault(graph[r][c], 0) + 1
        }
        val afterList = ArrayList<Node>()
        map.forEach { num, cnt ->
            afterList.add(Node(num, cnt))
        }
        afterList.sortWith(compareBy<Node> { it.cnt }.thenBy { it.num })
        var idx = 0
        for (c in afterList.indices) {
            if (idx < 100) {
                newGraph[r][idx++] = afterList[c].num
            }
            if (idx < 100) {
                newGraph[r][idx++] = afterList[c].cnt
            }
        }
    }
    return newGraph
}

fun sortC(graph: Array<IntArray>, size: Int): Array<IntArray> {
    val newGraph = Array(100) { IntArray(100) }
    for (c in 0 until size) {
        val map = mutableMapOf<Int, Int>()
        for (r in 0 until size) {
            if(graph[r][c]==0) continue
            map[graph[r][c]] = map.getOrDefault(graph[r][c], 0) + 1
        }
        val afterList = ArrayList<Node>()
        map.forEach { num, cnt ->
            afterList.add(Node(num, cnt))
        }
        afterList.sortWith(compareBy<Node> { it.cnt }.thenBy { it.num })
        var idx = 0
        for (r in afterList.indices) {
            if (idx < 100) {
                newGraph[idx++][c] = afterList[r].num
            }
            if (idx < 100) {
                newGraph[idx++][c] = afterList[r].cnt
            }
        }
    }
    return newGraph
}

fun bfs(graph: Array<IntArray>): Int {
    val q: Queue<Array<IntArray>> = LinkedList()
    q.add(graph)
    var cnt = 0
    while (q.isNotEmpty()) {
        val cur = q.poll()
        val (rSize, cSize) = getRCSize(cur)
        cnt++
        if (cnt > 100) break
        if (rSize >= cSize) {
            val next = sortR(cur, rSize)
            if (next[er - 1][ec - 1] == k) return cnt
            q.add(next)
        } else {
            val next = sortC(cur, cSize)
            if (next[er - 1][ec - 1] == k) return cnt
            q.add(next)
        }
    }
    return -1
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    getIntList().apply {
        er = this[0]
        ec = this[1]
        k = this[2]
    }
    val input = Array(3){ getIntList()}
    //pre
    val graph = Array(100) { IntArray(100) }
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            graph[i][j] = input[i][j]
        }
    }
    //solve
    if (graph[er - 1][ec - 1] == k) {
        write("0")
        close()
        return
    }
    write("${bfs(graph)}")
    close()
}
