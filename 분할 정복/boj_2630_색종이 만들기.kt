//https://www.acmicpc.net/problem/2630
var answer= arrayOf(0,0)

fun dfs(r : Int, c : Int, size : Int, graph : Array<IntArray>){
    var zero = true
    var one = true

    for(i in r until r+size){
        for(j in c until c+size){
            if(graph[i][j]==0) one=false
            else zero =false
        }
    }
    if(zero){
        answer[0]++
        return
    }
    if(one){
        answer[1]++
        return
    }
    dfs(r,c,size/2,graph)
    dfs(r,c+size/2,size/2,graph)
    dfs(r+size/2,c,size/2,graph)
    dfs(r+size/2,c+size/2,size/2,graph)
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val graph = Array(n){br.readLine().split(' ').map{it.toInt()}.toIntArray()}

    dfs(0,0,n,graph)
    write("${answer[0]}\n${answer[1]}")
    close()
}
