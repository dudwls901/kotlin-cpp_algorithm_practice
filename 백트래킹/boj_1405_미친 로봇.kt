//https://www.acmicpc.net/problem/1405
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }

val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(0, -1),
    arrayOf(1, 0),
    arrayOf(-1, 0)
)
var result = 0.0
var t = 0
var E = 0
var W = 0
var S = 0
var N = 0
fun main() = with(System.out.bufferedWriter()) {
    //input
    with(getIntList()) {
        t = get(0)
        E = get(1)
        W = get(2)
        S = get(3)
        N = get(4)
    }
    val visited = Array(100) { BooleanArray(100) }
    //solve
    dfs(0, 1.0, 50, 50, visited, t)
    //output
    write("$result")
    close()
}

fun Int.dirPer(): Double {
    return when (this) {
        0 -> E / 100.0
        1 -> W / 100.0
        2 -> S / 100.0
        else -> N / 100.0
    }
}

fun dfs(cnt: Int, per: Double, r: Int, c: Int, visited: Array<BooleanArray>, t: Int) {
    if (cnt == t) {
        result += per
        return
    }
    visited[r][c] = true
    for (i in 0 until 4) {
        val nr = r + dir[i][0]
        val nc = c + dir[i][1]
        if (visited[nr][nc]) continue
        dfs(cnt + 1, per * i.dirPer(), nr, nc, visited, t)
    }
    visited[r][c] = false
}
