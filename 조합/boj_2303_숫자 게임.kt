//https://www.acmicpc.net/problem/2303
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()) {
    var maxNum = 0
    var maxIdx = 0
    repeat(getInt()){
        val input = getIntList()
        val eachMaxNum = combination(0,0,0,input)
        if(maxNum<=eachMaxNum) {
            maxNum = eachMaxNum
            maxIdx = it+1
        }
    }
    write("$maxIdx")

    close()
}

fun combination(idx: Int, len: Int, sum: Int, input: List<Int>): Int {
    if(len == 3){
        return sum%10
    }
    var result = 0
    for(i in idx until input.size){
        result = result.coerceAtLeast(combination(i+1, len+1, sum+input[i],input))
    }
    return result
}
