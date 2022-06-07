//https://www.acmicpc.net/problem/2469
import java.util.*
val br = System.`in`.bufferedReader()

fun getInt() = br.readLine().toInt()

lateinit var graph: Array<String>
var lineNum = -1

fun swap(c: Int, sb: StringBuilder){
    sb[c] = sb[c+1].also { sb[c+1] = sb[c] }
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val k = getInt()
    val n = getInt()
    var before = StringBuilder()
    for(i in 0 until k){
        before.append('A'+i)
    }
    var after = StringBuilder(br.readLine())
    graph = Array(n){
        val line = br.readLine().apply{
            if(contains('?')){
                lineNum = it
            }
        }
        line
    }
    //solve
    //위에서부터 ?까지 순서 변경
    for(r in 0 until lineNum){
        for(c in 0 until k-1){
            if(graph[r][c]=='-'){
                swap(c,before)
            }
        }
    }
    //아래서부터 ?까지 순서 변경
    for(r in n-1 downTo lineNum){
        for(c in 0 until k-1){
            if(graph[r][c]=='-'){
                swap(c,after)
            }
        }
    }
    //before after비교하여 다른 문자가 있으면 swap, -추가, 같으면 *추가
    val result = StringBuilder()
    for(i in 0 until k-1){
        if(before[i] != after[i]){
            swap(i,before)
            result.append('-')
        }
        else{
            result.append('*')
        }
    }
    //output
    //값이 같으면 result 출력, 다르면 *****
    if(before.toString() == after.toString())
        write("$result")
    else{
        for(i in 0 until k-1){
            write("x")
        }
    }

    close()
}
