//https://www.acmicpc.net/problem/1581
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
var answer = 0
var ff = 0
var fs = 0
var sf = 0
var ss = 0

fun fStart() {
    answer += ff
    if (fs > 0) {
        answer++
        fs--
        answer += ss
        val min = fs.coerceAtMost(sf)
        answer += min * 2
        fs -= min
        sf -= min
        if (sf > 0) answer++
    }
}

fun sStart() {
    answer += ss
    if (sf > 0) {
        answer++
        sf--
        answer += ff

        val min = fs.coerceAtMost(sf)
        answer += min * 2
        fs -= min
        sf -= min
        if (fs > 0) answer++
    }
}

fun main() = with(System.out.bufferedWriter()) {
    getIntList().also{
        ff = it[0]
        fs = it[1]
        sf = it[2]
        ss = it[3]
    }
    if (ff > 0 || fs > 0) {
        fStart()
    } else {
        sStart()
    }
    write("$answer")
    close()
}
