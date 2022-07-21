//https://www.acmicpc.net/problem/12969
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }

var N = 0
var K = 0
val dp = Array(31) { Array(31) { Array(31) { BooleanArray(450) } } }
var isFinish = false
lateinit var answer: CharArray
fun makeDP(a: Int, b: Int, c: Int, cnt: Int, len: Int) {
    if (cnt == K && len == N && !isFinish) {
        for(i in 0 until N){
            print("${answer[i]}")
        }
        isFinish = true
        return
    }
    if (len >= N) return
    if (cnt > K) return
    if (isFinish) return
    if (dp[a][b][c][cnt]) return
    dp[a][b][c][cnt] = true
    if (cnt + a <= K) {
        answer[len] = 'B'
        makeDP(a, b + 1, c, cnt + a, len+1)
    }
    if (cnt + a + b <= K) {
        answer[len] = 'C'
        makeDP(a, b, c + 1, cnt + a + b, len+1)
    }
    answer[len] = 'A'
    makeDP(a + 1, b, c, cnt, len+1)
}

fun main() {
    getIntList().also {
        N = it[0]
        K = it[1]
    }
    answer = CharArray(N)
    makeDP(0, 0, 0, 0, 0)
    if (!isFinish) println(-1)
}
