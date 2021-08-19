//https://www.acmicpc.net/problem/2021
import java.util.*

fun bfs(graph : Array<MutableList<Int>>, visited : IntArray, start : Int, end : Int ,n :Int) : Int {
    val q : Queue<Int> = LinkedList<Int>()
    q.add(start)
    while(q.isNotEmpty()){
        val cur = q.poll()
        for(i in graph[cur].indices){
            val next = graph[cur][i]
            if(visited[next]>=0) continue
            //호선
            if(next>n){
                q.add(next)
                visited[next] = visited[cur]+1
            }
            //도착
            else if(next==end){
                return visited[cur]
            }
            //역
            else{
                q.add(next)
                visited[next]=visited[cur]
            }
        }
    }
    return -1
}

fun main()= with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var tk = StringTokenizer(br.readLine())
    val (n,m) = List(2){Integer.parseInt(tk.nextToken())}
    val graph = Array(n*2+1,{mutableListOf<Int>()})
    val visited = IntArray(n*2+1,{-1})
    for(i in 1 .. m){
        tk = StringTokenizer(br.readLine())
        var num = Integer.parseInt(tk.nextToken())
        while(num!=-1){
            graph[num].add(n+i)
            graph[n+i].add(num)
            num = Integer.parseInt(tk.nextToken())
        }
    }
    tk = StringTokenizer(br.readLine())
    val (start,end) = List(2){Integer.parseInt(tk.nextToken())}
    write("${bfs(graph,visited,start,end,n)}")
    close()

}
