//https://www.acmicpc.net/problem/2026
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
val bw = System.out.bufferedWriter()
lateinit var isFriend: Array<BooleanArray>
lateinit var edge: Array<ArrayList<Int>>
var isFinish = false

fun check(result: IntArray): Boolean {
    for (i in result.indices) {
        for (j in i + 1 until result.size) {
            if (!isFriend[result[i]][result[j]]) return false
        }
    }
    return true
}

fun combination(cur: Int, idx: Int, result: IntArray, k: Int, n: Int) {
    if (isFinish) return
    if (idx == k) {
        if (check(result)) {
            isFinish = true
            for (r in result) {
                bw.write("$r\n")
            }
        }
        return
    }
    if (cur > n) return
    if (edge[cur].size + 1 < k) {
        combination(cur + 1, idx, result,k,n)
    }
    else{
        //뽑기
        result[idx] = cur
        combination(cur + 1, idx + 1, result,k,n)
        result[idx] = 0
        //안 뽑기
        combination(cur + 1, idx, result,k,n)
    }
}

fun main() {

    //input
    val (k,n,f) = getIntList()
    isFriend = Array(n + 1) { BooleanArray(n + 1) }
    edge = Array(n + 1) { ArrayList() }

    repeat (f) {
        val (from, to) = getIntList()
        isFriend[from][to] = true
        isFriend[to][from] = true
        edge[from].add(to)
        edge[to].add(from)
    }
    //solve
    combination(1, 0, IntArray(k),k,n)
    if(!isFinish) bw.write("-1")
    bw.close()
}
