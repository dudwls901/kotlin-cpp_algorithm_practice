//https://www.acmicpc.net/problem/22865
import kotlin.math.*
import java.util.*

val INF = 987654321

//1<=n<=100000 정점 갯수
//n-1<=m<=500000 간선 갯수
//1<=a,b,c,d,e,<=n 정점들
//1<=l<=10000 도로 길이
//a,b,c에서 다익스트라 총 3번
//이후 같은 칸에서 a,b,c중 최솟값들을 뽑아서 최댓갑 출력

val friends = Array(3){IntArray(100001){INF}}
val edge = Array(100001){ArrayList<Pair<Int,Int>>()}

fun dijkstra(start : Int,friendNum  : Int){
    val pq = PriorityQueue<Pair<Int,Int>>(kotlin.Comparator { a, b ->
        when{
            a.second < b.second -> -1
            a.second == b.second -> 0
            else -> 1
        }
    })
    pq.add(Pair(start,0))
    friends[friendNum][0]=0
    while(pq.isNotEmpty()){
        val cur = pq.poll()

        if(friends[friendNum][cur.first]< cur.second) continue

        for(next in edge[cur.first]){
            val nextDis = cur.second + next.second
            if(friends[friendNum][next.first]> nextDis){
                pq.add(Pair(next.first,nextDis))
                friends[friendNum][next.first] = nextDis
            }
        }
    }

}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val friendPos = br.readLine().split(' ').map{it.toInt()}
    val m = br.readLine().toInt()
    for(i in 0 until m){
        val (from, to, dis) = br.readLine().split(' ').map{it.toInt()}
        edge[from].add(Pair(to,dis))
        edge[to].add(Pair(from,dis))
    }
    for(i in friendPos.indices){
        dijkstra(friendPos[i],i)
    }
    var maxDis=Pair(0,0)
    for(i in 1 .. n){
        var dis=INF
        for(j in 0 until 3){
            dis = min(friends[j][i],dis)
        }
        if(maxDis.first < dis){
            maxDis = Pair(dis,i)
        }
    }
    write("${maxDis.second}")

    close()
}
