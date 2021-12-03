//https://www.acmicpc.net/problem/15686
import kotlin.math.*
import java.util.StringTokenizer
//1에서 가장 가까운 2를 찾기
var answer = 987654321

fun dfs(idx : Int, len : Int, n : Int, m : Int, house : ArrayList<Pair<Int,Int>>,chicken : ArrayList<Pair<Int,Int>>, graph : Array<IntArray> ,visited : BooleanArray){

    if(len==m){
        var cnt=0
        for(i in house.indices){
            var minDis=987654321
                for(j in chicken.indices) {
                    if(visited[j]){
                        minDis = min(minDis, abs(chicken[j].first - house[i].first) + abs(chicken[j].second - house[i].second))
                    }
                }
            cnt += minDis
        }
        answer = min(answer,cnt)
        return
    }
    for(i in idx until chicken.size){
        visited[i]=true
        dfs(i+1,len+1,n,m,house,chicken,graph,visited)
        visited[i]=false
    }
}
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val house =ArrayList<Pair<Int,Int>>()
    val chicken = ArrayList<Pair<Int,Int>>()
    val graph = Array(n){r->
        val tk = StringTokenizer(br.readLine())
        IntArray(n){c->
            val node = tk.nextToken().toInt()
            if(node==1){
                house.add(Pair(r,c))
            }
            else if(node==2){
                chicken.add(Pair(r,c))
            }
            node
        }
    }
    dfs(0,0,n,m,house,chicken,graph , BooleanArray(chicken.size))
    write("$answer")

    close()
}
