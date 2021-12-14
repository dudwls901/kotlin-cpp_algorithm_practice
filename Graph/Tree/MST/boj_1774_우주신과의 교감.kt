//https://www.acmicpc.net/problem/1774
import kotlin.math.*
data class Edge(var from : Int, var to  : Int, var dis : Double)

fun getParent(x : Int , parent : IntArray) : Int{
    return if(parent[x]<0) x else getParent(parent[x],parent).also{parent[x] = it}
}
fun unionParent(x : Int, y : Int, parent : IntArray) : Boolean{
    val xx = getParent(x,parent)
    val yy = getParent(y,parent)
    if(xx!=yy){
        parent[xx] =yy
        return true
    }
    else{
        return false
    }
}


fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val god = Array(n){Pair(0L,0L)}
    val parent = IntArray(n){-1}
    val edge = ArrayList<Edge>()
    var answer = .0
    for(i in 0 until n){
        val (x,y) = br.readLine().split(' ').map{it.toLong()}
        god[i] = Pair(x,y)
    }

    for(i in 0 until m){
        var (a,b) = br.readLine().split(' ').map{it.toInt()}
        a--
        b--
        unionParent(a,b,parent)
    }
    for(i in 0 until n-1){
        for(j in i+1 until n){
            edge.add(Edge(i,j,sqrt(((god[i].first-god[j].first)*(god[i].first-god[j].first)+(god[i].second-god[j].second)*(god[i].second-god[j].second)).toDouble())))
        }
    }
    edge.sortBy{it.dis}
    for(i in edge.indices){
        if(unionParent(edge[i].from,edge[i].to,parent)){
            answer += edge[i].dis
        }
    }
    write("${String.format("%.2f", round(answer*100) /100)}")
    close()
}
