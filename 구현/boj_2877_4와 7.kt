//https://www.acmicpc.net/problem/2877
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()) {
    var k = getInt()

    var sum = 0
    var bound = 2
    while (sum < k) {
        sum += bound
        bound *= 2
    }
    bound /= 2
    k -= sum-bound
    val sb = StringBuilder()
    while (bound > 1) {
        bound/=2
        if (k > bound) {
            sb.append('7')
            k-=bound
        }
        else sb.append('4')
    }
    write("$sb")
    close()
}
