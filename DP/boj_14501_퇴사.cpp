//https://www.acmicpc.net/problem/14501
package com.example.hellokotlin

import java.io.File

//val path = "C:\\Kotlin\\HelloKotlin\\app\\src\\main\\java\\com\\example\\hellokotlin\\input.txt"
//val br = File(path).bufferedReader()
val path= "C:\\Kotlin\\HelloKotlin\\app\\src\\main\\java\\com\\example\\hellokotlin\\input.txt"
val br = File(path).bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    val n = Integer.parseInt(br.readLine())
    val dp = Array<ArrayList<Int>>(n+1){ArrayList<Int>()}
    dp[1].add(1)
    for(i in 2 .. n){
        for(it in dp[i-1].indices){
            dp[i].add(dp[i-1][it])
        }
        if(i%3==0){
            if(dp[i].size>dp[i/3].size){
                dp[i].clear()
                for(it in dp[i/3].indices){
                    dp[i].add(dp[i/3][it])
                }
            }
        }
        if(i%2==0) {
            if (dp[i].size > dp[i / 2].size) {
                dp[i].clear()
                for(it in dp[i/2].indices){
                    dp[i].add(dp[i/2][it])
                }
            }
        }
        dp[i].add(i)
    }
    write("${dp[n].size-1}\n")


    close()
}
