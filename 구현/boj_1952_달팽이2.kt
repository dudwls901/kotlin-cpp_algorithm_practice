//https://www.acmicpc.net/problem/1952
import kotlin.math.*
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    br.readLine().split(' ').map{it.toInt()}.also{
        val m =it[0]
        val n = it[1]
        if(m==n){
            write("${2*(n-1)}")
        }
        else {
            if(m>n){
                write("${2 * (min(n, m) - 1) + 1}")
            }
            else{
                write("${2*(m-1)}")
            }

        }
    }
    close()
}
