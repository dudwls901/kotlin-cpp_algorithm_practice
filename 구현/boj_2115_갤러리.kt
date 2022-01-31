//https://www.acmicpc.net/problem/2115
import java.util.*

//상, 하 방향으로 이동시 전 칸의 좌 우 벽 값이 필요
//좌, 우 방향으로 이동시 전 칸의 상 하 벽 값잋 필요
var answer = 0
val dir = arrayOf(
    arrayOf(1,0),
    arrayOf(-1,0),
    arrayOf(0,1),
    arrayOf(0,-1)
)

data class Node(var r : Int, var c: Int)

fun findWall(i : Int, j : Int, graph : Array<CharArray>, visited : Array<Array<BooleanArray>>){

        val r=i
        val c=j
        //다음 . 과 현재 . 사이 그림 가능한지 확인
        for(i in 0 until 4){
            val nr = r+dir[i][0]
            val nc = c+dir[i][1]
            if(visited[nr][nc][i]) continue
            if(graph[nr][nc]=='.'){
                //그림 걸 수 있는지 검사
                //상하 이동 -> 좌우벽만 필요
                if(i<2){
                    //j :우좌
                    for(j in 2 until 4){
                        if(graph[r+dir[j][0]][c+dir[j][1]]=='X' && graph[nr+dir[j][0]][nc+dir[j][1]]=='X'){
                            if(visited[r+dir[j][0]][c+dir[j][1]][j] || visited[nr+dir[j][0]][nc+dir[j][1]][j]) continue
                            answer++
                            visited[r+dir[j][0]][c+dir[j][1]][j] =true
                            visited[nr+dir[j][0]][nc+dir[j][1]][j] =true
                        }
                    }
                }
                //좌우 이동 -> 상하벽만 필요
                else{
                    //j : 하상
                    for(j in 0 until 2){
                        if(graph[r+dir[j][0]][c+dir[j][1]]=='X' && graph[nr+dir[j][0]][nc+dir[j][1]]=='X'){
                            if(visited[r+dir[j][0]][c+dir[j][1]][j] || visited[nr+dir[j][0]][nc+dir[j][1]][j]) continue
                            answer++
                            visited[r+dir[j][0]][c+dir[j][1]][j] =true
                            visited[nr+dir[j][0]][nc+dir[j][1]][j] =true
                        }
                    }
                }
            }
        }

}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(n){
        val sen = br.readLine()
        CharArray(m){
            sen[it]
        }
    }

    val visited = Array(n){Array(m){BooleanArray(4)} }
    for(i in 1 until graph.size){
        for(j in 1 until graph[i].size){
            if(graph[i][j]=='.'){
                findWall(i,j,graph,visited)
            }
        }
    }

    write("$answer")
    close()
}
