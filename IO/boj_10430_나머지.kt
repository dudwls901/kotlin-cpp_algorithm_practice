//https://www.acmicpc.net/problem/10430

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.io.BufferedWriter
import java.io.OutputStreamWriter
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val token = StringTokenizer(br.readLine())
    val a = Integer.parseInt(token.nextToken())
    val b = Integer.parseInt(token.nextToken())
    val c = Integer.parseInt(token.nextToken())
    bw.write("${(a+b)%c}\n")
    bw.write("${(a%c+b%c)%c}\n")
    bw.write("${(a*b)%c}\n")
    bw.write("${((a%c)*(b%c))%c}\n")
    br.close()
    bw.close()
}
