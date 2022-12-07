//https://www.acmicpc.net/problem/9205
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()
lateinit var edge: Array<List<Int>>
fun main() = with(System.out.bufferedWriter()){

    repeat(getInt()){
        val n = getInt()
        edge = Array(n+2){ getIntList() }
        write("${bfs(n+2)}\n")
    }
    close()
}

fun bfs(n: Int): String{

    val q: Queue<Int> = LinkedList()
    q.add(0)
    val visited = BooleanArray(n)
    visited[0] = true
    while(q.isNotEmpty()){
        val cur = q.poll()
        for(next in edge.indices){
            val dis = Math.abs(edge[cur][0] - edge[next][0]) + Math.abs(edge[cur][1] - edge[next][1])
            if(dis>1000) continue
            if(visited[next]) continue
            if(next == n-1) return "happy"
            q.add(next)
            visited[next] = true
        }
    }

    return "sad"
}
