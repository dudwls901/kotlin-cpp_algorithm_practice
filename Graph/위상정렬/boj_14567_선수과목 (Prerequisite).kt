//https://www.acmicpc.net/problem/14567
import java.util.*

val br = System.`in`.bufferedReader()
lateinit var inDegree: IntArray
lateinit var edge: Array<ArrayList<Int>>
lateinit var answer: IntArray
fun topologicalSort(n: Int){
    val q: Queue<Int> = LinkedList()
    for(i in 1 .. n){
        if(inDegree[i]==0){
            q.add(i)
            answer[i]=1
        }
    }
    var turn = 2
    while(q.isNotEmpty()){
        val size = q.size
        for(i in 0 until size) {
            val cur = q.poll()
            for (next in edge[cur]) {
                if (--inDegree[next] == 0) {
                    q.add(next)
                    answer[next] = turn
                }
            }
        }
        turn++
    }

}

fun main() = with(System.out.bufferedWriter()){

    //input
    val (n,m) = br.readLine().split(' ').map{it.toInt()}

    inDegree = IntArray(n+1)
    edge = Array(n+1){ ArrayList() }
    answer = IntArray(n+1)
    for(i in 0 until m){
        val (from, to) =br.readLine().split(' ').map{it.toInt()}
        inDegree[to]++
        edge[from].add(to)
    }
    //solve
    topologicalSort(n)

    //output
    for(i in 1 .. n){
        print("${answer[i]} ")
    }

    close()
}
