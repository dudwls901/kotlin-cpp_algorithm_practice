//https://www.acmicpc.net/problem/17142
import java.util.*
val br = System.`in`.bufferedReader()

val INF = 987654321
val dirXY = arrayOf(arrayOf(0,1),arrayOf(0,-1),arrayOf(1,0),arrayOf(-1,0))
val virus = ArrayList<Pair<Int,Int>>()
val selected = BooleanArray(251)
var answer = INF

data class Node(var r : Int, var c : Int, var dis : Int)

fun bfs(n : Int, graph : Array<IntArray>) : Int{
    val q : Queue<Node> = LinkedList<Node>()
    val graphCopy = Array(n){r->
        IntArray(n){ c->
            when{
                graph[r][c]==1 -> -1 //wall
                graph[r][c]==2 -> -2 //virus
                else -> 0
            }
        }
    }

    for(i in virus.indices){
        if(selected[i]){
            q.add(Node(virus[i].first, virus[i].second,0))
            graphCopy[virus[i].first][virus[i].second]=-1
        }
    }

    while(q.isNotEmpty()){
        val cur = q.poll()

        for(i in 0 until 4){
            val nr = cur.r + dirXY[i][0]
            val nc = cur.c + dirXY[i][1]
            if(nr !in 0 until n || nc !in 0 until n) continue
            if(graphCopy[nr][nc]!=0 && graphCopy[nr][nc]!=-2 ) continue
            if(graphCopy[nr][nc]==-2){
                graphCopy[nr][nc]= -1
            }
            else{
                graphCopy[nr][nc]= cur.dis+1
            }
            q.add(Node(nr,nc,cur.dis+1))
        }
    }

    var cnt=0
    for(i in 0 until n){
        for(j in 0 until n){
            if(graphCopy[i][j]==0) return -1
            cnt = cnt.coerceAtLeast(graphCopy[i][j])
        }
    }

    return cnt

}

fun combination(idx : Int, cnt : Int, n : Int, m : Int, graph : Array<IntArray>){

    if(cnt==m){
        //검사
        val time = bfs(n,graph)
        if(time!=-1){
            answer= answer.coerceAtMost(time)
        }
        return
    }

    for(i in idx until virus.size){
        selected[i]=true
        combination(i+1,cnt+1,n,m,graph)
        selected[i]=false
    }
}

fun main() = with(System.out.bufferedWriter()){
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(n){r->
        var c=0
        br.readLine().split(' ').map{
            val num = it.toInt()
            if(num==2){
                virus.add(Pair(r,c))
            }
            c++
            num
        }.toIntArray()
    }
    
    combination(0,0,n,m,graph)
    
    if(answer ==INF) answer=-1
    write("$answer")
    close()
}
