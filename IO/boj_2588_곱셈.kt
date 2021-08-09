//https://www.acmicpc.net/problem/2588

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = Integer.parseInt(br.readLine())
    val b = br.readLine()
    println(a*(b[2]-'0'))
    println(a*(b[1]-'0'))
    println(a*(b[0]-'0'))
    println(a*Integer.parseInt(b))
}
