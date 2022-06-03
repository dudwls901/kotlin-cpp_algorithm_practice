//https://www.acmicpc.net/problem/2661
import java.util.*
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

//무조건 1로 시작
//가장 작은 수
//1<= n<=80
//비교 함수
//백트래킹 가지치기 -> 비교 함수
//삽입 순서는 ? 123으로 하면 가능
var answer = ""
fun canAdd(result: StringBuilder) : Boolean {
    for(len in 1 .. result.length/2){
        var idx = result.length-len
        val ls = idx-len
        if(ls < 0) break
        val left = result.substring(ls,idx)
        val right = result.substring(idx,result.length)
//        println("$result $left $right ls : $ls idx : $idx")
        if(left==right) return false
    }
    return true
}

fun backTracking(n: Int, result: StringBuilder){
    if(answer.isNotEmpty()) return
    if(result.length == n){
        answer = result.toString()
        return
    }

    for(num in 1 .. 3){
        if(answer.isNotEmpty()) return
        result.append(num)
        if(canAdd(result)){
            backTracking(n, result)
        }
        result.deleteCharAt(result.lastIndex)
    }
}
fun main() = with(System.out.bufferedWriter()) {

    //input
    val n = getInt()
    //solve
    backTracking(n,StringBuilder())
    //output
    write(answer)
    close()
}
