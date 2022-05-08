//https://www.acmicpc.net/problem/10217
import java.util.*

val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

data class Node(
    val cur: Int,
    val cost: Int,
    val dis: Int
)

var T = 0
lateinit var edge: Array<ArrayList<Node>>
lateinit var dp: Array<IntArray>
//n 2  100 공항 수
//m 0 10000 총 지원 비용
//k 0  10000 티켓 정보
//1출발 n도착

fun dijkstra(n: Int, m: Int){

    val pq = PriorityQueue<Node>(Comparator { a, b ->
        when{
            a.dis < b.dis -> -1
            a.dis == b.dis -> 0
            else -> 1
        }
    })

    pq.add(Node(1,0,0))

    while(pq.isNotEmpty()){
        val cur = pq.poll()
        if(dp[cur.cost][cur.cur] < cur.dis) continue

        for(ne in edge[cur.cur]){
            val nextDis = cur.dis+ne.dis
            val next = ne.cur
            val nextCost = cur.cost+ne.cost

            if(nextCost > m) continue
            if(dp[nextCost][next]<= nextDis) continue

            dp[nextCost][next] = nextDis

            if(next == n) continue
            pq.add(Node(next, nextCost, nextDis))

        }
    }


}

fun main() = with(System.out.bufferedWriter()) {

    T = getInt()
    for (t in 1..T) {
        //input
        val (n, m, k) = getIntList()
        edge = Array(n + 1) { ArrayList() }
        dp = Array(m+1) { IntArray(n+1){Int.MAX_VALUE} }
        for (i in 0 until k) {
            val (from, to, cost, dis) = getIntList()
            edge[from].add(Node(to, cost, dis))
        }
        
        //solve
        dijkstra(n,m)

        //output
        var answer=Int.MAX_VALUE
        for(i in dp.indices){
//            println(dp[i][n])
            answer = answer.coerceAtMost(dp[i][n])
        }
        write("${if(answer==Int.MAX_VALUE) "Poor KCM" else answer }\n")
    }

    close()
}
