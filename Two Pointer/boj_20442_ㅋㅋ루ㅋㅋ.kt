//https://www.acmicpc.net/problem/20442
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {

    //input
    val input = br.readLine()
    //R인 인덱스 기준으로 좌,우로 K의 개수 따로 저장
    //R의 개수만큼 leftK, rightK 저장됨
    val leftK = ArrayList<Int>()
    val rightK = ArrayList<Int>()
    var cnt = 0
    for (i in input.indices) {
        if (input[i] == 'K') cnt++
        else leftK.add(cnt)
    }
    cnt = 0
    for (i in input.length - 1 downTo 0) {
        if (input[i] == 'K') cnt++
        else rightK.add(cnt)
    }
    //rightK[0] == 맨 오른쪽 R 기준 오른쪽 K의 개수가 저장된 상태, 뒤집어서 LeftK와 맞춰주기
    rightK.reverse()

    //solve - twoPointer
    var s = 0
    var e = leftK.size - 1 // ==rifgtK.size-1
    var answer = 0
    while (s <= e) {
        //e-s+1 == 기준으로 잡은 e와 s 사이의 r개수
        //leftK[s].coerceAtMost(rightK[e]) == s와 e (왼쪽 R과 오른쪽 R)을 기준으로 했을 때 s 왼쪽 k 개수와 e 오른쪽 k 개수 중 작은 값
        answer = answer.coerceAtLeast((e - s + 1) + leftK[s].coerceAtMost(rightK[e]) * 2)
        if (leftK[s] < rightK[e]) s++
        else e--
    }
    //output
    write("$answer")

    close()
}
