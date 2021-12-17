//https://www.acmicpc.net/problem/1726
import kotlin.math.*
import java.util.*
val INF = 987654321
val dirXY = arrayOf(arrayOf(0,1),arrayOf(0,-1),arrayOf(1,0),arrayOf(-1,0))
val br = System.`in`.bufferedReader()

data class Node(var r : Int , var c : Int, var dir : Int, var cnt : Int)

//몇 번 돌려야하는지 계산
fun calRotate(curDir : Int, nextDir : Int) : Int{
    return when{
        nextDir ==0 -> when{
            curDir>=2 -> 1
            curDir==1 -> 2
            else -> 0
        }
        nextDir ==1 -> when{
            curDir>=2 -> 1
            curDir==0 -> 2
            else -> 0
        }
        nextDir ==2 -> when{
            curDir<2 -> 1
            curDir==3 -> 2
            else -> 0
        }
        else -> when{
            curDir<2 -> 1
            curDir==2 ->2
            else -> 0
        }
    }
}

fun bfs(sr : Int, sc : Int, sdir : Int, er : Int, ec : Int, edir : Int, n : Int, m : Int, graph : Array<IntArray>, visited : Array<Array<BooleanArray>>) : Int{

    val q : Queue<Node> = LinkedList<Node>()
    q.add(Node(sr,sc,sdir,0))
    visited[sr][sc][sdir]=true
    var answer=INF
    
    while(q.isNotEmpty()){
        val cur =q.poll()
        //도착 지점에 가장 먼저 도착한 경우가 최단 명령 횟수
        //기존의 최단 거리를 찾는 bfs의 컨셉 유지
        //도착하면 방향 맞춰서 출력
        if(cur.r==er && cur.c==ec){
            return cur.cnt+ calRotate(cur.dir,edir)
        }
        
        var nr=cur.r
        var nc=cur.c
        //기존 방향 1,2,3칸 방문, +1씩
        for(i in 0 until 3){
            nr+=dirXY[cur.dir][0]
            nc+=dirXY[cur.dir][1]
            if(nr !in 0 until n || nc !in 0 until m) break //그래프 넘어간 경우 스탑
            if(visited[nr][nc][cur.dir] ) continue // 이미 방문한 칸은 스킵
            if(graph[nr][nc]==1) break //1만나면 스탑
            q.add(Node(nr,nc,cur.dir,cur.cnt+1))
            visited[nr][nc][cur.dir]=true
        }
        //현재 자리에서 방향만 전환한 후 큐에 추가
        for(dir in 0 until 4){
            if(dir==cur.dir) continue
            if(visited[cur.r][cur.c][dir] ) continue
            q.add(Node(cur.r,cur.c,dir,cur.cnt+ calRotate(cur.dir,dir)))
            visited[cur.r][cur.c][dir]=true
        }
    }
    return answer
}


fun main() = with(System.out.bufferedWriter()){

    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(n){
        br.readLine().split(' ').map{it.toInt()}.toIntArray()
    }
    val (sr,sc,sdir) = br.readLine().split(' ').map{it.toInt()}
    val (er,ec,edir) = br.readLine().split(' ').map{it.toInt()}
    write("${bfs(sr-1,sc-1,sdir-1,er-1,ec-1,edir-1,n,m,graph,Array(n){Array(m){BooleanArray(4)} })}")

    close()
}
