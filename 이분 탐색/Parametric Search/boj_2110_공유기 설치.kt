//https://www.acmicpc.net/problem/2110
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()


var n = 0
var c = 0
lateinit var input: IntArray

fun check(mid: Int): Boolean {
    var cur = input[0]
    var cnt = 1
    for (i in 1 until input.size) {
        if (input[i] - cur >= mid) {
            cnt++
            cur = input[i]
        }
        if (cnt >= c) return true
    }
    return false
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    getIntList().also {
        n = it[0]
        c = it[1]
    }
    input = IntArray(n){ getInt()}
    //solve
    var s = 0
    var e = 1_000_000_000
    input.sort()
    var answer = 0
    while (s <= e) {
        val mid = (s + e) / 2
        if (check(mid)) {
            answer = mid
            s = mid + 1
        } else {
            e = mid - 1
        }
    }
    //output
    write("$answer")
    close()
}
