//https://www.acmicpc.net/problem/20437
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun getMinAndMax(list: ArrayList<Int>, len: Int): Pair<Int, Int> {
    var min = Int.MAX_VALUE
    var max = -1
    if (list.size >= len) {
        for (i in 0..list.size - len) {
            min = min.coerceAtMost(Math.abs(list[i] - list[i + len - 1]) + 1)
            max = max.coerceAtLeast(Math.abs(list[i] - list[i + len - 1]) + 1)
        }
    }
    return Pair(min, max)
}

fun main() = with(System.out.bufferedWriter()) {

    val t = getInt()
    repeat(t) {
        //input
        val str = br.readLine()
        val k = getInt()
        val charPositionArr = Array(26) { ArrayList<Int>() }

        var minLen = Int.MAX_VALUE
        var maxLen = -1
        //문자별 position 저장
        for (i in str.indices) {
            val ch = str[i]
            charPositionArr[ch - 'a'].add(i)
        }
        for (i in 0 until 26) {
            val (min, max) = getMinAndMax(charPositionArr[i], k)
            minLen = minLen.coerceAtMost(min)
            maxLen = maxLen.coerceAtLeast(max)
        }
        if (minLen == Int.MAX_VALUE) write("-1\n")
        else write("$minLen $maxLen\n")
    }
    close()
}
