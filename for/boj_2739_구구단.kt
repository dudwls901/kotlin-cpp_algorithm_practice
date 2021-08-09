//https://www.acmicpc.net/problem/2739
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val num = Integer.parseInt(BufferedReader(InputStreamReader(System.`in`)).readLine())
    for(i in 1 ..9){
        println("$num * $i = ${num*i}")
    }
}
