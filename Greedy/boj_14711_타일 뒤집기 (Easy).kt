//https://www.acmicpc.net/problem/14711
val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    val graph = Array(n){CharArray(n)}
    val visited = Array(n){IntArray(n)}
    graph[0] = br.readLine().toCharArray()
    write("${graph[0].joinToString("")}\n")

    for(i in 0 until n-1){
        for(j in 0 until n){
            if(graph[i][j]=='#'){
                if(j-1>=0) visited[i][j-1]++
                if(j+1<n) visited[i][j+1]++
                visited[i+1][j]++
                visited[i][j]++
            }
        }
        for(j in 0 until n){
            graph[i+1][j] = if(visited[i][j]%2==0) graph[i][j] else{
                if(graph[i][j]=='#') '.'
                else '#'
            }
            write("${graph[i+1][j]}")
        }
        write("\n")
    }
    close()
}
