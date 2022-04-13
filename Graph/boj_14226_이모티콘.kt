//https://www.acmicpc.net/problem/14226
import java.util.*
val br = System.`in`.bufferedReader()
const val MAX = 2001
val visited = Array(MAX){BooleanArray(MAX)}
var s=0

fun valiCheck(x: Int, y: Int): Boolean{
    if(x !in 1 until MAX) return false
    if(visited[x][y]) return false
    return true
}

fun bfs(): Int{
    //현재 숫자, 클립보드 숫자
    val q : Queue<Pair<Int,Int>> = LinkedList()
    q.add(Pair(1,0))
    var time=0
    while(q.isNotEmpty()){
        val size= q.size
        for(i in 0 until size){
            val (cur,clip) = q.poll()
            var next = -1
            //copy
            q.add(Pair(cur,cur))
            visited[cur][clip] = true
            //paste
            if(clip!=0){
                next = cur+clip
                if(next==s) return time+1
                if(valiCheck(next,clip)) {
                    visited[next][clip] = true
                    q.add(Pair(next, clip))
                }
            }
            //delete
            if(cur>1){
                next = cur-1
                if(next==s) return time+1
                if(valiCheck(next,clip)) {
                    visited[next][clip] = true
                    q.add(Pair(next, clip))
                }
            }
        }
        time++
    }
    return 0
}

fun main() = with(System.out.bufferedWriter()){

    //input
    s = br.readLine().toInt()

    //solve,output
    if(s==0){
        write("0")
    }
    else{
        write("${bfs()}")
    }

    close()
}
