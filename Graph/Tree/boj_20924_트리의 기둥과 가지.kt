//https://www.acmicpc.net/problem/20924
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }

lateinit var edge: Array<ArrayList<Pair<Int,Int>>>
var rootLen = 0
var branchLen = 0
var isRoot = true
lateinit var visited: BooleanArray
lateinit var outDegree: IntArray
fun dfs(cur: Int, dis: Int) {
    var curDis = dis
    visited[cur] = true
    if(isRoot) rootLen = rootLen.coerceAtLeast(dis)
    else branchLen = branchLen.coerceAtLeast(dis)
    if(outDegree[cur] >= 2 && isRoot){
        isRoot = false
        curDis = 0
    }
    for (next in edge[cur]) {
        if (visited[next.first]) continue
        dfs(next.first, next.second + curDis)
    }
}

fun makeDegree(cur: Int, visited: BooleanArray){
    visited[cur] = true
    var cnt = 0
    for(next in edge[cur]){
        if(visited[next.first]) continue
        makeDegree(next.first,visited)
        cnt++
    }
    outDegree[cur] = cnt
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, root) = getIntList()
    edge = Array(n+1){ ArrayList() }
    visited = BooleanArray(n+1)
    outDegree = IntArray(n+1)
    repeat(n-1) {
        val (from,to, dis) = getIntList()
        edge[from].add(Pair(to,dis))
        edge[to].add(Pair(from,dis))
    }
    //solve
    makeDegree(root,BooleanArray(n+1))
    dfs(root,0)
    //output
    write("$rootLen $branchLen")
    close()
}
