//https://www.acmicpc.net/problem/2468
import kotlin.math.*
import java.util.*

val dirXY = arrayOf(arrayOf(0,1),arrayOf(1,0),arrayOf(0,-1),arrayOf(-1,0))

fun bfs(i : Int, j : Int, n : Int, high : Int , graph: Array<List<Int>>, visited : Array<BooleanArray> ){
    val q : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    q.add(Pair(i,j))
    visited[i][j]=true

    while(q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0 until 4) {
            val nR = cur.first+dirXY[i][0]
            val nC = cur.second+dirXY[i][1]
            if(nR !in 0 until n || nC !in 0 until n) continue
            if(visited[nR][nC] || graph[nR][nC] <=high) continue
            q.add(Pair(nR,nC))
            visited[nR][nC]=true
        }
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var maxHigh=0
    var answer=1
    val graph = Array(n){
         br.readLine().split(' ').map{
            val high=it.toInt()
            maxHigh=max(maxHigh,high)
            high
        }
    }

    for(high in 1 until maxHigh){
        val visited = Array(n){BooleanArray(n)}
        var count=0
        for(i in 0 until n){
            for(j in 0 until n){
                if(visited[i][j]) continue
                if(graph[i][j]<=high) continue
                bfs(i,j,n,high,graph,visited)
                count++
            }
        }
        answer= max(answer,count)
    }
    write("$answer")
    close()
}
