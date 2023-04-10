//https://www.acmicpc.net/problem/2638
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getStr() = br.readLine().trim()
fun getInt() = br.readLine().trim().toInt()

lateinit var graph: Array<IntArray>
val dir = arrayOf(
    arrayOf(0,1),
    arrayOf(1,0),
    arrayOf(0,-1),
    arrayOf(-1,0),
)

fun main() = with(System.out.bufferedWriter()){
    //input
    val (n,m) = getIntList()
    graph = Array(n){ getIntList().toIntArray() }
    //solve, output
    write("${bfs(n,m)}")

    close()
}

fun bfs(n: Int, m: Int): Int{
    var time = 0
    while(true){
        val visited = Array(n){IntArray(m)}
        val q: Queue<Pair<Int,Int>> = LinkedList()
        q.add(Pair(0,0))
        visited[0][0] = 1
        while(q.isNotEmpty()){
            val (r,c) = q.poll()
            for(i in 0 until 4){
                val nr = r+dir[i][0]
                val nc = c + dir[i][1]
                if(nr !in 0 until n || nc !in 0 until m) continue
                visited[nr][nc]= visited[nr][nc]+1
                if(visited[nr][nc]>1 || graph[nr][nc]==1) continue
                q.add(Pair(nr,nc))
            }
        }
        time++
        var oneCount = 0
        for(r in 0 until n){
            for(c in 0 until m){
                if(graph[r][c] ==1) {
                    if(visited[r][c]>=2){
                        graph[r][c] = 0
                    }else{
                        oneCount++
                    }
                }
            }
        }
        if(oneCount==0) break
    }
    return time
}
