//https://www.acmicpc.net/problem/20207
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    val calendar = IntArray(367)
    var end = 0
    repeat(n){
        //solve
        //누적 합 정보들을 모아뒀다가 한 번에 계산
        val (from, to) = getIntList()
        calendar[from]++
        calendar[to+1]--
        end = end.coerceAtLeast(to)
    }
    //preSum
    //누적 합 적용
    for(i in 1 .. end){
        calendar[i] += calendar[i-1]
    }
    //코팅지 면적 구하기 (0)나오면 계산
    var x = 0
    var y = 0
    var answer=0
    for(i in 1 .. end){
        if(calendar[i]==0){
            answer +=x*y
            x = 0
            y = 0
        }
        else{
            x++
            y = y.coerceAtLeast(calendar[i])
        }
    }

    write("${answer + x*y}")

    close()
}
