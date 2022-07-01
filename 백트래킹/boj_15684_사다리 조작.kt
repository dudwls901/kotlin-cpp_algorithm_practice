//https://www.acmicpc.net/problem/15684
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

var n = 5 //세로 선 개수
var m = 6 // 초기 가로 선 개수
var h = 6 // 가로선 놓을 수 있는 위치의 개수
lateinit var inputHorizon: Array<IntArray>
val edge = Array(33) { Array(33) { BooleanArray(2) } }
var answer = Int.MAX_VALUE
//make Edge Set

fun check(): Boolean {
    for(i in 1 .. n){
        var cur = i
        for(j in 1 ..h){
            if(edge[j][cur][0]){
                cur--
            }
            else if(edge[j][cur][1]){
                cur++
            }
        }
        if(cur!=i) return false
    }
    return true
}

fun backTracking(idx: Int, cnt: Int) {

    if (answer <= cnt) return

    val r = idx / n + 1
    val c = idx % n
    //check
    if (check()) {
        answer = answer.coerceAtMost(cnt)
        return
    }
    if (idx >= n * h) return
    if (cnt == 3) {
        return
    }


    backTracking(idx + 1, cnt)

    //사다리 설치
    if (c != 0 && c <= n - 1 && !edge[r][c][0] && !edge[r][c][1] && !edge[r][c + 1][0] && !edge[r][c + 1][1]) {
        if (!(c - 1 > 0 && edge[r][c - 1][1])) {
            edge[r][c][1] = true
            edge[r][c + 1][0] = true
            backTracking(idx + 1, cnt + 1)
            edge[r][c][1] = false
            edge[r][c + 1][0] = false
        }
    }

}

fun main() = with(System.out.bufferedWriter()) {

    val tk = StringTokenizer(br.readLine())
    n = tk.nextToken().toInt()
    m = tk.nextToken().toInt()
    h = tk.nextToken().toInt()
    inputHorizon = Array(m){ getIntList().toIntArray()}
    for (horizon in inputHorizon) {
        edge[horizon[0]][horizon[1]][1] = true
        edge[horizon[0]][horizon[1] + 1][0] = true
    }

    backTracking(1, 0)
    write("${if (answer == Int.MAX_VALUE) -1 else answer}")
    close()
}
