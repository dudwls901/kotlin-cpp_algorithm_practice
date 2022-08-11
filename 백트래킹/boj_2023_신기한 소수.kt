//https://www.acmicpc.net/problem/2023
val br = System.`in`.bufferedReader()
val bw = System.out.bufferedWriter()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
var n = 0
fun checkPrime(num: Int): Boolean {
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }
    return true
}

fun backTracking(len: Int, result: Int) {

    //소수 검사
    if (len > 0 && !checkPrime(result)) return

    if (len == n) {
        bw.write("$result\n")
        return
    }
    for (i in 1..9) {
        if(len==0 && i == 1) continue
        backTracking(len + 1, result * 10 + i)
    }
}

fun main() {
    n = getInt()
    backTracking(0, 0)
    br.close()
    bw.close()
}
