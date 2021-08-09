//https://www.acmicpc.net/problem/10950

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine()
    for(i in 0 until t){
        val token = StringTokenizer(br.readLine())
        println(Integer.parseInt(token.nextToken()+Integer.parseInt(token.nextToken()))
    }
}
