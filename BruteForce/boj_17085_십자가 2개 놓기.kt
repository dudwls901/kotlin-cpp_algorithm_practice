//https://www.acmicpc.net/problem/17085
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)
var answer = 0
lateinit var graph: List<CharArray>

fun getTwoCrossArea(len1: Int, len2: Int) = (1 + len1 * 4) * (1 + len2 * 4)

//바꿔주기
fun handleCross(r: Int, c: Int, len: Int) {
    graph[r][c] = if (graph[r][c] == '#') '*' else '#'
    for (i in 0 until 4) {
        var nr = r
        var nc = c
        for (l in 0 until len) {
            nr += dir[i][0]
            nc += dir[i][1]
            graph[nr][nc] = if (graph[nr][nc] == '#') '*' else '#'
        }
    }
}

//네 방향 검사하여 최소 길이 구하기
fun getCrossLength(r: Int, c: Int): Int {
    var minLength = Int.MAX_VALUE
    for (i in 0 until 4) {
        var nr = r + dir[i][0]
        var nc = c + dir[i][1]
        var len = 0
        while (nr in graph.indices && nc in graph[0].indices && graph[nr][nc] == '#') {
            nr += dir[i][0]
            nc += dir[i][1]
            len++
        }
        if (len == 0) return 0
        minLength = minLength.coerceAtMost(len)
    }
    return minLength
}

fun solve(n: Int, m: Int, idx: Int, cnt: Int, pprevLen: Int, prevLen: Int) {
    if (cnt == 2) {
        answer = answer.coerceAtLeast(getTwoCrossArea(pprevLen, prevLen))
        return
    }
    if (idx >= n * m) return
    val r = idx / m
    val c = idx % m
    if (graph[r][c] == '#') {
        val minLen = getCrossLength(r, c)
        for (i in 0..minLen) {
            handleCross(r, c, i)
            solve(n, m, idx + 1, cnt + 1, prevLen, i)
            handleCross(r, c, i)
        }
    }
    solve(n, m, idx + 1, cnt, pprevLen, prevLen)
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, m) = getIntList()
    graph = List(n) { br.readLine().toCharArray() }
    //solve
    solve(n, m, 0, 0, 0, 0)
    //output
    write("$answer")
    close()
}
