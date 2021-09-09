//www.acmicpc.net/problem/2252
import java.util.*
fun topologicalSort(inDegree : IntArray , edge : Array<ArrayList<Int>>, n : Int){
    val q : Queue<Int> = LinkedList<Int>()
    for(i in 1 .. n){
        if(inDegree[i]==0){
            print("$i ")
            q.add(i)
        }
    }
    while(q.isNotEmpty()){
        val cur = q.poll()
        for(i in edge[cur].indices){
            val next = edge[cur][i]
            if(--inDegree[next]==0){
                q.add(next)
                print("$next ")
            }
        }
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var tk = StringTokenizer(br.readLine())
    // 1<= n <=32000
    // 1<= m <=100000
    val (n,m) = List(2){Integer.parseInt(tk.nextToken())}
    val inDegree = IntArray(n+1)
    val edge = Array<ArrayList<Int>>(n+1){ArrayList<Int>()}
    for(i in 0 until m){
        tk = StringTokenizer(br.readLine())
        val (from, to) = List(2){Integer.parseInt(tk.nextToken())}
        inDegree[to]++
        edge[from].add(to)
    }
    topologicalSort(inDegree,edge,n)
    close()
}
