//https://www.acmicpc.net/problem/19699
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

val isPrime = BooleanArray(9001) { true }
val answer = mutableSetOf<Int>()
fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, m) = getIntList()
    val cows = getIntList()
    //solve
    makePrime()
    permutation(0, 0, BooleanArray(n), n, m, cows)
    //output
    write("${if (answer.isEmpty()) -1 else answer.sorted().joinToString(" ")} ")
    close()
}

fun permutation(cnt: Int, sum: Int, visited: BooleanArray, n: Int, m: Int, cows: List<Int>) {
    if (cnt == m) {
        if (isPrime[sum]) {
            //output
            answer.add(sum)
        }
        return
    }
    for (i in cows.indices) {
        if (visited[i]) continue
        visited[i] = true
        permutation(cnt + 1, sum + cows[i], visited, n, m, cows)
        visited[i] = false
    }
}

fun makePrime() {
    isPrime[1] = false
    for (i in 2..100) {
        for (j in i * 2..9000 step i) {
            isPrime[j] = false
        }
    }
}
