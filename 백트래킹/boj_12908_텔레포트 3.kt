//https://www.acmicpc.net/problem/12908
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()


var xs = 0
var ys = 0
var xe = 0
var ye = 0
val map = mutableMapOf<Pair<Int, Int>, Pair<Int, Int>>()
var answer = Long.MAX_VALUE

fun getDisBetween(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2)
}

fun getTotalDistance(result: Array<IntArray>, passCnt: Int): Long {
    var x1 = xs
    var y1 = ys
    var totalDis = 0L
    for (i in 0 until passCnt) {
        val (x2, y2) = result[i]
        var dis = getDisBetween(x1, y1, x2, y2)
        if (map[Pair(x1, y1)] == Pair(x2, y2)) {
            dis = dis.coerceAtMost(10)
        }
        totalDis += dis
        x1 = x2
        y1 = y2
    }
    var dis = getDisBetween(x1, y1, xe, ye)
    if (map[Pair(x1, y1)] == Pair(xe, ye)) {
        dis = dis.coerceAtMost(10)
    }
    totalDis += dis
    return totalDis
}

fun makePermutation(
    destinations: Array<IntArray>,
    result: Array<IntArray>,
    visited: BooleanArray,
    idx: Int
) {
    answer = answer.coerceAtMost(getTotalDistance(result, idx))
    if (idx == 6) {
        return
    }
    for (i in 0 until 6) {
        if (visited[i]) continue
        result[idx] = destinations[i]
        visited[i] = true
        makePermutation(destinations, result, visited, idx + 1)
        visited[i] = false
    }
}


fun main() = with(System.out.bufferedWriter()) {
    getIntList().apply {
        xs = this[0]
        ys = this[1]
    }
    getIntList().apply{
        xe = this[0]
        ye = this[1]
    }
    val teleports = Array(3){ getIntList()}
    val destinations = Array(6) { IntArray(2) }
    var idx = 0
    for (tele in teleports) {
        val (x1, y1, x2, y2) = tele
        destinations[idx++] = intArrayOf(x1, y1)
        destinations[idx++] = intArrayOf(x2, y2)

        map[Pair(x1, y1)] = Pair(x2, y2)
        map[Pair(x2, y2)] = Pair(x1, y1)
    }
    makePermutation(destinations, Array(6) { IntArray(2) }, BooleanArray(6), 0)
    write("$answer")
    close()
}
