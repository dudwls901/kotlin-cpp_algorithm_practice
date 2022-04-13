//https://www.acmicpc.net/problem/1068
import java.util.*

val br = System.`in`.bufferedReader()
lateinit var edge: Array<ArrayList<Int>>
var answer = 0
var delete = 0
fun dfs(cur: Int){
    if(cur==delete) return
    if(edge[cur].isEmpty()){
        answer++
        return
    }
    else{
        var isLeaf = true
        for(next in edge[cur]){
            if(next==delete) continue
            dfs(next)
            isLeaf = false
        }
        if(isLeaf){
            answer++
            return
        }
    }
}

fun main() = with(System.out.bufferedWriter()){

    //input
    val n = br.readLine().toInt()
    var root =0
    edge = Array(n){ArrayList()}
    val tk = StringTokenizer(br.readLine())
    for(i in 0 until n){
        val num = tk.nextToken().toInt()
        if(num<0){
            root = i
        }
        else{
            edge[num].add(i)
        }
    }
    delete = br.readLine().toInt()

    //solve
    dfs(root)

    //output
    write("$answer")
    close()
}
