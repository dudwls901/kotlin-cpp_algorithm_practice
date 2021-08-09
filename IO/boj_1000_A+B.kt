//https://www.acmicpc.net/problem/1000

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())
    print(token.nextToken().toInt() + token.nextToken().toInt())
}
