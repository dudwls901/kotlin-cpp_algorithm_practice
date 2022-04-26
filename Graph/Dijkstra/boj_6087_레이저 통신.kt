//https://www.acmicpc.net/problem/6087
import java.util.*
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
fun chToInt(ch: Char) = Character.getNumericValue(ch)

lateinit var graph: Array<String>
lateinit var visited: Array<IntArray>
var start =  ArrayList<Pair<Int,Int>>(2)
val dir = arrayOf(
    arrayOf(-1,0),//상
    arrayOf(0,1),//우
    arrayOf(1,0),//하
    arrayOf(0,-1)//좌
)
data class Node(
    val r: Int,
    val c: Int,
    val d: Int,
    val cnt: Int
)

fun bfs(n: Int, m: Int): Int{

    val q: Queue<Node> = LinkedList()

    for(d in 0 until 4) {
        q.add(Node(start[0].first, start[0].second, d, 0))
    }

    while(q.isNotEmpty()){
        val (r,c,d,cnt) = q.poll()
        if(cnt> visited[r][c]) continue
        for(i in 0 until 4){
            val nr = r+dir[i][0]
            val nc = c+dir[i][1]
            var nCnt = cnt
            if(nr !in 0 until n || nc !in 0 until m) continue
            if(graph[nr][nc] == '*') continue
            if((i+2)%4==d) continue
            //방향 전환
            if(i!=d) nCnt++
            if(nCnt>visited[nr][nc]) continue
            visited[nr][nc] = nCnt
            if(graph[nr][nc] == 'C'){
                continue
            }
            q.add(Node(nr,nc,i,nCnt))
        }
    }
    return visited[start[1].first][start[1].second]
}

fun main() = with(System.out.bufferedWriter()){

    //input
    val (m,n) = getIntList()
    visited = Array(n){IntArray(m){Int.MAX_VALUE} }
    graph = Array(n){r ->
        br.readLine().apply{
            this.forEachIndexed { index, c ->
                if (c == 'C') {
                    start.add(Pair(r, index))
                }
            }
        }
    }

    //solve, output
    write("${bfs(n,m)}")

    close()
}
