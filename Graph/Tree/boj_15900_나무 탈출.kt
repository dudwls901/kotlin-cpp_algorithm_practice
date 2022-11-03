//https://www.acmicpc.net/problem/15900
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

lateinit var edge: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
var total = 0

fun dfs(cur: Int, dis: Int) {
    visited[cur] = true
    var isLeaf = true
    for (next in edge[cur]) {
        if (visited[next]) continue
        dfs(next, dis+1 )
        isLeaf = false
    }
    if(isLeaf) total+=dis
}

fun main() = with(System.out.bufferedWriter()) {

    val n = getInt()
    edge = Array(n + 1) { ArrayList() }
    visited = BooleanArray(n + 1)
    repeat(n - 1) {
        val (from, to) = getIntList()
        edge[from].add(to)
        edge[to].add(from)
    }

    dfs(1,0)
    write(if (total % 2 == 0) "No" else "Yes")
    close()
}
