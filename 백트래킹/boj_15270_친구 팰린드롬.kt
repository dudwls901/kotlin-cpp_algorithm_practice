//https://www.acmicpc.net/problem/15270
val br = System.`in`.bufferedReader()

var answer=0
lateinit var edge: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
fun backtracking(cur: Int, cnt: Int, n: Int) {
    answer = answer.coerceAtLeast(cnt)
    if(cur >= n) return
    if (visited[cur]) {
        backtracking(cur + 1, cnt, n)
    }
    else {
        visited[cur] = true
        for (next in edge[cur]) {
            if (visited[next]) continue
            visited[next] = true
            backtracking(cur + 1, cnt + 2, n)
            visited[next] = false
        }
        visited[cur] = false
        backtracking(cur+1,cnt,n)
    }
}

fun main() = with(System.out.bufferedWriter()) {

    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    edge = Array(n + 1) { ArrayList<Int>() }
    visited = BooleanArray(n + 1)
    for (i in 0 until m) {
        val (from, to) = br.readLine().split(' ').map { it.toInt() }
        edge[from].add(to)
        edge[to].add(from)
    }

    backtracking(1,0, n)
    if (answer<n) answer++
    write("$answer")

    close()
}
