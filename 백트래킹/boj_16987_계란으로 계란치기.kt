//https://www.acmicpc.net/problem/16987
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

var answer = 0
var n = 0
lateinit var input: Array<IntArray>

fun backTracking(idx: Int, cnt: Int) {
    if (idx == n) {
        answer = answer.coerceAtLeast(cnt)
        return
    }
    if (input[idx][0] <= 0) backTracking(idx + 1, cnt)
    else {
        var canBreak = false
        for (i in input.indices) {
            var tempCnt = cnt
            if (i == idx) continue
            if (input[i][0] <= 0) continue
            canBreak = true
            input[idx][0] -= input[i][1]
            input[i][0] -= input[idx][1]
            if (input[idx][0] <= 0) tempCnt++
            if (input[i][0] <= 0) tempCnt++
            backTracking(idx + 1, tempCnt)
            input[idx][0] += input[i][1]
            input[i][0] += input[idx][1]
        }
        if(!canBreak) backTracking(idx + 1, cnt)
    }
}

fun main() = with(System.out.bufferedWriter()) {
    n = getInt()
    input = Array(n) { getIntList().toIntArray() }
    backTracking(0, 0)
    write("$answer")
    close()
}
