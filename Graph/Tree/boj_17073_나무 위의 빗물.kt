//https://www.acmicpc.net/problem/17073
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, w) = getIntList()
    val degreeCnt = IntArray(n+1)
    repeat(n - 1) {
        val (from, to) = getIntList()
        degreeCnt[from]++
        degreeCnt[to]++
    }
    degreeCnt[1] = 0
    //output
    write("${w/((degreeCnt.count { it==1 }).toDouble())}")
    close()
}
