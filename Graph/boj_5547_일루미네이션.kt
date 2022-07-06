//https://www.acmicpc.net/problem/5547
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

var answer = 0
lateinit var graph: Array<IntArray>
val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(0, -1),
    arrayOf(1, 0),
    arrayOf(-1, 0),
    //행이 홀수일 때
    arrayOf(-1, 1),
    arrayOf(1, 1),
    //행이 짝수일 때
    arrayOf(-1, -1),
    arrayOf(1, -1)
)

fun bfs(): Int {
    var sum = 0
    val q: Queue<Pair<Int,Int>> = LinkedList()
    q.add(Pair(0,0))
    while(q.isNotEmpty()) {
        val cur = q.poll()
        for (i in 0 until 8) {
            val nr = cur.first + dir[i][0]
            val nc = cur.second + dir[i][1]
            if (cur.first % 2 != 0 && i >= 6) continue
            if (cur.first % 2 == 0 && i in 4..5) continue
            if (nr !in graph.indices || nc !in graph[0].indices) continue
            if (graph[nr][nc] == 1) {
                sum++
            } else if (graph[nr][nc] == 0) {
                graph[nr][nc] = -1
                q.add(Pair(nr, nc))
            }
        }
    }
    return sum
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (w, h) = getIntList()
    graph = Array(h+2) {IntArray(w+2)}
    for(r in 1 .. h){
        val input = getIntList()
        for(c in 1 .. w){
            graph[r][c] = input[c-1]
        }
    }

    //건물 외벽 훑기
    write("${bfs()}")

    close()
}
