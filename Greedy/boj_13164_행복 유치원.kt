//https://www.acmicpc.net/problem/13164
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    val (n,k) = getIntList()
    val input = getIntList()
    var answer = 0
    val arr = IntArray(input.size - 1)
    for (i in arr.indices) {
        arr[i] = input[i + 1] - input[i]
        answer += arr[i]
    }
    arr.sortDescending()
    for (i in 0 until k - 1) {
        answer -= arr[i]
    }
    write("$answer")
    close()
}
