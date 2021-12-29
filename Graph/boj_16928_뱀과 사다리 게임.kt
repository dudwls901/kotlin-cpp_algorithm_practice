//https://www.acmicpc.net/problem/16928
import java.util.*
val br = System.`in`.bufferedReader()

fun bfs(start : Int, edge : IntArray, visited : BooleanArray) : Int{
    val q : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    q.add(Pair(start,0))
    visited[start]=true
    while(q.isNotEmpty()){
        val cur = q.poll()
        for(i in 1 .. 6){
            val next = if(edge[cur.first+i]==0) cur.first+i else edge[cur.first+i]
            if(next>=100) return cur.second+1
            if(visited[next]) continue
            visited[next] =true
            q.add(Pair(next,cur.second+1))
        }
    }
    return -1
}

fun main() = with(System.out.bufferedWriter()){
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val edge = IntArray(101)
    for(i in 0 until n+m){
        val tk = StringTokenizer(br.readLine())
        val from = tk.nextToken().toInt()
        val to = tk.nextToken().toInt()
        edge[from] = to
    }
    write("${bfs(1,edge, BooleanArray(101))}")
    close()
}
