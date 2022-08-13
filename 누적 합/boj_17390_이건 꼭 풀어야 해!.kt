//https://www.acmicpc.net/problem/17390
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n,q) = getIntList()
    val input = getIntList().toIntArray()
    val questions = Array(q){ getIntList()}
    //solve
    input.sort()
    val preSum = IntArray(n + 1)
    for (i in 1..n) {
        preSum[i] = preSum[i - 1] + input[i - 1]
    }
    //output
    for ((s, e) in questions) {
        write("${preSum[e] - preSum[s - 1]}\n")
    }
    close()
}
