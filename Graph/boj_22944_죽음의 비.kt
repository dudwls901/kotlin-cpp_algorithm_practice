//https://www.acmicpc.net/problem/22944
import java.util.*

// 4<=n <=500 격자 크기
// 0<=k <=10 우산 개수
// 1<= h <= 10000 체력
// 1<= d <= 5000 우산 내구도
data class Node(var r : Int, var c : Int, var hp : Int, var umb : Int, var umbIdx : Int, var dis : Int)

val dir = arrayOf(
    arrayOf(1,0),
    arrayOf(0,1),
    arrayOf(-1,0),
    arrayOf(0,-1)
)
var nUmbIdx = 0
fun bfs(n : Int, h : Int, d : Int, sr : Int, sc : Int, graph : Array<CharArray>, visited : Array<Array<BooleanArray>>): Int{

    val q : Queue<Node> = LinkedList<Node>()
    q.add(Node(sr,sc,h,0,0, 0))
    visited[0][sr][sc] = true

    while(q.isNotEmpty()){
        val cur = q.poll()

        for(i in 0 until 4){
            val nr = cur.r+dir[i][0]
            val nc = cur.c+dir[i][1]
            var nUmb = cur.umb
            var nHp = cur.hp
            if(nr !in 0 until n || nc !in 0 until n) continue
            if(visited[cur.umbIdx][nr][nc]) continue
            //안전 지대 도착
            if(graph[nr][nc]=='E'){
                return cur.dis+1
            }
            //일반 땅
            else if(graph[nr][nc]=='.'){
                //우산 내구도 남아있으면 hp 대신 내구도 감소
                if (nUmb > 0) {
                    nUmb--
                }
                //우산이 없으면 hp 감소
                else {
                    nHp--
                }
            }
            //우산 찾으면 우산 내구도 리셋
            else{
                nUmb=d-1
                cur.umbIdx=++nUmbIdx
                graph[nr][nc]='.'
            }
            //hp 0이면 전진 불가
            if(nHp==0) continue
            visited[cur.umbIdx][nr][nc]=true
            q.add(Node(nr,nc,nHp,nUmb,cur.umbIdx,cur.dis+1))
        }
    }
    return -1
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,h,d) = br.readLine().split(' ').map{it.toInt()}
    var umbCnt=0
    var sr =0
    var sc =0
    val graph = Array(n){r->
        val sen = br.readLine()
        CharArray(n){c->
            var ch =sen[c]
           if(sen[c]=='S'){
               sr = r
               sc = c
               ch = '.'
           }
            else if(sen[c]=='U'){
                umbCnt++
           }
            ch
        }
    }

    write("${bfs(n,h,d,sr,sc,graph,Array(umbCnt+1){Array(n){BooleanArray(n)}})}")

    close()
}

