//https://www.acmicpc.net/problem/2753

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val year = Integer.parseInt(BufferedReader(InputStreamReader(System.`in`)).readLine())
    println(when{
        (year%4==0 &&year%100!=0)|| year%400==0 -> '1'
        else -> '0'
    }
    )
}
