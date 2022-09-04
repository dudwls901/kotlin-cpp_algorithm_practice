//https://www.acmicpc.net/problem/18405
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

data class Virus(
    val r: Int,
    val c: Int,
    val d: Int
)

val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)

var n = 0
var k = 0
lateinit var graph: Array<IntArray>
var s = 0
var x = 0
var y = 0


fun bfs() : Int {
    val q: Queue<Virus> = LinkedList()

    for(i in 1 .. k) {
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (graph[r][c] == i) {
                    q.add(Virus(r, c, graph[r][c]))
                }
            }
        }
    }
    var ss = s
    while (ss > 0) {
        val size = q.size
        for (i in 0 until size) {
            val (r,c,d) = q.poll()
            for(j in 0 until 4){
                val nr = r+dir[j][0]
                val nc = c+dir[j][1]
                if(nr !in 0 until n || nc !in 0 until n) continue
                if(graph[nr][nc] !=0) continue
                graph[nr][nc] = d
                q.add(Virus(nr,nc,d))
            }
        }
        ss--
    }
    return graph[x - 1][y - 1]
}


fun main() = with(System.out.bufferedWriter()) {
    //input
    getIntList().apply {
        n = this[0]
        k = this[1]
    }
    graph = Array(n){ getIntList().toIntArray()}
    getIntList().apply{
        s = this[0]
        x = this[1]
        y = this[2]
    }

    write("${bfs()}")
    close()
}
