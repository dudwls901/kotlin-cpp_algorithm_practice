//https://www.acmicpc.net/problem/14681

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val x = Integer.parseInt(br.readLine())
    val y = Integer.parseInt(br.readLine())
    print(when{
        x>0 -> if(y>0) 1 else 4
        else -> if(y>0) 2 else 3
    })
}
