//https://www.acmicpc.net/problem/14940
import java.util.*

//n은 행 m은 열
//2<=n,m<=1000
//0방문 불가,1은 방문 가능
//도달할 수 없는 경우 -1 출력, 원래갈 수 없는 땅은 0 출력

val dir = arrayOf(arrayOf(0,1),arrayOf(1,0),arrayOf(0,-1),arrayOf(-1,0))

fun bfs(i : Int, j : Int, n : Int, m : Int, graph : Array<IntArray>, visited : Array<BooleanArray>){
    val q : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    q.add(Pair(i,j))
    graph[i][j]=0
    visited[i][j] =true

    while(q.isNotEmpty()){
        val (r,c) = q.poll()

        for(i in 0 until 4){
            val nR = r+dir[i][0]
            val nC = c+dir[i][1]
            if(nR<0 || nR>=n || nC<0 || nC>=m) continue
            if(visited[nR][nC]) continue
            if(graph[nR][nC]==0){
              visited[nR][nC]=true
                continue
            }
            graph[nR][nC] = graph[r][c]+1
            visited[nR][nC] =true
            q.add(Pair(nR,nC))
        }
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br =System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val visited = Array(n){BooleanArray(m)}

    var sr =-1
    var sc =-1
    val graph = Array(n){x->
    val st = StringTokenizer(br.readLine())
        IntArray(m){y->
            val node = st.nextToken().toInt()
            if(node ==2){
              sr = x
              sc = y
            }
            node
        }

    }

    bfs(sr,sc,n,m, graph,visited)

    for(r in 0 until n){
        for(c in 0 until m){
            if(graph[r][c]==0){
                write("0 ")
                continue
            }
            if(visited[r][c]){
                write("${graph[r][c]} ")
            }
            else{
                write("-1 ")
            }
        }
        write("\n")
    }
    close()
}
