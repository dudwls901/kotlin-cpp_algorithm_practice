//https://www.acmicpc.net/problem/16398
/*
data class Edge(var from : Int, var to : Int, var dis : Long)

val parent = IntArray(1000){-1}

fun getParent(x : Int) : Int{
    return if(parent[x]<0) x else getParent(parent[x]).also{parent[x]=it}
}

fun unionParent(x : Int, y : Int) : Boolean{
    val xx = getParent(x)
    val yy = getParent(y)
    if(xx!=yy){
        parent[yy]=xx
        return true
    }
    return false

}


fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val edge = Array((n*(n-1))/2){Edge(0,0,0)}
    var idx=0
    for(i in 0 until n-1){
        val line = br.readLine().split(' ').map{it.toLong()}
        for(j in i+1 until n){
            edge[idx++]=Edge(i,j,line[j])
        }
    }
   edge.sortBy { it.dis }
    var answer = 0L
    for(ele in edge){
        if(unionParent(ele.from,ele.to))
        answer += ele.dis
    }

    write("$answer")
    close()
}
*/
//프림
import java.util.*
fun prim( n : Int, edge : Array<ArrayList<Pair<Int,Long>>>, visited: BooleanArray) : Long{

    var answer= 0L
    val pq = PriorityQueue<Pair<Int,Long>>(kotlin.Comparator {a, b ->
        when{
            a.second < b.second -> -1
            a.second == b.second -> 0
            else -> 1
        }
    })
    pq.add(Pair(0,0L))
    while(pq.isNotEmpty()){
        val cur = pq.poll()
        if(visited[cur.first]) continue
        visited[cur.first]=true
        answer+=cur.second

        for(next in edge[cur.first]){
            if(visited[next.first]) continue
            pq.add(Pair(next.first,next.second))
        }

    }
    return answer
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val edge = Array(n){ArrayList<Pair<Int,Long>>()}
    for(i in 0 until n-1){
        val line = br.readLine().split(' ').map{it.toLong()}
        for(j in i+1 until n){
            edge[i].add(Pair(j,line[j]))
            edge[j].add(Pair(i,line[j]))
        }
    }
    write("${prim(n,edge,BooleanArray(n))}")
    close()
}
