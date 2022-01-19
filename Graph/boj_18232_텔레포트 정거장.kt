//https://www.acmicpc.net/problem/18232
import java.util.*
val br = System.`in`.bufferedReader()
lateinit var teleport : Array<ArrayList<Int>>
lateinit var visited : BooleanArray
fun bfs(s : Int, e : Int, n : Int) : Int{
    val q : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    q.add(Pair(s,0))
    visited[s]=true
    while(q.isNotEmpty()){
        val cur = q.poll()

        for(next in teleport[cur.first]){
            if(visited[next]) continue
            if(next==e){
                return cur.second+1
            }
            visited[next]=true
            q.add(Pair(next,cur.second+1))
        }

        for(i in 1 downTo -1 step 2){

            val next = cur.first+i
            if(next !in 1 .. n)continue
            if(visited[next]) continue
            if(next==e){
                return cur.second+1
            }
            visited[next]=true
            q.add(Pair(next,cur.second+1))
        }
    }

    return 0
}

fun main() = with(System.out.bufferedWriter()){

    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val (s,e) = br.readLine().split(' ').map{it.toInt()}
    teleport = Array(n+1){ ArrayList<Int>()}
    visited = BooleanArray(n+1)
    for(i in 0 until m){
        val (from, to) = br.readLine().split(' ').map{it.toInt()}
        teleport[from].add(to)
        teleport[to].add(from)
    }

    write("${bfs(s,e,n)}")
    close()
}
