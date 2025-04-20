//https://www.acmicpc.net/problem/2533
val br = System.`in`.bufferedReader()
fun getIntArray() = br.readLine().trim().split(' ').map { it.toInt() }.toIntArray()
fun getInt() = br.readLine().trim().toInt()
lateinit var edges: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
var answer = 0

/*
* 리프노드는 무조건 not_adopter
* 부모는 자식중에 not_adopter가 하나라도 있으면 +1
* 약간 그리디한 풀이
* */
fun dfs(node: Int): Int {
    visited[node] = true
    var notAdopterChildCnt = 0
    for (next in edges[node]) {
        if (visited[next]) continue
        notAdopterChildCnt += dfs(next)
    }
    if (notAdopterChildCnt > 0) {
        answer++
        return 0
    }
    return 1
}

fun main() = with(System.out.bufferedWriter()) {
    val n = getInt()
    edges = Array(n + 1) { ArrayList() }
    visited = BooleanArray(n + 1)
    repeat(n - 1) {
        val (x, y) = getIntArray()
        edges[x].add(y)
        edges[y].add(x)
    }
    dfs(1)
    write("$answer")
    close()
}
