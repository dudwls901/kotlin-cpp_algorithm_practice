//https://www.acmicpc.net/problem/9466
val br = System.`in`.bufferedReader()
fun getIntArray() = br.readLine().trim().split(' ').map { it.toInt() }.toIntArray()
fun getInt() = br.readLine().trim().toInt()

lateinit var edges: IntArray
lateinit var done: BooleanArray //done[node]: node가 순회를 마쳤다. 
lateinit var visited: BooleanArray //visited[node] : node에 방문한 적이 있다.
var cnt = 0
fun dfs(
    node: Int,
) {
    visited[node] = true
    val next = edges[node]
    if (visited[next].not()) {
        dfs(next)
    } else if (done[next].not()) {
        //dfs에서 한 번 순회하면 경로에 해당하는 노드들은 모두 무조건 사이클이 있거나 없거나로 정해짐
        //따라서 한 번 순회한 것은 더 이상 볼 필요 없음 
        var recur = next
        while (recur != node) {
            cnt++
            recur = edges[recur]
        }
        cnt++
    }
    done[node] = true
}

fun main() = with(System.out.bufferedWriter()) {
    repeat(getInt()) {
        val n = getInt()
        edges = IntArray(n + 1)
        done = BooleanArray(n + 1)
        visited = BooleanArray(n + 1)
        cnt = 0
        getIntArray().forEachIndexed { from, to ->
            edges[from + 1] = to
        }
        for (node in 1..n) {
            if (visited[node]) continue
            dfs(node)
        }
        write("${n - cnt}\n")
    }
    close()
}
