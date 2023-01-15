//https://www.acmicpc.net/problem/18290
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()
lateinit var graph: Array<List<Int>>
var answer = -Int.MAX_VALUE
val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, m, k) = getIntList()
    graph = Array(n) { getIntList() }
    //solve
    backTracking(0, 0, 0, Array(n) { BooleanArray(m) }, n, m, k)
    //output
    write("$answer")
    close()
}

fun backTracking(idx: Int, cnt: Int, sum: Int, visited: Array<BooleanArray>, n: Int, m: Int, k: Int) {
    if (cnt == k) {
        answer = answer.coerceAtLeast(sum)
        return
    }
    if (idx == n * m) return
    val r = idx / m
    val c = idx % m
    if (checkCanMove(r, c, n, m, visited)) {
        visited[r][c] = true
        backTracking(idx + 1, cnt + 1, sum + graph[r][c], visited, n, m, k)
        visited[r][c] = false
    }
    backTracking(idx+1,cnt,sum,visited,n,m,k)
}

fun checkCanMove(r: Int, c: Int, n: Int, m: Int, visited: Array<BooleanArray>): Boolean {
    for (i in 0 until 4) {
        val nr = r + dir[i][0]
        val nc = c + dir[i][1]
        if(nr !in 0 until n) continue
        if(nc !in 0 until m) continue
        if(visited[nr][nc]) return false
    }
    return true
}
