//https://www.acmicpc.net/problem/23289
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

var R = 0
var C = 0
var K = 0
var W = 3

//1우
//2좌
//3상
//4하
val dir = arrayOf(
    intArrayOf(),
    intArrayOf(0, 1),
    intArrayOf(0, -1),
    intArrayOf(-1, 0),
    intArrayOf(1, 0)
)

val dxdy = arrayOf(
    arrayOf(),
    arrayOf(//우
        arrayOf(0, 1),
        arrayOf(-1, 1),
        arrayOf(1, 1)
    ),
    arrayOf(//좌
        arrayOf(0, -1),
        arrayOf(-1, -1),
        arrayOf(1, -1)
    ),
    arrayOf(//상
        arrayOf(-1, 0),
        arrayOf(-1, 1),
        arrayOf(-1, -1)
    ),
    arrayOf(//하
        arrayOf(1, 0),
        arrayOf(1, 1),
        arrayOf(1, -1)
    )
)

lateinit var walls: Array<Array<Array<BooleanArray>>>
lateinit var map: Array<IntArray>
val airStart = ArrayList<Triple<Int, Int, Int>>()
val destination = ArrayList<Pair<Int, Int>>()

fun canFinish(): Boolean {
    for (des in destination) {
        val (r, c) = des
        if (map[r][c] < K) return false
    }
    return true
}

fun sideMinus() {
    for (r in 0 until R) {
        if (map[r][0] > 0) map[r][0]--
        if (map[r][C - 1] > 0) map[r][C - 1]--
    }
    for (c in 1 until C - 1) {
        if (map[0][c] > 0) map[0][c]--
        if (map[R - 1][c] > 0) map[R - 1][c]--
    }
}

fun isWall(r: Int, c: Int, nr: Int, nc: Int, d: Int): Boolean {
    if(r == nr || c == nc){
        return walls[r][c][nr][nc]
    }
    //우좌
    if(d<=2){
        return walls[r][c][nr][c] || walls[nr][c][nr][nc]
    }
    //상하
    else{
        return walls[r][c][r][nc] || walls[r][nc][nr][nc]
    }
}

fun wind(r: Int, c: Int, d: Int) {

    val q: Queue<Pair<Int, Int>> = LinkedList()
    val visited = Array(R) { BooleanArray(C) }
    val x = r + dxdy[d][0][0]
    val y = c + dxdy[d][0][1]
    if (x !in 0 until R || y !in 0 until C) return
    q.add(Pair(x, y))
    map[x][y] += 5
    var depth = 4
    while (q.isNotEmpty()) {
        val size = q.size
        for (i in 0 until size) {
            val (cr, cc) = q.poll()
            for (j in 0 until 3) {
                val nr = cr + dxdy[d][j][0]
                val nc = cc + dxdy[d][j][1]
                if (nr !in 0 until R || nc !in 0 until C) continue
                if (visited[nr][nc]) continue
                if (isWall(cr, cc,nr,nc, d)) continue
                visited[nr][nc] = true
                map[nr][nc] += depth
                if (depth == 1) continue
                q.add(Pair(nr, nc))
            }
        }
        depth--
    }
}

fun tempControl() {
    val temp = Array(R) { IntArray(C) }
    for (r in 0 until R) {
        for (c in 0 until C) {
            for (i in 1..4) {
                val nr = r + dir[i][0]
                val nc = c + dir[i][1]
                if (nr !in 0 until R || nc !in 0 until C) continue
                if (walls[r][c][nr][nc]) continue
                val diff = map[r][c] - map[nr][nc]
                if (diff > 0) {
                    temp[r][c] -= diff / 4
                    temp[nr][nc] += diff / 4
                }
            }
        }
    }
    for (r in 0 until R) {
        for (c in 0 until C) {
            map[r][c] += temp[r][c]
        }
    }
}

fun simulation() {
    //온풍기 시뮬레이션
    for (air in airStart) {
        wind(air.first, air.second, air.third)
    }
//    //온도 조절
    tempControl()
    //테두리 온도 -1
    sideMinus()
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    getIntList().apply {
        R = this[0]
        C = this[1]
        K = this[2]
    }
    //온풍기, 감시 구간 입력
    for (r in 0 until R) {
        val line = getIntList()
        for (c in 0 until C) {
            if (line[c] != 0) {
                if (line[c] == 5) {
                    destination.add(Pair(r, c))
                } else {
                    airStart.add(Triple(r, c, line[c]))
                }
            }
        }
    }
    //벽 입력
    W = getInt()
    walls = Array(R) { Array(C) { Array(R) { BooleanArray(C) } } }
    map = Array(R) { IntArray(C) }
    repeat(W) {
        val wall = getIntList()
        val r = wall[0] - 1
        val c = wall[1] - 1
        //가로벽
        if (wall[2] == 0) {
            walls[r][c][r-1][c] = true
            walls[r-1][c][r][c] = true
        }
        //세로벽
        else {
            walls[r][c][r][c+1] = true
            walls[r][c + 1][r][c] = true
        }

    }

    //solve
    var cnt = 0
    while (cnt <= 100) {
        cnt++
        simulation()
        //끝났는지 확인
        if (canFinish()) break
    }

    write("$cnt")
    close()
}
