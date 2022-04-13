//https://www.acmicpc.net/problem/13913
import java.util.*

val br = System.`in`.bufferedReader()

const val MAX = 200001
val visited = IntArray(MAX){-1}
val dir = arrayOf(1,-1)
fun bfs(n: Int, k: Int): Int{
    val q: Queue<Int> = LinkedList()
    q.add(n)
    var time=0
    if(n==k) return 0
    while(q.isNotEmpty()){
        val size = q.size
        for(i in 0 until size){
            val cur = q.poll()
           for(j in 0 until 3){
               var next = -1
               if(j==2){
                   next = cur* 2
               }
               else {
                   next = cur + dir[j]
               }
               if(next==k){
                   visited[next] = cur
                   return time+1
               }

               if(next !in 0 until MAX) continue
               if(visited[next]!=-1) continue
               visited[next] = cur
               q.add(next)
           }
        }
        time++
    }
    return 0
}

fun main() = with(System.out.bufferedWriter()){

    //input
    var (n,k) = br.readLine().split(' ').map{it.toInt()}

    //solve, output
    write("${bfs(n,k)}\n")

    var answerArr = ArrayList<Int>()
    answerArr.add(k)
    if(n!=k) {
        while (true) {
            answerArr.add(visited[k])
            k = visited[k]
            if (k == n || k == -1) break
        }
    }
    for(i in answerArr.size-1 downTo 0 step 1){
        write("${answerArr[i]} ")
    }
    close()
}
