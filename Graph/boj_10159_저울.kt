//https://www.acmicpc.net/problem/10159
val br = System.`in`.bufferedReader()
val visited = BooleanArray(101)
val edge = Array(101){ArrayList<Int>()}
val reverseEdge = Array(101){ArrayList<Int>()}
var cnt=0
fun dfs(cur : Int){
    visited[cur]=true
    cnt++
    for(next in edge[cur]){
        if(visited[next])continue
        dfs(next)
    }
}
fun reverseDfs(cur : Int){
    visited[cur]=true
    for(next in reverseEdge[cur]){
        if(visited[next])continue
        cnt++
        reverseDfs(next)
    }
}

fun main() = with(System.out.bufferedWriter()){
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    for(i in 0 until m){
        val (from, to) = br.readLine().split(' ').map{it.toInt()}
        edge[from].add(to)
        reverseEdge[to].add(from)
    }

    for(i in 1 .. n){
        cnt = 0
        for(j in 1..n){
            visited[j]=false
        }
        dfs(i)
        if(reverseEdge[i].isNotEmpty()){
            reverseDfs(i)
        }
        write("${n-cnt}\n")
    }
    close()
}
