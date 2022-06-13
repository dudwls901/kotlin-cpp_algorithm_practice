//https://www.acmicpc.net/problem/17472
import java.util.*
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

/*
* 1. 섬 그룹핑하기
* 2. 각 섬에서 다리 놓아보기 (크루스칼에 쓰일 간선)
* 3. 크루스칼 돌리기
* */
data class Edge(
    val from: Int,
    val to: Int,
    val dis: Int
)

val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)
lateinit var graph: Array<IntArray>
lateinit var visited: Array<BooleanArray>
lateinit var parent: IntArray
val pq = ArrayList<Edge>()
//val pq = PriorityQueue<Edge> { a, b ->
//    when {
//        a.dis < b.dis -> -1
//        a.dis > b.dis -> 1
//        else -> 0
//    }
//}


fun getParent(x: Int): Int = if(x == parent[x]) x else getParent(parent[x]).also{ parent[x] = it }

fun unionParent(x: Int, y: Int){
    val xx = getParent(x)
    val yy = getParent(y)
    if(xx<yy) parent[yy] =  xx
    else parent[xx] = yy
}

fun findParent(x: Int, y: Int): Boolean{
    val xx = getParent(x)
    val yy = getParent(y)
    return xx == yy
}

fun setBridge(n: Int, m: Int, r: Int, c: Int) {

    for (i in 0 until 4) {
        var nr = r+dir[i][0]
        var nc = c+dir[i][1]
        while (nr in 0 until n && nc in 0 until m && graph[nr][nc] == 0) {
            nr += dir[i][0]
            nc += dir[i][1]
        }
        if (nr !in 0 until n || nc !in 0 until m) continue //연결할 섬이 없는 경우
        if (graph[r][c] == graph[nr][nc]) continue // 같은 섬에 연결된 경우
        val dis = Math.abs(nr - r + nc - c)-1 //둘 중 하나는 0
        if (dis <= 1) continue //다리 길이가 1이하인 경우
        pq.add(Edge(graph[r][c], graph[nr][nc], dis))
    }

}

fun grouping(n: Int, m: Int, r: Int, c: Int, num: Int) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(r, c))
    graph[r][c] = num
    while (q.isNotEmpty()) {
        val (cr, cc) = q.poll()
        for (i in 0 until 4) {
            val nr = cr + dir[i][0]
            val nc = cc + dir[i][1]
            if (nr !in 0 until n || nc !in 0 until m) continue
            if (visited[nr][nc]) continue
            if (graph[nr][nc] != 1) continue
            graph[nr][nc] = num
            q.add(Pair(nr, nc))
        }
    }
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, m) = getIntList()
    graph = Array(n) { getIntList().toIntArray() }
    visited = Array(n) { BooleanArray(m) }
    //solve
    //grouping
    var num = 2
    for (r in 0 until n) {
        for (c in 0 until m) {
            if (graph[r][c] != 1) continue
            grouping(n, m, r, c, num++)
        }
    }
    //setBridge
    for (r in 0 until n) {
        for (c in 0 until m) {
            if (graph[r][c] == 0) continue
            setBridge(n, m,r,c)
        }
    }
    //Kruskal (섬 연결)
    pq.sortBy { it.dis }
    parent = IntArray(num){it}
    var answer=0
    for(edge in pq){
        if(!findParent(edge.from, edge.to)){
            answer+=edge.dis
            unionParent(edge.from,edge.to)
        }
    }
    //output
    val p = getParent(2)
    for(i in 2 until num){
        if(p!= getParent(i)){
            write("-1")
            close()
            return
        }
    }
    write("$answer")

    close()
}
