//https://www.acmicpc.net/problem/18311
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    var tk = StringTokenizer(br.readLine())
    val n = tk.nextToken().toInt()
    val k = tk.nextToken().toLong()
    val input = LongArray(2*n)
    tk = StringTokenizer(br.readLine())
    for(i in 0 until n){
        input[i] = tk.nextToken().toLong()
    }
    for(i in n until input.size){
        input[i] = input[input.size-i-1]
    }
    //solve
    var answer =0
    var sum=0L
    for(i in input.indices){
        sum+=input[i]
        if(sum>k){
            answer = i
            break
        }
    }
    //output
    write("${if(answer>=n) n*2-answer else answer+1}")

    close()
}
