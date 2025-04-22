//https://www.acmicpc.net/problem/10974
import java.io.BufferedWriter

val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().trim().toInt()

lateinit var visited: BooleanArray

fun permutation(len: Int, n: Int, result: IntArray, bw: BufferedWriter) {
    if (len == n) {
        bw.write("${result.filter { it != 0 }.joinToString(" ")}\n")
        return
    }
    for (i in 1..n) {
        if (visited[i]) continue
        result[len] = i
        visited[i] = true
        permutation(len+1, n, result, bw)
        result[len] = 0
        visited[i] = false
    }
}

fun main() {
    val n = getInt()
    val bw = System.out.bufferedWriter()
    visited = BooleanArray(n + 1)
    permutation(0, n, IntArray(n), bw)
    bw.close()
}
