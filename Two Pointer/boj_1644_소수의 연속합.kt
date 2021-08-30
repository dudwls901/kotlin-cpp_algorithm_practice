//https://www.acmicpc.net/problem/1644
fun makePrime(n: Int, check: BooleanArray) {
    check[1]=true
    for (i in 2..n / 2) {
        var j = i*2
        if (check[i]) continue
        while (j <= n) {
            check[j] = true
            j += i
        }
    }

}

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    val check = BooleanArray(n + 1)
    var answer = 0

    makePrime(n, check)

    val primeSum = IntArray(n + 1)
    var primeIdx = 1
    for (i in 1..n) {
        if (check[i]) continue
        primeSum[primeIdx] = primeSum[primeIdx - 1] + i
        primeIdx++
    }

    var s = 0
    var e = 0

    while (s < primeIdx) {
        val prefixSum = primeSum[e] - primeSum[s]
        if (prefixSum < n) {
            if (e < primeIdx-1) {
                e++
            } else {
                s++
            }
        } else if (prefixSum > n) {
            s++
        } else {
            answer++
            s++
        }
    }
    write("$answer")
    close()
}
