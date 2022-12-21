//https://www.acmicpc.net/problem/20159
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()) {

    //input
    val n = getInt()
    val list = getIntList()
    val oddSum = IntArray(list.size)
    val evenSum = IntArray(list.size)

    for (i in list.indices) {
        if (i and 1 == 0) {
            if (i - 2 >= 0) {
                evenSum[i] = evenSum[i - 2] + list[i]
            } else {
                evenSum[i] = list[i]
            }
        } else {
            if (i - 2 >= 0) {
                oddSum[i] = oddSum[i - 2] + list[i]
            } else {
                oddSum[i] = list[i]
            }
        }
    }
    //solve
    var answer = 0
    for (i in list.indices) {
        var sum = 0
        if(i and 1 == 0){ // 내 턴에 밑장 빼기
            sum += if (i >= 2) evenSum[i - 2] else 0
            sum += if(i>=2) (oddSum[n-1] - oddSum[i-1]) else oddSum[n-1]
        }
        else{
            //상대 턴에 밑장 빼기
            sum += if(i>=2)oddSum[n-1]-oddSum[i-2] - list[n-1] else oddSum[n-1] - list[n-1]
            sum += evenSum[i-1]
        }
        answer = answer.coerceAtLeast(sum)
    }
    write("$answer")
    close()
}
