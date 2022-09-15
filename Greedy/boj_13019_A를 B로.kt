//https://www.acmicpc.net/problem/13019
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val a = br.readLine()
    val b = br.readLine()
    //solve
    if (a.toCharArray().sorted() != b.toCharArray().sorted()) write("-1")
    else {
        var ap = a.length - 1
        var bp = b.length - 1
        var cnt = 0
        while (ap >= 0) {
            if (a[ap] == b[bp]) {
                bp--
            } else {
                cnt++
            }
            ap--
        }
        write("$cnt")
    }
    close()
}
