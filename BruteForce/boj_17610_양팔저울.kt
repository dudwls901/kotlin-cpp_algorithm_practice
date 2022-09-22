//https://www.acmicpc.net/problem/17610
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

lateinit var isExisted: BooleanArray

fun solve(idx: Int, weight: Int, input: List<Int>) {
    
    if (idx >= input.size) {
        isExisted[weight] = true
        return
    }
    solve(idx + 1, weight, input)
    solve(idx + 1, weight + input[idx], input)
    solve(idx + 1, Math.abs(weight - input[idx]), input)
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val k = getInt()
    val input = getIntList()
    val max = input.maxOf { it } * k
    val sum = input.sum()
    isExisted = BooleanArray(max + 1)
    var answer = 0

    //solve
    solve(0, 0, input)
    for (i in 1..sum) {
        if (!isExisted[i]) answer++
    }
    //output
    write("$answer")

    close()
}
