//https://www.acmicpc.net/problem/12919
import java.util.*
val br = System.`in`.bufferedReader()
var answer = 0
fun convertTToS(s: String, t: StringBuilder){
    if(s.length == t.length){
        if(s==t.toString()){
            answer=1
        }
        return
    }
    val e = t.lastIndex

    if(t[e]=='A'){
        t.deleteCharAt(t.lastIndex)
        convertTToS(s,t)
        t.append('A')
    }
    if(t[0]=='B'){
        t.reverse()
        t.deleteCharAt(e)
        convertTToS(s,t)
        t.append('B')
        t.reverse()
    }
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val s = br.readLine()
    val t = StringBuilder(br.readLine())
    //solve
    convertTToS(s,t)
    //output
    write("$answer")
    close()
}
