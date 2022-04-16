//https://www.acmicpc.net/problem/16964
import java.util.*

val br = System.`in`.bufferedReader()

lateinit var edge: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var originOrder: IntArray
lateinit var order: IntArray
var answer= 1
var idx=0
fun dfs(cur: Int, n: Int) {
    if(answer==0) return

    if(originOrder[idx++]!=cur){
        answer = 0
        return
    }

    for(next in edge[cur]){
        if(visited[next]) continue
        visited[next] = true
        dfs(next, n)
    }
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val n = br.readLine().toInt()
    visited = BooleanArray(n + 1)
    edge = Array(n + 1) { ArrayList() }
    repeat(n - 1) {
        br.readLine().split(' ').map { it.toInt() }.apply {
            edge[this[0]].add(this[1])
            edge[this[1]].add(this[0])
        }
    }
    val tk = StringTokenizer(br.readLine())
    order = IntArray(n + 1)
    originOrder = IntArray(n)
    var j=0
    while(tk.hasMoreTokens()){
        val num =tk.nextToken().toInt()
        originOrder[j] = num
        order[num]= j++
    }

    //solve
    //sort
    for (i in 1..n) {
        edge[i].sortWith { a, b ->
            when {
                order[a] < order[b] -> -1
                else -> 1
            }
        }
    }
    visited[1] = true
    dfs(1,n)
    // output
    write("$answer")

    close()
}
