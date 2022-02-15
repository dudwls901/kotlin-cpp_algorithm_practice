//https://www.acmicpc.net/problem/14712
val br = System.`in`.bufferedReader()
val dir = arrayOf(arrayOf(-1, 0), arrayOf(0, -1), arrayOf(-1, -1))
var answer = 0
lateinit var graph: Array<BooleanArray>

//왼,왼위,위가 true가 아닌 경우 블럭 넣을 수 있음
fun canBlock(r: Int,c:Int, n: Int, m: Int): Boolean {

    for (i in 0 until 3) {
        val nr = r + dir[i][0]
        val nc = c + dir[i][1]
        if (nr !in 0 until n || nc !in 0 until m) return true
        if (!graph[nr][nc]) return true
    }
    return false
}

fun backTracking(n: Int, m: Int, i: Int) {

    if (i == n * m) {
        answer++
        return
    }
    var idx = i
    val r = idx / m
    val c = idx % m
    graph[r][c] = true
    //현재 칸에 넴모를 넣을 수 없는 경우는 더 이상 탐색 x
    if (canBlock(r,c, n, m)) {
        backTracking(n, m, idx + 1)
    }
    //현재 칸에 넴모를 안 넣으면 그냥 다음 칸 탐색하면 됨
    graph[r][c] = false
    backTracking(n, m, idx + 1)
}

fun main() = with(System.out.bufferedWriter()) {

    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    graph = Array(n) { BooleanArray(m) }
    backTracking(n, m, 0)

    write("$answer")
    close()
}
