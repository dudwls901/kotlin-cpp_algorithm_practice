//https://www.acmicpc.net/problem/14889
import java.lang.Math.*
import java.util.StringTokenizer
import kotlin.system.exitProcess
val br = System.`in`.bufferedReader()
lateinit var graph: Array<List<Int>>
lateinit var visited: BooleanArray
var answer=Int.MAX_VALUE
fun compareScore(n: Int): Int{
    var sum1=0
    var sum2=0
    //팀1
    for(i in 0 until n-1){
        for(j in i+1 until n){
            if(visited[i] && visited[j]){
                sum1+=graph[i][j] + graph[j][i]
            }
            else if(!visited[i] && !visited[j]){
                sum2+=graph[i][j]  + graph[j][i]
            }
        }
    }
    return abs(sum1-sum2)
}

fun combination(idx: Int, len: Int ,n:Int){
    if(len==n/2){
        answer = answer.coerceAtMost(compareScore(n))
        if(answer==0){
            println(0)
            exitProcess(0)
        }
        return
    }

    for(i in idx until n){
        visited[i] = true
        combination(i+1,len+1,n)
        visited[i] = false
    }

}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val n = br.readLine().toInt()
    graph = Array(n) { br.readLine().split(' ').map{it.toInt()} }
    visited = BooleanArray(n)

    //solve
    combination(0,0,n)
    //output
    write("$answer")
    close()
}
