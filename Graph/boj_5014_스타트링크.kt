//https://www.acmicpc.net/problem/5014
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

var f = 10
var s = 1
var g = 10
var u = 2
var d = 1

fun bfs(visited: BooleanArray): String {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(s, 0))
    visited[s] = true

    while (q.isNotEmpty()) {
        val (cs, cd) = q.poll()
        if (cs == g) return cd.toString()
        var ns = cs + u
        if (ns in 1..f) {
            if (!visited[ns]) {
                q.add(Pair(ns, cd + 1))
                visited[ns] = true
            }
        }
        ns = cs - d
        if (ns in 1..f) {
            if (!visited[ns]) {
                q.add(Pair(ns, cd + 1))
                visited[ns] = true
            }
        }
    }
    return "use the stairs"
}

fun main() = with(System.out.bufferedWriter()) {
    getIntList().apply {
        f= this[0]
        s= this[1]
        g= this[2]
        u= this[3]
        d= this[4]
    }
    write(bfs(BooleanArray(f + 1)))
    close()
}
