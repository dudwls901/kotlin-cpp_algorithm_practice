//https://www.acmicpc.net/problem/5214
import java.util.*
fun bfs(graph : Array<MutableList<Int>>, visited : IntArray , n : Int) : Int{
    val q : Queue<Int> = LinkedList<Int>()
    q.add(1)
    visited[1]=1
    while(q.isNotEmpty()){
        val cur = q.poll()
        if(cur==n) return visited[cur]
        for(i in graph[cur].indices){
            val next = graph[cur][i]
            if(visited[next]>0) continue
            if(next == n){
                return visited[cur]+1
            }
            else if(next<n){
                visited[next] = visited[cur]+1
            }
            else{
                visited[next] = visited[cur]
            }
            q.add(next)
        }
    }
    return -1
}


fun main() = with(System.out.bufferedWriter()){
    val br= System.`in`.bufferedReader()
    var tk = StringTokenizer(br.readLine())
    val (n,k,m) = List(3){Integer.parseInt(tk.nextToken())}
//    val tube = Array(m+1,{IntArray(k,{0})})
    val graph = Array(200001,{mutableListOf<Int>()})
    val visited = IntArray(200001,{0})
    for(i in 1 .. m){
        tk = StringTokenizer(br.readLine())
        for(j in 0 until k){
            val num = Integer.parseInt(tk.nextToken())
            graph[num].add(n+i)
            graph[n+i].add(num)
        }
    }
    write("${bfs(graph,visited,n)}")
    close()
}
