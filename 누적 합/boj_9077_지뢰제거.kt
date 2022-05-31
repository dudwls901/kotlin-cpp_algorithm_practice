//https://www.acmicpc.net/problem/9077
//누적 합
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
val preSum = Array(10000){IntArray(10000)}

fun main() = with(System.out.bufferedWriter()){
    repeat(getInt()){//t
        var answer = 0
        repeat(getInt()){//n
            val (x,y) = getIntList()
            //solve
            for(x in x .. (x+10).coerceAtMost(9999)){
                for(y in y .. (y+10).coerceAtMost(9999)){
                    answer = answer.coerceAtLeast(++preSum[x][y])
                }
            }
        }
        //output
        write("$answer\n")
        //reset
        for(i in 0 until 10000){
            for(j in 0 until 10000){
                preSum[i][j] = 0
            }
        }
    }
    close()
}
//완탐
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var mine: Array<Pair<Int, Int>>
lateinit var graph: Array<BooleanArray>

fun main() = with(System.out.bufferedWriter()) {

    val T = getInt()

    for (t in 1..T) {
        //input
        var answer = 0
        val n = getInt()
        mine = Array(n) { Pair(0, 0) }
        graph = Array(10000) { BooleanArray(10000) }
        for (i in 0 until n) {
            val (c, r) = getIntList()
            mine[i] = Pair(r, c)
            graph[r][c] = true
        }
        //solve
        mine.forEach {
            val (r, c) = it
            //100개의 사각형 테두리 좌표를 기준으로 사각형 그려보기
            for (i in 0..10) {
                for (j in 0..10) {
                    val cr = r - i
                    val cc = c - j
                    var cnt = 0
                    for (a in 0..10) {
                        for (b in 0..10) {
                            val nr = cr + a
                            val nc = cc + b
                            if (nr !in 0 until 10000 || nc !in 0 until 10000) continue
                            if (graph[nr][nc]) cnt++
                        }
                    }
                    answer = answer.coerceAtLeast(cnt)
                    //기준은 테두리로만 자으면 됨
                    if(i!=0 && i!=10 ) break
                }
            }
        }
        //output
        write("$answer\n")
    }
    close()
}
