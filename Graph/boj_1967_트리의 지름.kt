//https://www.acmicpc.net/submit/1967/32351478
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var answer =0
var end=0
fun dfs(graph : Array<ArrayList<NodeDis>>,visited : BooleanArray, start : Int, dis : Int ){
    visited[start] =true
    if(answer<dis){
        answer = dis
        end = start
    }

    for(i in graph[start].indices){
        val next =  graph[start][i].node
        val nextDis = dis + graph[start][i].dis
        if(visited[next]) continue
        dfs(graph,visited,next,nextDis)
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    var visited = BooleanArray(n+1,{false})
    val graph = Array(n+1,{ArrayList<NodeDis>()})
    for(i in 0 until n-1){
        val tk = StringTokenizer(br.readLine())
        val (from, to, dis) = List(3){Integer.parseInt(tk.nextToken())}
        graph[from].add(NodeDis(to,dis))
        graph[to].add(NodeDis(from,dis))
    }
    dfs(graph,visited,1,0)
    visited = BooleanArray(n+1,{false})
    dfs(graph,visited,end,0)
    write("$answer")
    close()
}
data class NodeDis(val node : Int, val dis : Int)
