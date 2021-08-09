//https://www.acmicpc.net/problem/9498

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())
    val num = Integer.parseInt(token.nextToken())
    when{
        num>=90 -> print('A')
        num>=80 -> print('B')
        num>=70 -> print('C')
        num>=60 -> print('D')
        else -> print('F')
    }
}
