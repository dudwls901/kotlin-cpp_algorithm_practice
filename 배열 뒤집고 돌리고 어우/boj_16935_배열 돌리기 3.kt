//https://www.acmicpc.net/problem/16935
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }

lateinit var graph: Array<IntArray>
fun reverseVertical(n: Int, m: Int) : Array<IntArray> {
    val temp = Array(n) { IntArray(m) }
    for (c in 0 until m) {
        for (r in 0 until n) {
            temp[r][c] = graph[n-r-1][c]
        }
    }
    return temp
}

fun reverseHorizontal(n: Int, m: Int) : Array<IntArray> {
    val temp = Array(n) { IntArray(m) }
    for (r in 0 until n) {
        for (c in 0 until m) {
            temp[r][c] = graph[r][m-c-1]
        }
    }
    return temp
}
//fun reverseVertical(n: Int, m: Int) {
//    for (c in 0 until m) {
//        for (r in 0 until n / 2) {
//            val nr = n - r - 1
//            graph[r][c] = graph[nr][c].also { graph[nr][c] = graph[r][c] }
//        }
//    }
//}
//
//fun reverseHorizontal(n: Int, m: Int) {
//    for (r in 0 until n) {
//        for (c in 0 until m/2) {
//            val nc = m - c - 1
//            graph[r][c] = graph[r][nc].also { graph[r][nc] = graph[r][c] }
//        }
//    }
//}


fun turnLeft(n: Int, m: Int) : Array<IntArray> {
    val temp = Array(m) { IntArray(n) }
    for (c in 0 until m) {
        for (r in 0 until n) {
            temp[c][r] = graph[r][m - c - 1]
        }
    }
    return temp
}

fun turnRight(n: Int, m: Int) : Array<IntArray>{
    val temp = Array(m) { IntArray(n) }
    for (c in 0 until m) {
        for (r in 0 until n) {
            temp[c][r] = graph[n - r - 1][c]
        }
    }
    return temp
}

fun divideTurnRight(n: Int, m: Int) : Array<IntArray> {
    val temp = Array(n) { IntArray(m) }
    val x = n / 2
    val y = m / 2
    for(r in 0 until n/2){
        for(c in 0 until m/2){
            temp[r][c] = graph[r+x][c]
            temp[r][c+y] = graph[r][c]
            temp[r+x][c+y] = graph[r][c+y]
            temp[r+x][c] = graph[r+x][c+y]
        }
    }
    return temp
}

fun divideTurnLeft(n: Int, m: Int) : Array<IntArray> {
    val temp = Array(n) { IntArray(m) }
    val x = n / 2
    val y = m / 2
    for(r in 0 until n/2){
        for(c in 0 until m/2){
            temp[r][c] = graph[r][c+y]
            temp[r][c+y] = graph[r+x][c+y]
            temp[r+x][c+y] = graph[r+x][c]
            temp[r+x][c] = graph[r][c]
        }
    }
    return temp
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, m, r) = getIntList()
    graph = Array(n) { getIntList().toIntArray() }
    //solve
    getIntList().forEach {
        graph = when (it) {
            1 -> {
                reverseVertical(graph.size, graph[0].size)
            }
            2 -> {
                reverseHorizontal(graph.size, graph[0].size)
            }
            3 -> {
                turnRight(graph.size, graph[0].size)
            }
            4 -> {
                turnLeft(graph.size, graph[0].size)
            }
            5 -> {
                divideTurnRight(graph.size, graph[0].size)
            }
            else -> {
                divideTurnLeft(graph.size, graph[0].size)
            }
        }
    }
    //output
    for (r in graph.indices) {
        for (c in graph[0].indices) {
            write("${graph[r][c]} ")
        }
        write("\n")
    }
    close()
}
