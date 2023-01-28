//https://www.acmicpc.net/problem/27211
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }

lateinit var graph: Array<IntArray>
val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)

fun main() = with(System.out.bufferedWriter()){
    //input
    val (n,m) = getIntList()
    graph = Array(n){ getIntList().toIntArray() }
    var cnt = 0
    //solve
    for(r in 0 until n){
        for(c in 0 until m){
            if(graph[r][c] == 1) continue
            bfs(r,c,n,m)
            cnt++
        }
    }
    //output
    write("$cnt")
    close()
}

fun bfs(r: Int, c: Int, n: Int, m: Int) {
    val q: Queue<Pair<Int,Int>> = LinkedList()
    q.add(Pair(r,c))
    graph[r][c] = 1
    while (q.isNotEmpty()){
        val (cr,cc) = q.poll()

        for(i in 0 until 4){
            var nr = cr + dir[i][0]
            var nc = cc + dir[i][1]
            if(nr < 0) nr = n-1
            if(nr == n) nr = 0
            if(nc < 0) nc = m-1
            if(nc == m) nc = 0
            if(graph[nr][nc] == 1) continue
            q.add(Pair(nr,nc))
            graph[nr][nc] = 1
        }
    }
}
