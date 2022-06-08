//https://www.acmicpc.net/problem/11779
import java.util.*
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

data class Node(
    val num: Int,
    val dis: Long
)

lateinit var edge: Array<ArrayList<Pair<Int,Int>>>
lateinit var dp: LongArray
lateinit var before: IntArray
var answer = Node(0,0)
fun dijkstra(n: Int, m: Int, s: Int, e: Int){
    val pq = PriorityQueue<Node>{a,b ->
        when {
            a.dis < b.dis -> -1
            a.dis == b.dis -> 0
            else -> 1
        }
    }
    pq.add (Node(s,0))
    dp[s] = 0
    while(pq.isNotEmpty()){
        val cur = pq.poll()

        if(dp[cur.num] < cur.dis) continue

        for(next in edge[cur.num]){
            val nextDis = cur.dis + next.second
            if(dp[next.first] <= nextDis) continue
            dp[next.first] = nextDis
            before[next.first]  = cur.num
            pq.add(Node(next.first, nextDis))
        }
    }
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    val m = getInt()
    edge = Array(n+1){ ArrayList() }
    dp = LongArray(n+1){Long.MAX_VALUE}
    before = IntArray(n+1)
    repeat(m){
        val (from, to, dis) = getIntList()
        edge[from].add(Pair(to,dis))
    }
    val (s,e) = getIntList()

    //solve
    dijkstra(n,m,s,e)
    val arr = ArrayList<Int>()
    arr.add(e)
    var num = before[e]
    while(num>0){
        arr.add(num)
        num = before[num]
    }
    write("${dp[e]}\n")
    write("${arr.size}\n")
    for(i in arr.size-1 downTo 0){
        write("${arr[i]} ")
    }

    close()
}
