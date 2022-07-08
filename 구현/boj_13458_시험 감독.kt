//https://www.acmicpc.net/problem/13458
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

//총 감독관은 무조건 한명 이상
//총 감독관 한명 세우고
//1 아직 남은 경우 부 감독관으로 나누기
//2 없는 경우 패스

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    var answer = n.toLong()
    val input = getIntList()
    val (b,c) = getIntList()
    //solve
    input.forEach { num->
        if (num - b > 0){
            answer += (num - b) / c
            if ((num - b) % c != 0) answer++
        }
    }
    //output
    write("$answer")
    close()
}
