//https://www.acmicpc.net/problem/1022
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(-1, 0),
    arrayOf(0, -1),
    arrayOf(1, 0),
)

lateinit var graph: Array<IntArray>
fun main() = with(System.out.bufferedWriter()) {

    var( r1, c1, r2, c2) = getIntList()
    var r = 0
    var c = 0
    graph = Array(r2-r1+1){ IntArray(c2-c1+1) }
    if(r1<0){
        r2 -=r1
        r = -r1
        r1 =0
    }
    else{
        r = -r1
    }
    if(c1<0){
        c2 -=c1
        c = -c1
        c1 = 0
    }
    else{
        c = -c1
    }
    var maxNum = 0
    var num = 1
    var len = 1
    var d = 0
    if(r in graph.indices && c in graph[0].indices)  graph[r][c] = num
    while (true) {
        for (i in 0 until len) {
            r += dir[d % 4][0]
            c += dir[d % 4][1]
            ++num
            if(r in graph.indices && c in graph[0].indices) {
                graph[r][c] = num
                maxNum = maxNum.coerceAtLeast(graph[r][c])
            }
        }
        if (++d % 2 == 0) {
            len++
        }
        if (graph[0][0] != 0 && graph[0][graph[0].size-1] != 0 && graph[graph.size-1][graph[0].size-1] != 0 && graph[graph.size-1][0] != 0) {
            break
        }
    }
    val maxLen = maxNum.toString().length
    for (i in graph.indices) {
        for (j in graph[0].indices) {
            write("${String.format("%${maxLen}d", graph[i][j])} ")
        }
        write("\n")
    }
    close()
}
