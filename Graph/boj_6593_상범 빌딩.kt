//https://www.acmicpc.net/problem/6593
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var graph: Array<Array<CharArray>>
var sl = 0
var sr = 0
var sc = 0
var el = 0
var er = 0
var ec = 0
val dir = arrayOf(
    arrayOf(0,1),
    arrayOf(0,-1),
    arrayOf(1,0),
    arrayOf(-1,0)
)
fun bfs(h: Int, n: Int, m: Int) : Int{
    var moveCnt = 0
    val q: Queue<Triple<Int,Int,Int>> = LinkedList()
    q.add(Triple(sl,sr,sc))
    graph[sl][sr][sc] = '#'
    while(q.isNotEmpty()){
        val size = q.size
        for(i in 0 until size) {
            val (l, r, c) = q.poll()
            for (j in 0 until 4) {
                val nr = r + dir[j][0]
                val nc = c + dir[j][1]
                if (nr !in 0 until n || nc !in 0 until m) continue
                if (graph[l][nr][nc] == '#') {
                    continue
                } else if (graph[l][nr][nc] == 'E') {
                    return moveCnt + 1
                }
                graph[l][nr][nc] = '#'
                q.add(Triple(l, nr, nc))
            }
            var nl = l + 1
            if (nl in 0 until h) {
                if (graph[nl][r][c] == 'E') {
                    return moveCnt + 1
                } else if (graph[nl][r][c] == '.') {
                    graph[nl][r][c] = '#'
                    q.add(Triple(nl, r, c))
                }
            }
            nl = l - 1
            if (nl in 0 until h) {
                if (graph[nl][r][c] == 'E') {
                    return moveCnt + 1
                } else if (graph[nl][r][c] == '.') {
                    graph[nl][r][c] = '#'
                    q.add(Triple(nl, r, c))
                }
            }
        }
        moveCnt++
    }
    return -1
}

fun main() = with(System.out.bufferedWriter()){
    while(true) {
        //input
        val (l, r, c) = getIntList()
        if (l == 0 && r == 0 && c == 0) break
        graph = Array(l) { i ->
            val floor = Array(r) { j->
                val line = br.readLine()
                for(k in line.indices){
                    if(line[k] == 'S'){
                        sl = i
                        sr = j
                        sc = k
                    }
                    else if(line[i] == 'E'){
                        el = i
                        er = j
                        ec = k
                    }
                }
                line.toCharArray()
            }
            br.readLine()
            floor
        }
        //solve
        val answer = bfs(l,r,c)

        //output
        if(answer>=0){
            write("Escaped in $answer minute(s).\n")
        }else{
            write("Trapped!\n")
        }
    }
    close()
}
