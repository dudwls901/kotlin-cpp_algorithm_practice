//https://www.acmicpc.net/problem/1676
val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    val n = getInt()
    var key = 5
    var answer = 0
    while (key <= n) {
        answer += n / key
        key *= 5
    }
    write("$answer")
    close()
}
