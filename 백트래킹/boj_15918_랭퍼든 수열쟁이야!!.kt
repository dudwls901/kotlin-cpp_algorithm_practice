//https://www.acmicpc.net/problem/15918
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()
var answer = 0
fun backTracking(cnt: Int, idx: Int, n: Int, x: Int, y: Int, result: IntArray, visited: BooleanArray) {
    if (cnt == n) {
        answer++
        return
    }
    if (result[idx] != 0) {
        backTracking(cnt,idx + 1, n, x, y, result, visited)
    } else {
        for (i in 1..n) {
            if (visited[i]) continue
            if (idx + i + 1 >= 2 * n) continue
            if (result[idx + i + 1] != 0) continue
            visited[i] = true
            result[idx] = i
            result[idx + i + 1] = i
            backTracking(cnt+1,idx + 1, n, x, y, result, visited)
            result[idx] = 0
            result[idx + i + 1] = 0
            visited[i] = false
        }
    }
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n, x, y) = getIntList()

	//solve
    val result = IntArray(2 * n)
    val visited = BooleanArray(n + 1)
    val num = y - x - 1
    result[x - 1] = num
    result[y - 1] = num
    visited[num] = true
    backTracking(1,0, n, x, y, result, visited)

	//output
    write("$answer")
    close()
}
