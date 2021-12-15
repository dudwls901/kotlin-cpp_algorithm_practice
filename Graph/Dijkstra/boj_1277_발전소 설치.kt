//https://www.acmicpc.net/problem/1277
import kotlin.math.*
import java.util.*

fun dijkstra(n : Int, limit : Double, graph : Array<Pair<Long,Long>>, connected : Array<BooleanArray>, visited : DoubleArray) : Long{

    val pq = PriorityQueue<Pair<Double,Int>>(kotlin.Comparator {a, b ->
        when{
            a.first < b.first -> -1
            a.first == b.first -> 0
            else -> 1
        }

    })
    pq.add(Pair(.0,0))
    visited[0]=.0
    while(pq.isNotEmpty()){
        val cur = pq.poll()
        //이미 최소값으로 갱신되어있다면 스킵
        if(visited[cur.second]<cur.first) continue
        //모든 정점에 대한 거리 삽입
        for(i in 0 until n){
            //본인에서 본인으로 가는 경우는 스킵
            if(i==cur.second)continue
            var nextDis = sqrt(
                ((graph[i].first - graph[cur.second].first)*(graph[i].first - graph[cur.second].first)+
                        (graph[i].second - graph[cur.second].second)*(graph[i].second - graph[cur.second].second)).toDouble()
            )
            //문제에서 주어진 연결되어있는 발전소는 가중치 0
            if(connected[cur.second][i]) nextDis=.0
            //visited에는 초기값으로 Long.MAX_VALUE들어있음
            //따라서 문제에서 주어진 연결되어있는 발전소는 한 번만 탐색하고 이후로는 탐색 x
            if(visited[i]<=cur.first+nextDis) continue
            
            //제한 길이를 넘으면 스킵
            if(nextDis>limit) continue
            
            pq.add(Pair(cur.first+nextDis,i))
            visited[i]=cur.first+nextDis
        }
    }
    //Long으로 변환하면서 자동으로 floor
    return (visited[n-1]*1000).toLong()
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,w) = br.readLine().split(' ').map{it.toInt()}
    val limit = br.readLine().toDouble()
    val graph = Array(n){Pair(0L,0L)}
    val connected = Array(n){BooleanArray(n)}
    for(i in 0 until n){
        val (x,y) = br.readLine().split(' ').map{it.toLong()}
        graph[i] = Pair(x,y)
    }
    for(i in 0 until w){
        val (from, to) = br.readLine().split(' ').map{it.toInt()}
        connected[from-1][to-1] = true
        connected[to-1][from-1]=true
    }
    
    //두 점 사이의 거리는 Int 범위를 벗어나지 않음
    val visited = DoubleArray(n){Int.MAX_VALUE.toDouble()}
    write("${dijkstra(n,limit,graph,connected,visited)}")
    close()
}
