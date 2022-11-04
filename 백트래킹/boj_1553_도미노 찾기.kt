//https://www.acmicpc.net/problem/1553
val br = System.`in`.bufferedReader()
val used = Array(7) { BooleanArray(7) }
lateinit var visited: Array<BooleanArray>
lateinit var graph: Array<IntArray>
var answer = 0
val dir = arrayOf(
    arrayOf(0,1),
    arrayOf(1,0),
)
fun backTracking(idx: Int, cnt: Int) {
    val n = graph.size
    val m = graph[0].size
    if (idx >= n * m) {
        if (cnt == n * m) answer++
        return
    }
    val r = idx / m
    val c = idx % m
    if (visited[r][c]) {
        backTracking(idx + 1, cnt)
        return
    }
    for(i in 0 until 2){
        val nr = r+dir[i][0]
        val nc = c+dir[i][1]
        if (nr in 0 until n  && nc in 0 until m) {
            if (!used[graph[r][c]][graph[nr][nc]] && !visited[nr][nc]) {
                used[graph[r][c]][graph[nr][nc]] = true
                used[graph[nr][nc]][graph[r][c]] = true
                visited[r][c] = true
                visited[nr][nc] = true
                backTracking(idx + 1, cnt + 2)
                used[graph[r][c]][graph[nr][nc]] = false
                used[graph[nr][nc]][graph[r][c]] = false
                visited[r][c] = false
                visited[nr][nc] = false
            }
        }
    }
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    graph = Array(8) {
        val input = br.readLine()
        IntArray(input.length) { Character.getNumericValue(input[it]) }
    }
    visited = Array(8) { BooleanArray(7) }
    //solve
    backTracking(0, 0)
    write("$answer")
    close()
}
