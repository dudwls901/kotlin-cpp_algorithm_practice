//https://www.acmicpc.net/problem/11441
import java.util.StringTokenizer

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    var tk = StringTokenizer(br.readLine())
    val sum = IntArray(n+1){0}
    for(i in 1 .. n){
        sum[i] = sum[i-1]+ Integer.parseInt(tk.nextToken())
    }

    val m = Integer.parseInt(br.readLine())
    for(i in 0 until m){
        tk = StringTokenizer(br.readLine())
        val (a,b) = List(2){Integer.parseInt(tk.nextToken())}
        write("${sum[b]-sum[a-1]}\n")
    }
    close()
}
