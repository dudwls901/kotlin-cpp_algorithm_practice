//https://www.acmicpc.net/problem/18223
//1
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()


data class Node(
    val num: Int,
    val dis: Int,
    val meet: Boolean = false
)
lateinit var edge: Array<ArrayList<Pair<Int,Int>>>

fun dijkstra(v: Int, p: Int): String{
    val visited = Array(v+1){Int.MAX_VALUE}
    val pq = PriorityQueue<Node>{a,b ->
        a.dis-b.dis
    }
    pq.add(Node(1,0, p==1))
    visited[1] = 0
    while(pq.isNotEmpty()){
        val (cNum, cDis, cMeet) = pq.poll()
        if(cNum == v && cMeet) return "SAVE HIM"
        if(visited[cNum] < cDis ) continue
        for(i in edge[cNum].indices){
            val (nNum, nDis) = edge[cNum][i]
            if(visited[nNum] < cDis + nDis) continue
            val nMeet = if(nNum == p) true else cMeet
            visited[nNum] = cDis + nDis
            pq.add(Node(nNum, cDis + nDis,nMeet))
        }
    }
    return "GOOD BYE"
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val (v,e,p) = getIntList()
    edge = Array(v+1){ ArrayList() }
    repeat(e){
        val (from, to, dis) = getIntList()
        edge[from].add(Pair(to,dis))
        edge[to].add(Pair(from,dis))
    }
    //solve
    write(dijkstra(v,p))
    close()
}
//2
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

lateinit var edge: Array<ArrayList<Pair<Int,Int>>>

fun dijkstra(s: Int, e: Int): IntArray{
    val pq = PriorityQueue<Pair<Int,Int>>{a,b -> a.second - b.second}
    val dp = IntArray(e+1){Int.MAX_VALUE}
    pq.add(Pair(s,0))
    dp[s] = 0
    while(pq.isNotEmpty()){
        val (cNum,cDis) = pq.poll()
        if(dp[cNum] < cDis) continue
        for(next in edge[cNum]){
            val (nNum, nDis) = next
            if(dp[nNum] <= cDis + nDis) continue
            dp[nNum] = cDis+nDis
            pq.add(Pair(nNum,cDis+nDis))
        }
    }
    return dp
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val (v,e,p) = getIntList()
    edge = Array(v+1){ ArrayList() }
    repeat(e){
        val (from, to, dis) = getIntList()
        edge[from].add(Pair(to,dis))
        edge[to].add(Pair(from,dis))
    }
    //solve
    val dis1 = dijkstra(1,v)
    val dis2 = dijkstra(p,v)
    write(if(dis1[v] >= dis1[p] + dis2[v]) "SAVE HIM" else "GOOD BYE")
    close()
}
