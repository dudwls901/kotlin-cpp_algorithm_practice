//https://www.acmicpc.net/problem/17141
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }

lateinit var graph: Array<IntArray>
val virusPlaces = ArrayList<Pair<Int, Int>>()
var answer = Int.MAX_VALUE

val dir = arrayOf(
    arrayOf(0,1),
    arrayOf(1,0),
    arrayOf(0,-1),
    arrayOf(-1,0),
)

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n, m) = getIntList()
    graph = Array(n) { r ->
        val list = getIntList()
        for (c in list.indices) {
            if (list[c] == 2) {
                virusPlaces.add(Pair(r, c))
            }
        }
        list.toIntArray()
    }
    //solve
    virusCombination(IntArray(m),0, 0, n, m)

    //output
    write("${if(answer == Int.MAX_VALUE) -1 else answer}")
    close()
}

fun virusCombination(selectedVirusPlaces: IntArray, idx: Int, cnt: Int, n: Int, m: Int) {

    if(cnt == m){
        answer = answer.coerceAtMost(play(selectedVirusPlaces,n,m))
        return
    }

    for (i in idx until virusPlaces.size) {
        selectedVirusPlaces[cnt]= i
        virusCombination(selectedVirusPlaces, i+1, cnt+1, n,m)
    }
}

fun play(selectedVirusPlaces: IntArray, n: Int, m: Int): Int {
    val q: Queue<Pair<Int,Int>> = LinkedList()
    var time = 0
    val tempGraph = Array(n){ r->
        IntArray(n){c->
            graph[r][c]
        }
    }
    for(i in selectedVirusPlaces){
        val (r,c) = virusPlaces[i]
        q.add(virusPlaces[i])
        tempGraph[r][c] = 1
    }
    if(checkFinish(tempGraph,n)) return time
    while(q.isNotEmpty()){
        val size = q.size
        time++
        for(i in 0 until size) {
            val (cr,cc) = q.poll()

            for(j in 0 until 4){
                val nr = cr + dir[j][0]
                val nc = cc + dir[j][1]

                if(nr !in 0 until n || nc !in 0 until n) continue
                if(tempGraph[nr][nc] == 1) continue
                tempGraph[nr][nc] = 1
                q.add(Pair(nr,nc))
             }
        }
        if(checkFinish(tempGraph,n)) return time
    }
    return Int.MAX_VALUE
}

fun checkFinish(tempGraph: Array<IntArray>, n: Int): Boolean{
    var wallCnt = 0
    for(r in 0 until n){
        for(c in 0 until n){
            if(tempGraph[r][c] == 1) wallCnt++
        }
    }
    return wallCnt==n*n
}
