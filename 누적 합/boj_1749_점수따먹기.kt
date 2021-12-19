//https://www.acmicpc.net/problem/1749
import kotlin.math.*
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    var answer =-987654321
    val arr = Array(n){
        br.readLine().split(' ').map{it.toInt()}
    }
    val pSum = Array(n+1){IntArray(m+1)}

    for(i in 1 .. n){
        for(j in 1 .. m){
            pSum[i][j] = arr[i-1][j-1]+pSum[i-1][j]+pSum[i][j-1]-pSum[i-1][j-1]
        }
    }

    for(i in 1 .. n){
        for(j in 1 .. m){
            for(ii in i .. n){
                for(jj in j .. m){
                    answer = max(answer,pSum[ii][jj]-pSum[ii][j-1]-pSum[i-1][jj] + pSum[i-1][j-1] )
                }
            }
        }
    }
    write("$answer")
    close()
}
