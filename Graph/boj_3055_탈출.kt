//https://www.acmicpc.net/problem/3055
import java.util.*

val dirXY = arrayOf(arrayOf(0,1),arrayOf(0,-1),arrayOf(1,0),arrayOf(-1,0))
val br = System.`in`.bufferedReader()

fun bfs(start : Pair<Int,Int>, water : ArrayList<Pair<Int,Int>>, n : Int, m : Int, graph : Array<CharArray>) : Int{
    val visited =Array(n){BooleanArray(m)}
    val me : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    val enemy : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    visited[start.first][start.second] =true
    me.add(Pair(start.first,start.second))
    for(i in water){
        enemy.add(Pair(i.first,i.second))
    }
    var answer=0
    while(me.isNotEmpty()){
        val meSize = me.size
        val enemySize = enemy.size
        answer++
        if(water.isNotEmpty()) {
            for (i in 0 until enemySize) {
                val curEnemy = enemy.poll()
                for (i in 0 until 4) {
                    val nr = curEnemy.first + dirXY[i][0]
                    val nc = curEnemy.second + dirXY[i][1]
                    if (nr !in 0 until n || nc !in 0 until m) continue
                    if (graph[nr][nc] == '.') {
                        enemy.add(Pair(nr, nc))
                        graph[nr][nc] = '*'
                    }
                }
            }
        }
        for(i in 0 until meSize){
            val curMe = me.poll()
            for(i in 0 until 4){
                val nr = curMe.first + dirXY[i][0]
                val nc = curMe.second + dirXY[i][1]
                if(nr !in 0 until n || nc !in 0 until m) continue
                if(graph[nr][nc]=='D') return answer
                if(visited[nr][nc])continue
                if(graph[nr][nc]=='.'){
                    visited[nr][nc]=true
                    me.add(Pair(nr,nc))
                }
            }
        }
    }
    return 0
}

fun main() =with(System.out.bufferedWriter()){

    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(n){br.readLine().toCharArray()}
    var start=Pair(0,0)
    var water=ArrayList<Pair<Int,Int>>()
    for(i in 0 until n){
        for(j in 0 until m){
            if(graph[i][j]=='S') start=Pair(i,j)
            if(graph[i][j]=='*') water.add(Pair(i,j))
        }
    }
    var answer= bfs(start,water,n,m,graph)
    if(answer==0) write("KAKTUS")else write("$answer")
    close()
}
