//https://www.acmicpc.net/problem/1806
import java.util.StringTokenizer
import kotlin.math.*
const val INF = 987654321

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var tk = StringTokenizer(br.readLine())
    var answer = INF
    val (N,S)= List(2){Integer.parseInt(tk.nextToken())}
    tk = StringTokenizer(br.readLine())
    val sum = LongArray(N+1)
    for(i in 1 .. N){
        sum[i] = sum[i-1]+tk.nextToken().toLong()
    }
    var s =0
    var e =0
    while(s<N){
        if(sum[e]-sum[s]>=S){
            answer=min(answer,e-s)
            s++
        }
        else{
            if(e<N){
                e++
            }
            else{
                s++
            }
        }
    }
    if(answer==INF)
        write("0")
    else
        write("$answer")
    close()
}
