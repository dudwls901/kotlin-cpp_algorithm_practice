//https://www.acmicpc.net/problem/1895
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

lateinit var graph: Array<List<Int>>

fun makeFilter(r: Int, c: Int): Array<IntArray> {
    val filter = Array(r - 2) { IntArray(c - 2) }
    for (i in 0..r - 3) { // == filter.indices
        for (j in 0..c - 3) { // filter[i].indices
            val list = IntArray(9)
            var idx = 0
            for (rr in 0 until 3) {
                for (cc in 0 until 3) {
                    list[idx++] = graph[i + rr][j + cc]
                }
            }
            filter[i][j] = list.sorted()[4]
        }
    }
    return filter
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (r, c) = getIntList()
    graph = Array(r) { getIntList() }
    val search = getInt()

    //solve
    val filter = makeFilter(r, c)

    //만들어진 필터에서 search보다 큰 개수 찾기
    //output
    write("${filter.flatMap { it.asIterable() }.count { it >= search }}")
    close()
}
