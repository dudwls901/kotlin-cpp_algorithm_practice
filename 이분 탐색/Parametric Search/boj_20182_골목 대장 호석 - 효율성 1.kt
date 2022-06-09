//https://www.acmicpc.net/problem/20182
import java.util.*
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

data class Node(
    val num: Int,
    val cost: Int,
    val sumCost: Int,
    val maxCost: Int
)
lateinit var edge: Array<ArrayList<Pair<Int,Int>>>

fun bfs(a: Int,b: Int,c: Int, search: Int, visited: BooleanArray) : Boolean{
    val q = PriorityQueue<Node>{ a,b ->
        when{
            a.cost < b.cost -> -1
            a.cost == b.cost -> 0
            else -> 1
        }
    }
    q.add(Node(a,0,0,0))
    visited[a] = true
    while(q.isNotEmpty()){
        val cur = q.poll()
        for(next in edge[cur.num]){
            if(visited[next.first]) continue
            val nextSumCost = cur.sumCost + next.second
            val nextMaxCost = cur.maxCost.coerceAtLeast(next.second)
            if(nextSumCost > c || nextMaxCost > search) continue
            if(next.first == b) return true
            q.add(Node(next.first, next.second, nextSumCost, nextMaxCost))
            visited[next.first] = true
        }
    }
    return false
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val (n,m,a,b,c) = getIntList()
    edge = Array(n+1){ ArrayList() }
    repeat(m){
        val (from, to, cost ) = getIntList()
        edge[from].add(Pair(to,cost))
        edge[to].add(Pair(from,cost))
    }
    //solve
    var s = 1
    var e = 20
    var mid = 0
    var answer = Int.MAX_VALUE
    while(s<=e){
        //가능하다면 mid를 줄여보기
        mid = (s+e)/2
        if(bfs(a,b,c,mid, BooleanArray(n+1))){
            answer = answer.coerceAtMost(mid)
            e = mid - 1
        }
        else{
            s = mid + 1
        }
    }
    //output
    if(answer==Int.MAX_VALUE) write("-1")
    else write("$answer")

    close()
}
