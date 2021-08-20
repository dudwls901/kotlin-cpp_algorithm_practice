//https://www.acmicpc.net/problem/1238
import java.util.*
import kotlin.math.*

//1<=n<=1000
//1<=m<=10000
//단방향 그래프
const val INF = 987654321

fun dijkstra(graph : Array<ArrayList<Pair<Int,Int>>>,start : Int, dp : IntArray){
    val pq = PriorityQueue<Pair<Int,Int>>{a,b ->
        when{
            a.first<b.first -> -1
            a.first==b.first ->0
            else -> 1
        }
    }
    pq.add(Pair(0,start))

    while(pq.isNotEmpty()){
        val (dis,cur) = pq.poll()
        if(dp[cur]<dis)continue
        for(i in graph[cur].indices){
            val next = graph[cur][i].first
            val nextDis = dis + graph[cur][i].second
            if(dp[next]<nextDis)continue
            dp[next]=nextDis
            pq.add(Pair(nextDis,next))
        }
    }
}

fun main()= with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var tk = StringTokenizer(br.readLine())
    val (n,m,k) = List(3){Integer.parseInt(tk.nextToken())}
    val graph = Array(n+1){ArrayList<Pair<Int,Int>>()}
    val reverseGraph = Array(n+1){ArrayList<Pair<Int,Int>>()}
    val dp = IntArray(n+1){INF}
    val reverseDp = IntArray(n+1){INF}
    var answer =0
    for(i in 0 until m){
        tk = StringTokenizer(br.readLine())
        val (from, to, dis) = List(3){Integer.parseInt(tk.nextToken())}
        graph[from].add(Pair(to,dis))
        reverseGraph[to].add(Pair(from,dis))
    }
    //k에서 각 마을로 가는 최단 경로
    dijkstra(graph,k,dp)
    //각 마을에서 k까지 가는 최단 경로
    dijkstra(reverseGraph,k,reverseDp)
    for(i in 1 .. n) {
        if(i==k)continue
        answer = max(answer, dp[i]+reverseDp[i])
    }
    write("$answer")
    close()
}
