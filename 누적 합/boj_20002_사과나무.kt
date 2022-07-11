//https://www.acmicpc.net/problem/20002
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    val graph = Array(n+1) { IntArray(n+1) }
    for(r in 1 .. n){
        val input = getIntList()
        for(c in 1 .. n){
            graph[r][c] = input[c-1] - graph[r-1][c-1] + graph[r][c-1] + graph[r-1][c]
        }
    }

    var answer = -1000
    for (i in 1 .. n) {
        for (r in i .. n) {
            for (c in i .. n) {
                answer = answer.coerceAtLeast(graph[r][c] + graph[r-i][c-i] - graph[r-i][c] - graph[r][c-i])
            }
        }
    }
    write("$answer")
    close()
}
