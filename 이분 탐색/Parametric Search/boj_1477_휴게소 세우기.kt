//https://www.acmicpc.net/problem/1477
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

//n개 휴게소
//m개 더 세우기
//끝이랑 시갖 위치에는 세우지 못함
//m개 모두 지어야 함
//휴게소가 없는 구간의 길이의 최댓값을 최소로(휴게소와 휴게소 사이의 거리)
fun canBuild(maxDis: Int, m : Int , place: IntArray): Boolean {
    var cur = 0
    var cnt = 0
    var idx = 0
    while (idx < place.size) {
        //maxDis보다 먼 거리인 경우 휴게소 설치
        if (place[idx] - cur > maxDis) {
            cur += maxDis
            if (cnt == m) return false
            cnt++
        } else {
            cur = place[idx++]
        }
    }
    return true
}

fun main() = with(System.out.bufferedWriter()) {
    val (n,m,l) = getIntList()
    val tk = StringTokenizer(br.readLine())
    val place = IntArray(n + 1) {
        if (it == n) {
            l
        } else {
            tk.nextToken().toInt()
        }
    }
    place.sort()
    var s = 1
    var e = l - 1
    var answer = 0
    while (s <= e) {
        val mid = (s + e) / 2
        if (canBuild(mid, m, place)) {
            answer = mid
            e = mid - 1
        } else {
            s = mid + 1
        }
    }
    write("$answer")
    close()
}
