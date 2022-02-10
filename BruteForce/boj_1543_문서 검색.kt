//https://www.acmicpc.net/problem/1543
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    val line = br.readLine()
    val pattern = br.readLine()
    var answer=0
    var i=0
    while(i <= line.length-pattern.length){
        var idx=0
        while(idx<pattern.length && pattern[idx]==line[i+idx]){
            idx++
        }
        if(idx==pattern.length){
            answer++
            i+=idx
        }
        else{
            i++
        }

    }
    write("$answer")
    close()
}
