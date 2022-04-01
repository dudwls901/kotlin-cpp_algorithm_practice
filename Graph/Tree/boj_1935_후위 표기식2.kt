//https://www.acmicpc.net/problem/1935
import java.util.*

val br = System.`in`.bufferedReader()

val set = DoubleArray(200)

fun cal(l: Double, r: Double, ch: Char): Double = when(ch){
    '*'->{
        l*r
    }
    '-'->{
        l-r
    }
    '+'->{
        l+r
    }
    else->{
        l/r
    }
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = br.readLine().toInt()
    val input = br.readLine()
    val stk = Stack<Double>()
    for(i in 0 until n){
        //char to int (to.int())는 deprecated => .code로 대응
        ('A'+i).code
        set[('A'+i).code] = br.readLine().toDouble()
    }

    //solve 후위->중위
    for(ch in input){
        if(ch.isLetter()){
            stk.push(set[ch.code])
        }
        else{
            val r =stk.pop()
            val l = stk.pop()
            stk.push(cal(l,r,ch))
        }
    }
    //output
    write(String.format("%.2f",stk.pop()))
    close()
}
