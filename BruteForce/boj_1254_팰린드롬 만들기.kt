//https://www.acmicpc.net/problem/1254
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    //input
    val input = br.readLine()
    var answer = input.length
    //solve
    for(i in input.indices){
        var left = i
        var right = input.length-1
        while(left <right && input[left]==input[right]){
            left++
            right--
        }
        if(left>=right){
            answer+=i
            break
        }
    }
    write("$answer")

    close()
}
