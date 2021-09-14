//https://www.acmicpc.net/problem/22870
import kotlin.math.*
import java.util.*
val used = BooleanArray(200001)

fun dijkstra(graph: Array<ArrayList<Pair<Int,Int>>>, s : Int) : IntArray{
    val dp = IntArray(graph.size){987654321}
    val pq = PriorityQueue<Pair<Int,Int>>(Comparator{a,b -> when{
        a.second <b.second -> -1
        a.second ==b.second -> 0
        else -> 1
    }})
    pq.add(Pair(s,0))
    dp[s]=0
    while(pq.isNotEmpty()){

        val (cur,curDis) = pq.poll()
        if(dp[cur] != curDis) continue
        for(i in graph[cur].indices){
            val next = graph[cur][i].first
            val nextDis = curDis+graph[cur][i].second
            if(used[next]) continue
            if(dp[next]>nextDis) {
                dp[next] = nextDis
                pq.add(Pair(next, nextDis))
            }
        }
    }

    return dp
}

fun eraseEdge(distS : IntArray, distE : IntArray, graph : Array<ArrayList<Pair<Int,Int>>>,start : Int, e : Int){

    var pre =start
    var s = start
    while(s!=e){
        var minNode = 987654321

        for (i in graph[s].indices) {
            val (next,nextDis) = graph[s][i]
            if (next == pre) continue
            if(distS[s]+nextDis+distE[next]==distS[e]){
                minNode = min(minNode,next)
            }
        }
        if(s!=e){
            used[minNode]=true
        }
        pre =s
        s= minNode
    }


}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var tk = StringTokenizer(br.readLine())
    val (n,m) = List(2){Integer.parseInt(tk.nextToken())}
    val graph = Array<ArrayList<Pair<Int,Int>>>(n+1){ArrayList()}
    for(i in 0 until m){
        tk = StringTokenizer(br.readLine())
        val (from,to, dis) = List(3){Integer.parseInt(tk.nextToken())}
        graph[from].add(Pair(to,dis))
        graph[to].add(Pair(from,dis))
    }
    tk = StringTokenizer(br.readLine())
    val (s,e) = List(2){Integer.parseInt(tk.nextToken())}
    val distS = dijkstra(graph,s)
    var distE = dijkstra(graph,e)
    var answer : Long =distS[e].toLong()
    eraseEdge(distS,distE,graph,s,e)

    distE = dijkstra(graph,e)
    answer+=distE[s]
    write("$answer")
    close()
}
