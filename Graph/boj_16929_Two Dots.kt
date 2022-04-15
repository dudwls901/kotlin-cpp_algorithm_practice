//https://www.acmicpc.net/problem/16929
val br = System.`in`.bufferedReader()

lateinit var visited: Array<IntArray>
lateinit var graph: Array<String>
val dir = arrayOf(
    arrayOf(0,1),
    arrayOf(1,0),
    arrayOf(0,-1),
    arrayOf(-1,0)
)
var answer=  false

fun dfs(depth: Int, r: Int, c: Int,n: Int,m: Int){
    visited[r][c] = depth
    for(i in 0 until 4){
        val nr = r + dir[i][0]
        val nc = c + dir[i][1]
        if(nr !in 0 until n || nc !in 0 until m) continue
        if(graph[nr][nc] != graph[r][c]) continue
        if(visited[nr][nc]<0){
            dfs(depth+1, nr, nc, n, m )
        }
        else{
            if(visited[r][c]-visited[nr][nc]>=3){
                answer = true
                return
            }
        }
    }
}

fun main() = with(System.out.bufferedWriter()){

    //input
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    visited= Array(n){ IntArray(m){-1} }
    graph = Array(n){br.readLine()}

    //solve
    label@for(r in 0 until n){
        for(c in 0 until m){
            if(visited[r][c]==-1){
                dfs(0,r,c,n,m)
                if(answer) break@label
            }
        }
    }
    write(if(answer) "Yes" else "No")

    close()
}
