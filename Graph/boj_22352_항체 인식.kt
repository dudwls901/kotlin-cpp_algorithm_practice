//https://www.acmicpc.net/problem/22352
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var graph: Array<IntArray>
lateinit var result: Array<IntArray>
val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)

fun dfs( n: Int, m: Int, r: Int, c: Int, before: Int, after: Int) {
    graph[r][c] = after
    for (i in 0 until 4) {
        val nr = r + dir[i][0]
        val nc = c + dir[i][1]
        if (nr !in 0 until n || nc !in 0 until m) continue
        if (graph[nr][nc] != before) continue
        dfs(n, m, nr, nc, before, after)
    }
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n, m) = getIntList()
    graph = Array(n) { getIntList().toIntArray() }
    result = Array(n) { getIntList().toIntArray() }
    //solve
    for (r in 0 until n) {
        for (c in 0 until m) {
            if (graph[r][c] != result[r][c]) {
                dfs(n, m, r, c, graph[r][c], result[r][c])
                for(i in 0 until n ){
                    for(j in 0 until m){
                        if(graph[i][j] != result[i][j]){
                            write("NO")
                            close()
                            return
                        }
                    }
                }
            }
        }
    }
    //output
    write("YES")
    close()
}
