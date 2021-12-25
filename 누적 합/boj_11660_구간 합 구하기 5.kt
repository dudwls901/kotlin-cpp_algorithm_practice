//https://www.acmicpc.net/problem/11660
import java.util.*
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(n+1){IntArray(n+1)}
    for(r in 1 .. n){
        val tk = StringTokenizer(br.readLine())
        for(c in 0 until n){
            graph[r][c+1] = tk.nextToken().toInt()+graph[r-1][c+1]+graph[r][c]-graph[r-1][c]
        }
    }

    for(i in 0 until m){
        val (x1,y1,x2,y2) = br.readLine().split(' ').map{it.toInt()}
        write("${graph[x2][y2]-graph[x2][y1-1]-graph[x1-1][y2]+graph[x1-1][y1-1]}\n")
    }
    close()
}
