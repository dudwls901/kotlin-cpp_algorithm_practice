//https://www.acmicpc.net/problem/23971
val br = System.`in`.bufferedReader()
fun getIntArray() = br.readLine().trim().split(' ').map { it.toInt() }.toIntArray()

fun main() = with(System.out.bufferedWriter()) {
    val (h, w, n, m) = getIntArray()
    val x = (w / (m + 1) + if (w % (m + 1) == 0) 0 else 1).toLong()
    val y = (h / (n + 1) + if (h % (n + 1) == 0) 0 else 1).toLong()
    write("${x * y}")
    close()
}
