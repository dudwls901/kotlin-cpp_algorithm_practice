//https://www.acmicpc.net/problem/21924
import java.util.StringTokenizer

fun getParent(parent : IntArray, x : Int) : Int{
    return if(parent[x]==x) x else getParent(parent,parent[x]).also { parent[x] = it }
}
fun findParent(parent : IntArray, a : Int, b : Int) : Boolean{
    val aa = getParent(parent,a)
    val bb = getParent(parent,b)
    return if(aa==bb) true else false

}
fun unionParent(parent : IntArray, a : Int, b : Int){
    val aa = getParent(parent,a)
    val bb = getParent(parent,b)
    if(aa<bb) parent[bb] = aa else parent[aa]=bb
}


fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var tk = StringTokenizer(br.readLine())
    val (n,m) = List(2){Integer.parseInt(tk.nextToken())}
    val graph = Array<Edge>(m){Edge(0,0,0)}
    var sum =0L
    var minSum=0L
    val parent = IntArray(n+1)
    for(i in 0 until m){
        tk = StringTokenizer(br.readLine())
        val (from, to, dis) = List(3){Integer.parseInt(tk.nextToken())}
        graph[i]=Edge(from,to,dis)
        sum +=dis
    }
    graph.sortWith(kotlin.Comparator{ a,b ->
        when {
            a.dis < b.dis -> -1
            a.dis == b.dis -> 0
            else -> 1
        }
    })

    for(i in 1 .. n){
        parent[i]=i
    }
    for(i in 0 until m) {
        if (!findParent(parent, graph[i].from, graph[i].to)) {
            minSum += graph[i].dis
            unionParent(parent, graph[i].from, graph[i].to)
        }
    }
    for(i in 2 .. n){
        if(!findParent(parent,1,i)){
            write("${-1}")
            close()
            return
        }
    }
    write("${sum-minSum}")
    close()

}
data class Edge(val from : Int, val to : Int, val dis : Int)
