//https://www.acmicpc.net/problem/14248
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
lateinit var graph: IntArray
var answer = 0
fun dfs(cur: Int) {
    var jump = graph[cur]
    graph[cur] = 0
    answer++

    val left = cur - jump
    val right = cur + jump
    if (left in graph.indices && graph[left] > 0) {
        dfs(left)
    }
    if (right in graph.indices && graph[right] > 0) {
        dfs(right)
    }
}

fun main() = System.out.bufferedWriter().run {
    //input
    var tk = StringTokenizer(br.readLine())
    val n = tk.nextToken().toInt()
    tk = StringTokenizer(br.readLine())
    graph = IntArray(n){tk.nextToken().toInt()}
    tk = StringTokenizer(br.readLine())
    val s = tk.nextToken().toInt()
    //solve
    dfs(s - 1)
    //output
    write("$answer")
    close()
}
