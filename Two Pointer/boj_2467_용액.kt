//https://www.acmicpc.net/problem/2467
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    val input = getIntList()

    //solve
    var s = 0
    var e = input.size - 1
    var min = Int.MAX_VALUE
    var l = 0
    var r = 0
    while (s < e) {
        var sum = Math.abs(input[s] + input[e])
        if (sum < min) {
            l = input[s]
            r = input[e]
            min = sum
        }
        if (input[s] + input[e] > 0) {
            e--
        } else if (input[s] + input[e] < 0) {
            s++
        } else break
    }
    //output
    write("$l $r")
    close()
}
