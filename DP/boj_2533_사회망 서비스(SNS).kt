//https://www.acmicpc.net/problem/2533
//트리dp
//노드마다 상태는 adopter or not_adopter
//노드가 adopter일 떄 adopter의 수는 1 + sum(dp[childs][adopter] or dp[childs][not_adopter]) (부모가 adopter일 때 자식이 꼭 not_adopter인 것이 최적이라는 보장이 없기 때문)
//노드가 not_adopter일 때 adopter의 수는 sum(dp[childs][adopter])
//최종적으로 임의로 루트 노드라고 가정한 노드의 dp[node][adopter] or dp[node][not_adopter]중 작은 값이 정답
val br = System.`in`.bufferedReader()
fun getIntArray() = br.readLine().trim().split(' ').map { it.toInt() }.toIntArray()
fun getInt() = br.readLine().trim().toInt()
lateinit var edges: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var dp: Array<IntArray> //0 : adopter, 1 : not_adopter
fun dfs(node: Int) {
    visited[node] = true
    dp[node][0] = 1
    for (next in edges[node]) {
        if (visited[next]) continue
        dfs(next)
        dp[node][0] += dp[next][1].coerceAtMost(dp[next][0])
        dp[node][1] += dp[next][0]
    }
}

fun main() = with(System.out.bufferedWriter()) {
    val n = getInt()
    edges = Array(n + 1) { ArrayList() }
    visited = BooleanArray(n + 1)
    dp = Array(n + 1) { IntArray(2) }
    repeat(n - 1) {
        val (x, y) = getIntArray()
        edges[x].add(y)
        edges[y].add(x)
    }
    dfs(1)
    write("${dp[1][0].coerceAtMost(dp[1][1])}")
    close()
}
