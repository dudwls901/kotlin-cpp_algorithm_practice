//https://www.acmicpc.net/problem/1987
val br = System.`in`.bufferedReader()
val dirXY = arrayOf(arrayOf(0,1),arrayOf(0,-1),arrayOf(1,0),arrayOf(-1,0))
var answer=0
val visited = BooleanArray(26)
fun dfs(r : Int, c: Int, cnt : Int, R: Int, C : Int, graph : Array<String>){

    answer = answer.coerceAtLeast(cnt)

    for(i in 0 until 4){
        val nr = r+dirXY[i][0]
        val nc = c+dirXY[i][1]
        if(nr !in 0 until R || nc !in 0 until C) continue
        if(visited[graph[nr][nc]-'A'])continue
        visited[graph[nr][nc]-'A']=true
        dfs(nr,nc,cnt+1,R,C,graph)
        visited[graph[nr][nc]-'A']=false
    }
}

fun main() = with(System.out.bufferedWriter()){
    val (r,c) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(r){br.readLine()}
    visited[graph[0][0]-'A']=true
    dfs(0,0,1,r,c,graph)
    write("$answer")
    close()
}
