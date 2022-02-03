//https://www.acmicpc.net/problem/10158
import java.util.*
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var tk = StringTokenizer(br.readLine())
    val x = tk.nextToken().toInt()
    val y = tk.nextToken().toInt()
    tk = StringTokenizer(br.readLine())
    var p = tk.nextToken().toInt()
    var q = tk.nextToken().toInt()
    val t= br.readLine().toInt()
    p = (t+p)%(x*2)
    q = (t+q)%(y*2)
    if(p>x){
        p = 2*x-p
    }
    if(q>y){
        q = 2*y-q
    }
    write("$p $q")

    close()
}
