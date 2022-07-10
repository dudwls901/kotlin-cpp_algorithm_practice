//https://www.acmicpc.net/problem/17780
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

var n = 0
var k = 0
lateinit var graph: Array<List<Int>>

//1부터k 말까지 순서대로 이동
//빨간색 이동하면 뒤집기
//파란색 이동하면 방향 반대로 바꿔서 이동
val dir = arrayOf(
//우하좌상
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0),
)

data class Horse(
    val num: Int,
    var d: Int
)

lateinit var map: Array<Array<ArrayList<Horse>>>

fun simulation(): Int {
    var cnt = 1

    while (cnt <= 1000) {
        label@ for (num in 1..k) {
            for (r in 0 until n) {
                for (c in 0 until n) {
                    //1~k중 일치하는(가장 아래에 있는 말)말이 있다면 move
                    if (map[r][c].isNotEmpty() && map[r][c][0].num == num) {
                        var curHorses = map[r][c]
                        var nr = r + dir[curHorses[0].d][0]
                        var nc = c + dir[curHorses[0].d][1]
                        //다음칸이 파란색이거나 바깥일 때 방향 전환
                        if (nr !in 0 until n || nc !in 0 until n || graph[nr][nc] == 2) {

                            curHorses[0].d = (curHorses[0].d + 2) % 4

                            nr = r + dir[curHorses[0].d][0]
                            nc = c + dir[curHorses[0].d][1]
                            //방향 전환 후 이동했을 때 또 파란색이거나 바깥일 때는 방향만 바뀌고 그대로
                            if (nr !in 0 until n || nc !in 0 until n || graph[nr][nc] == 2) continue@label
                        }
                        //다음 칸이 빨간색일 땐 뒤집기
                        if (graph[nr][nc] == 1) {
                            curHorses.reverse()
                        }
                        //다음 칸에 말 얹기
                        map[nr][nc].addAll(curHorses)

                        if (map[nr][nc].size >= 4) return cnt
                        //기존 칸 말 없애기
                        map[r][c].clear()
                        continue@label
                    }
                }
            }
        }
        cnt++
    }
    return -1
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    getIntList().apply {
        n = this[0]
        k = this[1]
    }
    graph = Array(n) { getIntList() }
    map = Array(n) { Array(n) { ArrayList() } }
    //말 삽입
    for (i in 1..k) {
        var (r, c, d) = getIntList()
        r--
        c--
        d = when (d) {
            1 -> 0
            4 -> 1
            else -> d
        }
        map[r][c].add(Horse(i, d))
    }
    //solve, output
    write("${simulation()}")
    close()
}
