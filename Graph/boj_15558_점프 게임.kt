//https://www.acmicpc.net/problem/15558
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()
/*
* 승리 조건 n으로 이동하는 경우 (그래프 밖으로 나가는 경우)
* */

val dir = arrayOf(
    arrayOf(0, 0),
    arrayOf(0, 1),
    arrayOf(0, -1)
)

fun main() {

    //input
    val (n, k) = getIntList()
    val graph = arrayOf(
        br.readLine().toCharArray(),
        br.readLine().toCharArray()
    )
    //solve
    //output
    print(
        if(bfs(n,k,graph, Array(2){BooleanArray(n)})) 1 else 0
    )
}

fun bfs(n: Int, k: Int, graph: Array<CharArray>, visited: Array<BooleanArray>): Boolean {
    val q: Queue<Triple<Int,Int,Int>> = LinkedList()
    q.add(Triple(0,0,0))
    while(q.isNotEmpty()){
        val (cr,cc,ct) = q.poll()
        for(i in 0 until 3){
            var nr = cr
            var nc = cc + dir[i][1]
            if(i == 0){
                //jump
                nr = if(nr == 0) 1 else 0
                nc +=k
            }
            if(nc >= n) {
                return true
            }
            if(nc !in ct+1 until n ) continue
            if(visited[nr][nc]) continue
            if(graph[nr][nc]=='0') continue
            visited[nr][nc] = true
            q.add(Triple(nr,nc,ct+1))
        }
    }
    return false
}
