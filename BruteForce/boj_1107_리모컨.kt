//https://www.acmicpc.net/problem/1107

import java.util.StringTokenizer
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

var answer=0
val nopeSet = mutableSetOf<Int>()
fun main() = with(System.out.bufferedWriter()) {
    //start 100
    val br = BufferedReader(InputStreamReader(System.`in`))
      val input = br.readLine()
    val goal = Integer.parseInt(input)
    val goalLen =input.length
    var n = Integer.parseInt(br.readLine())
    var answer = abs(goal-100)
    val nope = BooleanArray(10)
    if(n!=0) {
        val tk = StringTokenizer(br.readLine())
        while (n-- != 0) {
            nope[Integer.parseInt(tk.nextToken())]=true
        }
    }
    else{
        write("${min(goalLen,answer)}")
        close()
        return
    }

    if(n==10){
        write("$answer")
        close()
        return
    }
    for( i in 0 .. 1000000){
        var num =i
        var canCheck =true
        var cnt=0
        while(num>0){
            if(nope[num%10]){
                canCheck=false
                break
            }
            cnt++
            num/=10
        }
        if(i==0) {
            cnt = 1
            if(nope[i]) {
                canCheck = false
            }
        }
        if(canCheck){
            answer = min(answer, abs(goal-i)+cnt)
        }
    }
    write("$answer")
    close()
}
