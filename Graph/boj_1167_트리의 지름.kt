//https://www.acmicpc.net/problem/1167
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var end =0
var answer=0
fun dfs(edge : Array<ArrayList<Distance>>, visited : BooleanArray, node : Int, dis : Int){
    visited[node]=true
    if(answer <dis){
        answer = dis
        end = node
    }

    for( i in 0 until edge[node].size){
        val nextDis = dis + edge[node][i].dis
        val next = edge[node][i].node
        if(visited[next])continue
        dfs(edge,visited,next,nextDis)
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val V = Integer.parseInt(br.readLine())
    val edge = Array(V+1,{ArrayList<Distance>()})
    var visited = BooleanArray(V+1,{false})
    for( i in 0 until V){
        val tk =StringTokenizer(br.readLine())
        val node =Integer.parseInt(tk.nextToken())
        while(true){
            val to = Integer.parseInt(tk.nextToken())
            if(to ==-1)break
            val dis = Integer.parseInt(tk.nextToken())
            edge[node].add(Distance(to,dis))
        }
    }
    dfs(edge,visited,1,0)
    visited = BooleanArray(V+1,{false})
    dfs(edge,visited,end,0)
    write("$answer")
    close()
}
data class Distance(val node :Int, val dis : Int)
