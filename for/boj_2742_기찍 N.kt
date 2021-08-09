//https://www.acmicpc.net/problem/15552
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
fun main(){
    val n = Integer.parseInt(BufferedReader(InputStreamReader(System.`in`)).readLine())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for(i in n.downTo(1))
        bw.write("$i\n")
    bw.close()
}
