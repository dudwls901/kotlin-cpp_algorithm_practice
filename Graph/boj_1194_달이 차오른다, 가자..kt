//https://www.acmicpc.net/problem/1194
import java.util.*
val dir = arrayOf(arrayOf(1,0),arrayOf(0,1),arrayOf(-1,0),arrayOf(0,-1))
val visited = Array(1 shl 7){Array(50){BooleanArray(50)} }

data class Node(var r: Int, var c : Int,var key : Int, var dis : Int)
fun bfs(sr : Int, sc : Int, n : Int, m : Int, graph : Array<CharArray>) : Int {

    val q: Queue<Node> = LinkedList<Node>()
    q.add(Node(sr, sc, 1, 0))
    visited[1][sr][sc] = true

    while (q.isNotEmpty()) {
        val cur = q.poll()
        for (i in 0 until 4) {
            val nr = cur.r + dir[i][0]
            val nc = cur.c + dir[i][1]
            var nk = cur.key
            if (nr !in 0 until n || nc !in 0 until m) continue
            if (visited[nk][nr][nc]) continue
            if (graph[nr][nc] == '#') continue
            if (graph[nr][nc] == '1') {
                return cur.dis + 1
            }
            //문
            if (graph[nr][nc] >= 'A' && graph[nr][nc] <= 'F') {
                if (nk and (1 shl (graph[nr][nc]-'A'+1)) != 0) {
                    q.add(Node(nr, nc, nk, cur.dis + 1))
                    visited[nk][nr][nc] = true
                } else {
                    continue
                }
            }
            //열쇠
            else if (graph[nr][nc] >= 'a' && graph[nr][nc] <= 'f') {
                nk = nk or (1 shl (graph[nr][nc]-'a'+1))
                q.add(Node(nr, nc, nk, cur.dis + 1))
                visited[nk][nr][nc] = true
            }
            //.
            else {
                q.add(Node(nr, nc, nk, cur.dis + 1))
                visited[nk][nr][nc] = true
            }

        }
    }
    return -1
}
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    var sr=0
    var sc=0
    val graph = Array(n){r->
        val sen = br.readLine()
        CharArray(m){c->
            var ch= sen[c]
            if(sen[c]=='0'){
                sr=r
                sc=c
                ch = '.'
            }
            ch
        }
    }
    write("${ bfs(sr, sc,n,m, graph) }")
    close()
}
