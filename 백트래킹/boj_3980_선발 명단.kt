//https://www.acmicpc.net/problem/3980
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var graph: Array<IntArray>
lateinit var visited: BooleanArray
var answer = 0
fun backTracking(pos: Int, sum: Int, end: Int) {
    if (end == pos) {
        answer = answer.coerceAtLeast(sum)
        return
    }
    //선수
    for (i in 0 until 11) {
        //i선수가 j포지션에 들어갈 수 있을 때만
        if (graph[i][pos] > 0) {
            if (visited[i]) continue
            visited[i] = true
            backTracking(pos + 1, sum + graph[i][pos], end)
            visited[i] = false
        }
    }

}

fun main() = with(System.out.bufferedWriter()) {

    val T = getInt()
    repeat(T) {
        //input
        answer = 0
        graph = Array(11) { getIntList().toIntArray() }
        visited = BooleanArray(11)
        //solve
        backTracking(0, 0, 11)
        //output
        write("$answer\n")
    }

    close()
}
