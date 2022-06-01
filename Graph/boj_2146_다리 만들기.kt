//https://www.acmicpc.net/problem/2146
//1
import kotlin.math.*
import java.util.*

val dirXY = arrayOf(arrayOf(0,1),arrayOf(0,-1),arrayOf(1,0),arrayOf(-1,0))
val INF = 987654321
val br = System.`in`.bufferedReader()
data class Node(var r : Int, var c : Int,var num : Int, var dis : Int)
var answer = INF
val q : Queue<Node> = LinkedList<Node>()
fun bfs(n : Int, graph : Array<IntArray>){
    val dp = Array(n){IntArray(n)}
    while(q.isNotEmpty()){
        val qSize = q.size
        for(i in 0 until qSize) {
            val cur = q.poll()
            for (j in 0 until 4) {
                val nr = cur.r + dirXY[j][0]
                val nc = cur.c + dirXY[j][1]
                if (nr !in 0 until n || nc !in 0 until n) continue
                if (graph[nr][nc] != cur.num && graph[nr][nc] != 0){
                    answer = min(answer,cur.dis+dp[nr][nc])
                }
                if (graph[nr][nc] == 0) {
                    q.add(Node(nr, nc, cur.num, cur.dis + 1))
                    dp[nr][nc] = cur.dis + 1
                    graph[nr][nc] = cur.num
                }
            }
        }
        if(answer!=INF) return
    }

}
fun numbering(i : Int, j : Int,num : Int,n : Int, graph : Array<IntArray>, visited : Array<BooleanArray>){
    val qq : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    graph[i][j]=num
    visited[i][j]=true
    qq.add(Pair(i,j))

    while(qq.isNotEmpty()){
        val cur = qq.poll()
        for(i in 0 until 4){
            val nr = cur.first+dirXY[i][0]
            val nc = cur.second+dirXY[i][1]
            if(nr !in 0 until n || nc !in 0 until n) continue
            if(graph[nr][nc]==0 || visited[nr][nc])continue
            graph[nr][nc]=num
            visited[nr][nc]=true
            qq.add(Pair(nr,nc))
            q.add(Node(nr,nc,num,0))
        }
    }

}

fun main() = with(System.out.bufferedWriter()){
    val n = br.readLine().toInt()
    val graph = Array(n){
        br.readLine().split(' ').map{it.toInt()}.toIntArray()
    }
    var num=1
    val visited= Array(n){BooleanArray(n)}
    for(i in 0 until n){
        for(j in 0 until n){
            if(visited[i][j] || graph[i][j]==0) continue
            q.add(Node(i,j,num,0))
            numbering(i,j,num++,n,graph,visited)
        }
    }
    bfs(n,graph)
    write("$answer")

    close()
}
//2
// import java.util.*
// val br = System.`in`.bufferedReader()

// fun getIntList() = br.readLine().split(' ').map { it.toInt() }
// fun getInt() = br.readLine().toInt()


// data class Node(
//     val r: Int,
//     val c: Int,
//     val dis: Int
// )
// lateinit var graph: Array<IntArray>
// lateinit var visited: Array<BooleanArray>
// var answer = Int.MAX_VALUE
// val dir = arrayOf(
//     arrayOf(0,1),
//     arrayOf(1,0),
//     arrayOf(0,-1),
//     arrayOf(-1,0)
// )

// fun bfs(r: Int, c: Int, n: Int, num: Int, type: String){
//     if(type=="preSet") {
//         val q: Queue<Pair<Int, Int>> = LinkedList()

//         q.add(Pair(r, c))
//         graph[r][c] = num

//         while (q.isNotEmpty()) {
//             val (cr, cc) = q.poll()
//             for (i in 0 until 4) {
//                 val nr = cr + dir[i][0]
//                 val nc = cc + dir[i][1]
//                 if (nr !in 0 until n || nc !in 0 until n) continue
//                 if (graph[nr][nc] == 1) {
//                     q.add(Pair(nr, nc))
//                     graph[nr][nc] = num
//                 }
//             }
//         }
//     }
//     else{
//         val q: Queue<Node> = LinkedList()
//         q.add(Node(r,c,0))
//         visited[r][c] = true

//         while(q.isNotEmpty()){
//             val (cr, cc, cDis) = q.poll()

//             for(i in 0 until 4){
//                 val nr = cr + dir[i][0]
//                 val nc = cc + dir[i][1]
//                 if(nr !in 0 until n || nc !in 0 until n) continue
//                 if(visited[nr][nc]) continue
//                 if(graph[nr][nc] == num) continue
//                 if(graph[nr][nc] == 0){
//                     q.add(Node(nr,nc,cDis+1))
//                     visited[nr][nc] = true
//                 }
//                 else{
//                     answer = answer.coerceAtMost(cDis)
//                     return
//                 }
//             }
//         }
//     }
// }


// fun main() = with(System.out.bufferedWriter()){

//     //input
//     val n = getInt()
//     graph = Array(n){ getIntList().toIntArray() }

//     //solve
//     var num =2
//     for(i in 0 until n){
//         for(j in 0 until n){
//             if(graph[i][j] == 1) {
//                 bfs(i,j,n,num++, "preSet")
//             }
//         }
//     }
//     for(i in 0 until n){
//         for(j in 0 until n){
//             if(graph[i][j]!=0) {
//                 visited = Array(n) { BooleanArray(n)}
//                 bfs(i,j,n,graph[i][j],"solve")
//             }
//         }
//     }
//     //output
//     write("$answer")
//     close()
// }
