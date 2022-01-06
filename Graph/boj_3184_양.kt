//https://www.acmicpc.net/problem/3184
import java.util.*
val dirXY = arrayOf(arrayOf(0,1),arrayOf(0,-1),arrayOf(1,0),arrayOf(-1,0))
val br = System.`in`.bufferedReader()

//3<= r,c <=250
val visited = Array(250){BooleanArray(250)}

fun bfs(i : Int, j : Int, r : Int, c : Int, graph : Array<String>) : Pair<Int,Int>{
    var sheep = 0
    var wolf = 0
    var q : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    q.add(Pair(i,j))
    visited[i][j]=true
    if(graph[i][j]=='o'){
        sheep++
    }
    else if(graph[i][j]=='v'){
        wolf++
    }
    while(q.isNotEmpty()){
        val cur = q.poll()

        for(dir in 0 until 4){
            val nr = cur.first + dirXY[dir][0]
            val nc = cur.second + dirXY[dir][1]
            if(nr !in 0 until r || nc !in 0 until c) continue
            if(visited[nr][nc]) continue
            if(graph[nr][nc]=='#') continue
            else if(graph[nr][nc]=='o'){
                sheep++
            }
            else if(graph[nr][nc]=='v'){
                wolf++
            }
            visited[nr][nc]=true
            q.add(Pair(nr,nc))
        }
    }
    if(sheep > wolf){
        wolf=0
    }
    else{
        sheep=0
    }

    return Pair(sheep,wolf)
}

fun main() = with(System.out.bufferedWriter()){

    val (r,c) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(r){br.readLine()}
    var sheep = 0
    var wolf = 0
    for(i in 0 until r){
        for(j in 0 until c){
            if(visited[i][j]) continue
            if(graph[i][j]=='#') continue
            var result = bfs(i,j,r,c,graph)
            sheep+=result.first
            wolf+=result.second
        }
    }

    write("$sheep $wolf")
    close()
}
