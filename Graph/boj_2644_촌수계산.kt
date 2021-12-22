//https://www.acmicpc.net/problem/2644
//dfs
val br = System.`in`.bufferedReader()
var answer =-1
val visited = BooleanArray(101)
fun dfs(s : Int, e : Int, cnt : Int, edge : Array<ArrayList<Int>>){
    if(answer != -1) return
    if(s==e){
        answer = cnt
        return
    }

    for(next in edge[s]){
        if(visited[next])continue
        visited[next]=true
        dfs(next,e,cnt+1,edge)
        if(answer !=-1) return
    }
}

fun main() = with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    val (s,e) = br.readLine().split(' ').map{it.toInt()}
    val m = br.readLine().toInt()
    val edge = Array(n+1){ArrayList<Int>()}
    for(i in 0 until m){
        val (from,to) = br.readLine().split(' ').map{it.toInt()}
        edge[from].add(to)
        edge[to].add(from)
    }
    dfs(s,e,0,edge)
    write("$answer")
    close()
}
/*bfs
import java.util.*
val dirXY = arrayOf(arrayOf(0,1),arrayOf(0,-1),arrayOf(1,0),arrayOf(-1,0))

val br = System.`in`.bufferedReader()
var answer =-1
val visited = BooleanArray(101)
fun bfs(s : Int, e : Int, edge : Array<ArrayList<Int>>) : Int{
    val q : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    q.add(Pair(s,0))
    visited[s]=true

    while(q.isNotEmpty()){
        val cur = q.poll()
        for(next in edge[cur.first]){
            if(visited[next]) continue
            if(next==e) return cur.second+1
            visited[next]=true
            q.add(Pair(next,cur.second+1))
        }
    }
    return -1
}

fun main() = with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    val (s,e) = br.readLine().split(' ').map{it.toInt()}
    val m = br.readLine().toInt()
    val edge = Array(n+1){ArrayList<Int>()}
    for(i in 0 until m){
        val (from,to) = br.readLine().split(' ').map{it.toInt()}
        edge[from].add(to)
        edge[to].add(from)
    }

    write("${bfs(s,e,edge)}")
    close()
}
*/
