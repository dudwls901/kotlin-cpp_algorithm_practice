//https://www.acmicpc.net/problem/1527
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()
var answer = 0
fun subset(result: Long, len: Int, s: Int, e: Int, sLen: Int, eLen: Int) {
    if (len > eLen) return
    if (len >= sLen) {
        if (result in s..e) answer++
    }
    subset(result * 10 + 4, len + 1, s, e, sLen, eLen)
    subset(result * 10 + 7, len + 1, s, e, sLen, eLen)
}

fun main() = with(System.out.bufferedWriter()) {

    val (s, e) = getIntList()
    subset(4, 1, s, e, s.toString().length, e.toString().length)
    subset(7, 1, s, e, s.toString().length, e.toString().length)
    write("$answer")
    close()
}
