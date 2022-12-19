//https://www.acmicpc.net/problem/19949
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
lateinit var answers: List<Int>
var answer = 0
fun main() = with(System.out.bufferedWriter()){
    answers = getIntList()

    bruteForce(0,0,0,0)
    write("$answer")
    close()
}

fun bruteForce(cnt: Int, idx: Int, before: Int, bbefore: Int) {

    if(idx == 10) {
        if(cnt >=5){
            answer++
        }
        return
    }

    for(i in 1 .. 5){
        val nextCnt = if(answers[idx] == i) cnt+1 else cnt
        if(before == bbefore && before == i) continue
        bruteForce(nextCnt, idx+1, i, before)
    }
}
