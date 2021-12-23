//https://www.acmicpc.net/problem/11723
import java.util.*
val br = System.`in`.bufferedReader()
var arr = IntArray(21)
fun add(num : Int){
    arr[num]=1
}
fun remove(num : Int){
    arr[num]=0
}
fun check(num : Int) :Int{
    return arr[num]
}
fun toggle(num : Int){
    arr[num] = arr[num] xor 1
}
fun all(){
    arr = IntArray(21){1}
}
fun empty(){
    arr = IntArray(21)
}
fun main() =with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    for(i in 0 until n) {
        val tk = StringTokenizer(br.readLine())
        val input = Array<String>(2){""}
        var idx=0
        while(tk.hasMoreTokens()){
            input[idx++]=tk.nextToken()
        }
        when {
            input[0] == "add" -> add(input[1].toInt())
            input[0] == "remove" -> remove(input[1].toInt())
            input[0] == "check" -> write("${ check(input[1].toInt())}\n")
            input[0] == "toggle" -> toggle(input[1].toInt())
            input[0] == "all" -> all()
            else -> empty()
        }
    }
    close()
}
