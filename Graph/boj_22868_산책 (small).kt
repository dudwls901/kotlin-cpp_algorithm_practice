//https://www.acmicpc.net/problem/22868
import java.util.*
var ans=0
fun bfs(way : Int, graph : Array<ArrayList<Int>>,n : Int ,s : Int, e : Int, visited : BooleanArray) : BooleanArray{
    val q : Queue<Jogging> = LinkedList<Jogging>()
    q.add(Jogging(s,0,s.toString()))
    var firstLoad=""
    while(q.isNotEmpty()){
        var (cur , dis, load) = q.poll()
        visited[cur]=true

        //s->e일 때
        if(way==0){
            if (cur == e) {
                firstLoad = load
                ans+=dis
                break
            }

        }
        //e->s일 때
        else{
            if(cur ==e){
                ans+=dis
                return BooleanArray(1)
            }
        }
        for(i in graph[cur].indices){
            var next = graph[cur][i]
            if(visited[next])continue
            q.add(Jogging(next,dis+1,load+" "+next.toString()))
        }
    }
    var arr = BooleanArray(n+1)
    val tk = StringTokenizer(firstLoad)
    tk.nextToken()
    while(tk.hasMoreTokens()){
        arr[Integer.parseInt(tk.nextToken())]=true
    }
    return arr
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var tk = StringTokenizer(br.readLine())
    val (n,m) = List(2){ Integer.parseInt(tk.nextToken()) }
    val graph = Array<ArrayList<Int>>(n+1){ArrayList<Int>()}
    for(i in 0 until m){
        tk = StringTokenizer(br.readLine())
        val (from, to) = List(2){Integer.parseInt(tk.nextToken())}
        graph[from].add(to)
        graph[to].add(from)
    }
    for(i in 1 .. n){
        graph[i].sort()
    }
    tk = StringTokenizer(br.readLine())
    val (s,e) = List(2){Integer.parseInt(tk.nextToken())}
    //첫 번째 bfs에서s-e경로 찾고 지나온 경로들 visied에 true로 저장
    var visited  = bfs(0,graph,n,s,e,BooleanArray(n+1))
    //구한 visited가지고 다시 e-s경로 찾기
    bfs(1,graph,n,e,s,visited)
    write("$ans")
    close()
}
data class Jogging(var node : Int, var dis : Int, var str : String)
