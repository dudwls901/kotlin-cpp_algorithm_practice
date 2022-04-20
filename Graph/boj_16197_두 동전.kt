//https://www.acmicpc.net/problem/16197
import java.util.*
val br = System.`in`.bufferedReader()

fun getIntGraph() = br.readLine().split(' ').map { it.toInt() }

val dir = arrayOf(
    arrayOf(0,1),
    arrayOf(1,0),
    arrayOf(0,-1),
    arrayOf(-1,0)
)
lateinit var graph: Array<String>
val startCoin = ArrayList<Pair<Int,Int>>()
fun bfs(n: Int, m: Int):Int{

    val q: Queue<Pair<Int,Int>> = LinkedList()
    for(coin in startCoin){
        q.add(coin)
    }
    var turn=1
    while(q.isNotEmpty()){
        val size = q.size
        for(i in 0 until size/2){
            val cur1 = q.poll()
            val cur2 = q.poll()
            for(j in 0 until 4){
                var outCount =0
                val nr1 = cur1.first + dir[j][0]
                val nc1 = cur1.second + dir[j][1]
                val nr2 = cur2.first + dir[j][0]
                val nc2 = cur2.second + dir[j][1]
                if(nr1 !in 0 until n || nc1 !in 0 until m){
                    outCount++
                }
                else if(graph[nr1][nc1]=='#'){
                    q.add(cur1)
                }
                else{
                    q.add(Pair(nr1,nc1))
                }
                if(nr2 !in 0 until n || nc2 !in 0 until m){
                    outCount++
                }
                else if(graph[nr2][nc2]=='#'){
                    q.add(cur2)
                }
                else{
                    q.add(Pair(nr2,nc2))
                }
                if(outCount==1){
                    return turn
                }
            }
        }
        turn++
        if(turn>10) return -1
    }

    return -1
}

fun main() = with(System.out.bufferedWriter()){

    //input
    val(n,m) = getIntGraph()
    graph = Array(n){r->
        br.readLine().also {
        for(c in it.indices){
            if(it[c]=='o'){
                startCoin.add(Pair(r,c))
            }
        }
    } }

    //solve, output
    write("${bfs(n,m)}")

    close()
}
