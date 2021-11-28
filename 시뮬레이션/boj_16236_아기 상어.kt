//https://www.acmicpc.net/problem/16236
import java.util.*

//2<=n<=20
const val INF = 987654321
val dir = arrayOf(arrayOf(0,1),arrayOf(1,0),arrayOf(0,-1),arrayOf(-1,0))
var answer=0
var sharkSize=2
fun bfs( n : Int, shark : Shark, graph : Array<IntArray>, visited : Array<BooleanArray>) : Shark{
    val q : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    visited[shark.r][shark.c]=true
    q.add(Pair(shark.r,shark.c))
    var fr = INF
    var fc = INF
    var dis=0

    while(q.isNotEmpty()) {
        val size=q.size
        dis++
        for(i in 0 until size) {
            val cur = q.poll()
            for (dir in dir) {
                val nr = cur.first + dir[0]
                val nc = cur.second + dir[1]
                if (nr !in 0 until n || nc !in 0 until n) continue
                if (visited[nr][nc]) continue
                //상어크기랑 같거나 작으면 이동 가능
                if (graph[nr][nc] <= sharkSize) {
                    //상어 크기보다 작고, 0이 아닌 경우 먹을 수 있음
                    //for문 내에선 거리가 모두 같기 때문에 이 중 가장 위, 가장 왼쪽 찾아서 반환
                    if(graph[nr][nc]<sharkSize && graph[nr][nc]!=0){
                        if(fr>nr){
                            fr = nr
                            fc = nc
                        }
                        else if(fr==nr){
                            if(fc>nc) {
                                fc = nc
                            }
                        }
                    }
                    visited[nr][nc]=true
                    q.add(Pair(nr,nc))
                }
            }
        }
        //물고기 좌표 구했다면 반환
        if(fr!=INF && fc!=INF){
            return Shark(fr,fc,dis)
        }
    }
    //물고기 좌표 못 구했다면 상어좌표 그대로 반환
    return shark
}

fun solve(n : Int, shark : Shark, graph : Array<IntArray>) : Int{
    var cur = shark
    var cnt=0
    while(true){
        //상어가 다음 먹을 물고기 위치, 거리 찾기
        val visited = Array<BooleanArray>(n){BooleanArray(n)}
        val next = bfs(n,shark,graph,visited)
        //다음 먹을 물고기 없으면 stop
        if(next==cur){
            break
        }
        //다음 먹을 물고기 있을 때
        else{
            cur.time +=next.time
            graph[next.r][next.c]=0
            cur.r = next.r
            cur.c = next.c
            cnt++
            if(cnt == sharkSize){
                sharkSize++
                cnt=0
            }
        }
    }
    //최종 이동 시간 반환
    return cur.time
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var shark =Shark(0,0,0)
    val n = br.readLine().toInt()
    val graph = Array<IntArray>(n){ r->
        val tk = StringTokenizer(br.readLine())
        IntArray(n){ c->
            var node = tk.nextToken().toInt()
            if(node ==9){
                shark=Shark(r,c,0)
                node=0
            }
            node
        }
    }
    write("${solve(n,shark,graph)}")
    close()
}

data class Shark(var r : Int, var c : Int,var time : Int){
}
