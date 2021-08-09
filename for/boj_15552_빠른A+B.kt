//https://www.acmicpc.net/problem/15552
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.io.BufferedWriter
import java.io.OutputStreamWriter
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = Integer.parseInt(br.readLine())
    for(i in 0 until t){
        val token = StringTokenizer(br.readLine())
        bw.write("${Integer.parseInt(token.nextToken()) + Integer.parseInt(token.nextToken())}\n")
    }
    bw.flush()
    br.close()
}
