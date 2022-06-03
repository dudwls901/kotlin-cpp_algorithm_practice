//https://www.acmicpc.net/problem/18818
import java.util.*
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()


data class Node(
    val r: Int,
    val c: Int,
    val dir: Int,
    val cnt: Int
)

lateinit var graph: Array<String>
lateinit var visited: Array<Array<IntArray>>
val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)

fun bfs(n: Int): Int {
    var answer = Int.MAX_VALUE
    val q: Queue<Node> = LinkedList()
    q.add(Node(0, 0, -1, 0))

    //방향이 바뀐 수 카운트
    while (q.isNotEmpty()) {
        val cur = q.poll()
        for (i in 0 until 4) {
            val nr = cur.r + dir[i][0]
            val nc = cur.c + dir[i][1]
            if (nr !in 0 until n || nc !in 0 until n) continue
            if (graph[nr][nc] == '#') continue
            val nCnt = if (cur.dir != i) cur.cnt + 1 else cur.cnt
            if(nr == n-1 && nc == n-1){
                answer = answer.coerceAtMost(nCnt)
                continue
            }
            if (visited[i][nr][nc] <=nCnt) continue
            q.add(Node(nr, nc, i, nCnt))
            visited[i][nr][nc] = nCnt
        }
    }
    return answer
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val n = getInt()
    graph = Array(n) { br.readLine() }
    visited = Array(4) { Array(n) { IntArray(n){Int.MAX_VALUE} } }

    //solve,output
    write("${bfs(n)}")
    close()
}
