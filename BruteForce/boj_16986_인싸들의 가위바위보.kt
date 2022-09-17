//https://www.acmicpc.net/problem/16986
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

//결과 같을 땐 침펄풍 인덱스 큰 사람이 승
var n = 0
var k = 0
lateinit var genealogy: Array<List<Int>>
var answer = 0

fun play(
    deck: Array<IntArray>,
    winner: Int,
    other: Int,
    winCnt: IntArray,
    idxArr: IntArray
) {
    if (winner == other) {
        play(deck, winner, (other + 1) % 3, winCnt, idxArr)
        return
    }
    if (idxArr[0] >= n) return
    var win = -1
    var lose = -1
    when (genealogy[deck[winner][idxArr[winner]] - 1][deck[other][idxArr[other]] - 1]) {
        2 -> {
            win = winner
            lose = other
        }
        0 -> {
            win = other
            lose = winner
        }
        else -> {
            //비긴 경우 순서에 의해 승패 판정
            win = if (winner < other) other else winner
            lose = if (winner < other) winner else other
        }
    }
    winCnt[win]++
    idxArr[win]++
    idxArr[lose]++
    if (winCnt[0] >= k) {
        answer = 1
        return
    }
    if (winCnt[win] < k) {
        play(deck, win, (lose + 1) % 3, winCnt, idxArr)
    }

}

fun permutation(deck: Array<IntArray>, visited: BooleanArray, len: Int) {
    if (answer == 1) return
    if (len == n) {
        play(deck, 0, 1, IntArray(3), IntArray(3))
        return
    }

    for (i in 0 until n) {
        if (visited[i]) continue
        visited[i] = true
        deck[0][len] = i+1
        permutation(deck, visited, len + 1)
        visited[i] = false
    }
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    getIntList().apply {
        n = this[0]
        k = this[1]
    }
    genealogy = Array(n) { getIntList() }
    val deck = arrayOf(
        IntArray(20) { -1 },
        getIntList().toIntArray(),
        getIntList().toIntArray()
    )
    permutation(deck, BooleanArray(n), 0)
    write("$answer")
    close()
}
