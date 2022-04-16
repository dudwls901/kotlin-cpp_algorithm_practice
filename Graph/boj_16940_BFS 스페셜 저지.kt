//https://www.acmicpc.net/problem/16940
import java.util.*
val br = System.`in`.bufferedReader()
lateinit var edge: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var order:List<Int>

fun bfs(n: Int): Int{
    val q: Queue<Int> =  LinkedList()
    q.add(1)
    var idx=1
    if(order[0]!=1) return 0
    while(q.isNotEmpty()){
        val size = q.size
        val numSet = BooleanArray(n+1)
        for(i in 0 until size){
            val cur = q.poll()
            for(next in edge[cur]){
                if(visited[next]) continue
                numSet[next] = true
                visited[next] =true
                q.add(next)
            }
        }
        while(idx<n){
            if(numSet[order[idx]]) idx++
            else break
        }
    }
    if(idx==n) return 1
    return 0
}

fun main() = with(System.out.bufferedWriter()){

    //input
    val n = br.readLine().toInt()
    visited = BooleanArray(n+1)
    edge = Array(n+1){ArrayList()}
    repeat(n-1){
        br.readLine().split(' ').map{it.toInt()}.apply {
            edge[this[0]].add(this[1])
            edge[this[1]].add(this[0])
        }
    }
    order = br.readLine().split(' ').map{it.toInt()}

    //solve
    write("${bfs(n)}")
    //output

    close()
}
