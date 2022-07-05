//https://www.acmicpc.net/problem/14499
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var graph: Array<IntArray>
val dice = IntArray(6)
val dir = arrayOf(
    arrayOf(),
    arrayOf(0, 1),
    arrayOf(0, -1),
    arrayOf(-1, 0),
    arrayOf(1, 0)
)

fun move(direct: Int) {
    when (direct) {
        1 -> { //동
            dice[0] = dice[3].also { dice[3] = dice[0] }
            dice[2] = dice[5].also { dice[5] = dice[2] }
            dice[2] = dice[3].also { dice[3] = dice[2] }
        }
        2 -> {//서
            dice[0] = dice[2].also { dice[2] = dice[0] }
            dice[3] = dice[5].also { dice[5] = dice[3] }
            dice[2] = dice[3].also { dice[3] = dice[2] }
        }
        3 -> {//북
            dice[0] = dice[1].also { dice[1] = dice[0] }
            dice[4] = dice[5].also { dice[5] = dice[4] }
            dice[0] = dice[5].also { dice[5] = dice[0] }
        }
        else -> {//남
            dice[0] = dice[1].also { dice[1] = dice[0] }
            dice[4] = dice[5].also { dice[5] = dice[4] }
            dice[1] = dice[4].also { dice[4] = dice[1] }
        }
    }
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n,m,x,y,k) = getIntList()
    graph = Array(n) { getIntList().toIntArray() }
    val orderInput = getIntList()
    var r = x
    var c = y
    for (order in orderInput) {
        r += dir[order][0]
        c += dir[order][1]
        if (r !in 0 until n || c !in 0 until m) {
            r -= dir[order][0]
            c -= dir[order][1]
            continue
        }
        move(order)
        write("${dice[0]}\n")
        if (graph[r][c] == 0) {
            graph[r][c] = dice[5]
        } else {
            dice[5] = graph[r][c].also { graph[r][c] = 0 }
        }
    }
    close()
}
