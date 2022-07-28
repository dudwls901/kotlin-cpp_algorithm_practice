//https://www.acmicpc.net/problem/11561
import kotlin.math.sqrt
val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().toInt()

fun check(mid: ULong, n: ULong) = mid * (mid + 1u) / 2u <= n

fun main() = with(System.out.bufferedWriter()) {

    repeat (getInt()) {
        val n = br.readLine().toULong()
        var s: ULong = 1u
        var e: ULong = (sqrt(n.toDouble())*2).toULong()
        var answer: ULong = 0u
        while (s <= e) {
            val mid = (s + e) / 2u
            if (check(mid, n)) {
                answer = mid
                s = mid + 1u
            } else {
                e = mid - 1u
            }
        }
        write("${answer}\n")
    }
    close()
}
