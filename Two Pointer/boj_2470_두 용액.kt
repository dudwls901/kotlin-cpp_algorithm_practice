//https://www.acmicpc.net/problem/2470
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getStr() = br.readLine().trim()
fun getInt() = br.readLine().trim().toInt()


fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    val list = getIntList().sorted()

    //solve
    var s = 0
    var e = list.size-1
    var answer = Int.MAX_VALUE
    var left = 0
    var right = 0
    while(s<e){
        val sum = list[s] + list[e]
        val absSum = Math.abs(sum)
        if(answer > absSum){
            answer = absSum
            left = list[s]
            right = list[e]
        }
        if(sum > 0){
            e--
        }else{
            s++
        }
    }
    //output
    write("$left $right")
    close()
}
