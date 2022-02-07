//https://www.acmicpc.net/problem/10472
import java.util.*

val br = System.`in`.bufferedReader()

val dirXY = arrayOf(arrayOf(-1, 0), arrayOf(0, 1), arrayOf(1, 0), arrayOf(0,-1))

fun bfs(state : Int, visited : BooleanArray) : Int{

    val q : Queue<Pair<Int,Int>> = LinkedList()
    q.add(Pair(state,0))
    visited[state]=true
    if(state==0){
        return 0
    }

    while(q.isNotEmpty()) {
        val (curState,cnt) = q.poll()
        for (i in 8 downTo 0) {
            val cr = i/3
            val cc = i%3
            var nextState = curState xor (1 shl (8-i))
            for(j in 0 until 4){
                val nr = cr + dirXY[j][0]
                val nc = cc + dirXY[j][1]
                if(nr !in 0 until 3 || nc !in 0 until 3) continue
                val idx = 8-(nr*3 + nc)
                nextState = nextState xor (1 shl idx)
            }
            if(nextState==0){
                return cnt+1
            }
            if(visited[nextState])continue
            visited[nextState]=true
            q.add(Pair(nextState,cnt+1))
        }
    }
    return -1
}

fun main() = with(System.out.bufferedWriter()){

    val t = br.readLine().toInt()

    repeat(t){
        val graph = Array(3){br.readLine()}
        var state=0
        for(i in 0 until 9){
            val r = i/3
            val c = i%3
            if(graph[r][c]=='*'){
                state += 1 shl (8-i)
            }
        }
        write("${ bfs(state, BooleanArray(1 shl 9)) }\n")
    }

    close()
}
