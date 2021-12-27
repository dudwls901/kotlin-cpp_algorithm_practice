//https://www.acmicpc.net/problem/17219
import java.util.*
val br = System.`in`.bufferedReader()
fun main() = with(System.out.bufferedWriter()){
    val (n,m) =br.readLine().split(' ').map{it.toInt()}
    val map = HashMap<String,String>()
    for(i in 0 until n){
        val tk = StringTokenizer(br.readLine())
        val key = tk.nextToken()
        val value = tk.nextToken()
        map[key]=value
    }

    for(i in 0 until m){
        write("${map[br.readLine()]}\n")
    }
    close()
}
