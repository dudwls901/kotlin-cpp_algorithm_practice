//https://www.acmicpc.net/problem/8393
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val num = Integer.parseInt(BufferedReader(InputStreamReader(System.`in`)).readLine())
    var ans=1
    for(i in 2 .. num)
       ans+=i
    println(ans)
}
