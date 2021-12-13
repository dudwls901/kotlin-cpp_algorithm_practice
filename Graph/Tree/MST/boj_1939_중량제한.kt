//https://www.acmicpc.net/problem/1939
/*프림
import java.util.*
import kotlin.math.*
//2 <= n<= 10000
// 1<= m <= 100000
//중량의 최댓값 구하기
//중량이 큰 다리를 탐색하여 그 중 가장 작은 값이 가능한 중량의 최댓값
fun bfs(s : Int, e : Int, edge : Array<ArrayList<Pair<Int,Int>>>, visited : BooleanArray) : Int{
    var minWeight = 1987654321
    visited[s]=true
    val pq = PriorityQueue<Pair<Int,Int>>(kotlin.Comparator { a, b ->
        when{
            a.second < b.second -> 1
            a.second < b.second -> 0
            else -> -1
        }
    })
    pq.add(Pair(s,1987654321))

    while(pq.isNotEmpty()){
        val cur = pq.poll()
        minWeight = min(minWeight,cur.second)
        if(cur.first==e){
            break
        }
        visited[cur.first] =true
        for(next in edge[cur.first]){
            if(visited[next.first]) continue
            pq.add(Pair(next.first, next.second))
        }
    }
    return minWeight
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val edge = Array(n+1){ArrayList<Pair<Int,Int>>()}
    for(i in 0 until m){
        val (from,to, weight) = br.readLine().split(' ').map{it.toInt()}
        edge[from].add(Pair(to,weight))
        edge[to].add(Pair(from,weight))
    }
    val (s,e) = br.readLine().split(' ').map{it.toInt()}

    write("${bfs(s,e,edge,BooleanArray(n+1))}")
    close()
}
*/
/* 크루스칼
//2 <= n<= 10000
// 1<= m <= 100000
//중량의 최댓값 구하기


data class Edge(var from : Int, var to : Int, var weight : Int)

fun getParent(x : Int,parent : IntArray) : Int{
    return if(parent[x]==x) x else getParent(parent[x],parent).also{parent[x]=it}
}

fun unionParent(x : Int, y : Int, parent : IntArray){
    val xx = getParent(x,parent)
    val yy = getParent(y,parent)
    if(xx<yy){
        parent[yy]=xx
    }
    else{
        parent[xx]=yy
    }
}

fun findParent(x : Int, y : Int, parent : IntArray) : Boolean{
    val xx = getParent(x,parent)
    val yy = getParent(y,parent)
    return xx==yy
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val edge = Array<Edge>(m*2){Edge(0,0,0)}
    val parent = IntArray(n+1){it}
    var idx=0
    for(i in 0 until m){
        val (from,to,weight) = br.readLine().split(' ').map{it.toInt()}
        edge[idx++] = Edge(from,to,weight)
        edge[idx++] = Edge(to,from,weight)
    }
    val (s,e) = br.readLine().split(' ').map{it.toInt()}
    edge.sortWith(Comparator { a, b ->
        when{
            a.weight < b.weight -> 1
            a.weight ==b.weight -> 0
            else -> -1
        }
    })
    var answer=0
    for(i in 0 until m*2){
        if(findParent(s,e,parent))break
        if(findParent(edge[i].from,edge[i].to,parent)) continue
        answer= edge[i].weight
        unionParent(edge[i].from,edge[i].to,parent)
    }
    write("${answer}")

    close()
}
*/
// 파라메트릭 서치
import kotlin.math.*
import java.util.*

//2 <= n<= 10000
// 1<= m <= 100000
//중량의 최댓값 구하기
//중량이 큰 다리를 탐색하여 그 중 가장 작은 값이 가능한 중량의 최댓값

fun bfs(weight : Int, s : Int, e : Int, visited : BooleanArray, edge : Array<ArrayList<Pair<Int,Int>>>) : Boolean{
    visited[s]=true
    val q : Queue<Int> = LinkedList<Int>()
    q.add(s)

    while(q.isNotEmpty()){
        val cur = q.poll()
        for(next in edge[cur]){
            if(next.second<weight) continue
            if(visited[next.first]) continue
            if(next.first==e) return true
            q.add(next.first)
            visited[next.first]=true

        }
    }
    return false
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val edge = Array(n+1){ArrayList<Pair<Int,Int>>()}
    var right = 0
    var left = 1
    for(i in 0 until m){
        val (from,to,weight) = br.readLine().split(' ').map{it.toInt()}
        edge[from].add(Pair(to,weight))
        edge[to].add(Pair(from,weight))
        right = max(right, weight)
    }
    val (s,e) = br.readLine().split(' ').map{it.toInt()}
    //mid는 내가 가지고 갈 중량
    while(left<=right){
        val mid = (left+right)/2
        if(bfs(mid,s,e, BooleanArray(n+1),edge)){
            left = mid+1

        }
        else{
            right = mid-1
        }
    }
    write("${left-1}")
    close()
}
