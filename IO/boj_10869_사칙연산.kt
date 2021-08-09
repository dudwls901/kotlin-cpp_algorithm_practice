//https://www.acmicpc.net/problem/10869

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())
    val a = Integer.parseInt(token.nextToken())
    val b = Integer.parseInt(token.nextToken())
    println(a+b)
    println(a-b)
    println(a*b)
    println(a/b)
    println(a%b)
//Integer.parseInt() faster than .toInt()
//  print("""${a+b}
// ${a-b}
// ${a*b}
// ${a/b}
// ${a%b}
// """)
}
