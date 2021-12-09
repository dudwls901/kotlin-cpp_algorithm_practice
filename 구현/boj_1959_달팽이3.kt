//https://www.acmicpc.net/problem/1959
import kotlin.math.*
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    br.readLine().split(' ').map{it.toLong()}.also{
        val m =it[0]
        val n = it[1]
        if(m==n){
            write("${2*(n-1)}\n")
            if(m%2==0L){
                write("${(m/2)+1} ${n/2}")
            }
            else{
                write("${(m/2)+1} ${(m/2)+1}")
            }
        }
        else {
            if(m>n){
                write("${2 * (min(n, m) - 1) + 1}\n")
            }
            else{
                write("${2*(m-1)}\n")
            }
            if(min(m,n)%2==0L){
                write("${min(m,n)-(min(m,n)/2-1)} ${min(m,n)-min(m,n)/2}")
            }
            else{
                write("${m-(min(m,n)/2)} ${n-(min(m,n)/2)}")
            }
        }
    }
    close()
}
