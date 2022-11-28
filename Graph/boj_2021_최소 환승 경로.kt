//https://www.acmicpc.net/problem/2021
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: IntArray
fun bfs(s: Int, e: Int, n: Int): Int {

    val q: Queue<Int> = LinkedList()
    q.add(s)
    while (q.isNotEmpty()) {
        val cur = q.poll()
        for (next in graph[cur]) {
            if (visited[next] >= 0) continue
            if (next > n) {
                q.add(next)
                visited[next] = visited[cur] + 1
            }
            else if(next == e) return visited[cur]
            else{
                q.add(next)
                visited[next]  = visited[cur]
            }
        }
    }
    return -1
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, l) = getIntList()
    graph = Array(n * 2+1) { ArrayList() }
    visited = IntArray(n * 2+1) { -1 }
    for (i in 1 .. l) {
        getIntList().forEach {
            if(it!=-1) {
                graph[it].add(n + i)
                graph[n + i].add(it)
            }
        }
    }
    val (s, e) = getIntList()
    //solve, output
    write("${bfs(s, e, n)}")
    close()
}
