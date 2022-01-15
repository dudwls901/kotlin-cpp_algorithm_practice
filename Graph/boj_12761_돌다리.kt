//https://www.acmicpc.net/problem/12761
import java.util.*
val br = System.`in`.bufferedReader()
val MAX = 100001
val visited = BooleanArray(MAX)

fun move(dir : Int, cur : Int, a : Int, b: Int) : Int{
    return when (dir) {
        0 -> cur+1
        1 -> cur-1
        2 -> cur+a
        3 -> cur-a
        4 -> cur+b
        5 -> cur-b
        6 -> cur*a
        7 -> cur*b
        else -> -1
    }
}

fun bfs(a : Int, b : Int, n : Int, m : Int) : Int{
    if(n==m) return 0
    val q : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    q.add(Pair(n,0))
    visited[n]=true
    while(q.isNotEmpty()){
        val cur = q.poll()
        for(dir in 0 until 8){
            val next = move(dir,cur.first,a,b)
            if(next !in 0 until MAX) continue
            if(next == m ) return cur.second+1
            if(visited[next]) continue
            visited[next]=true
            q.add(Pair(next,cur.second+1))
        }
    }

    return -1
}

fun main() = with(System.out.bufferedWriter()){

    val (a,b,n,m) = br.readLine().split(' ').map{it.toInt()}

    write("${bfs(a,b,n,m)}")

    close()
}
