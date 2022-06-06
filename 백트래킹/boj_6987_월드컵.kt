//https://www.acmicpc.net/problem/6987
import java.util.*
val br = System.`in`.bufferedReader()

val team1 = IntArray(15)
val team2 = IntArray(15)
var input = Array(6) { IntArray(3) }
var canMatch = 0
fun backTracking(game: Int) {

    if (canMatch == 1) return

    //end
    if (game == 15) {
        canMatch = 1
        return
    }

    val t1 = team1[game]
    val t2 = team2[game]

    //win
    input[t1][0]--
    input[t2][2]--
    if(input[t1][0]>=0 && input[t2][2] >=0) {
        backTracking(game + 1)
    }
    input[t1][0]++
    input[t2][2]++
    //draw
    input[t1][1]--
    input[t2][1]--
    if(input[t1][1]>=0 && input[t2][1] >=0) {
        backTracking(game + 1)
    }
    input[t1][1]++
    input[t2][1]++
    //lose
    input[t1][2]--
    input[t2][0]--
    if(input[t1][2]>=0 && input[t2][0] >=0) {
        backTracking(game + 1)
    }
    input[t1][2]++
    input[t2][0]++

}

fun main() = with(System.out.bufferedWriter()) {

    //preset
    var cnt = 0
    for (i in 0 until 6) {
        for (j in i + 1 until 6) {
            team1[cnt] = i
            team2[cnt] = j
            cnt++
        }
    }
    //input
    for (i in 0 until 4) {
        val tk = StringTokenizer(br.readLine())
        val info = IntArray(3)
        var drawCnt=0
        for (i in 0 until 6) {
            for (j in 0 until 3) {
                input[i][j] = tk.nextToken().toInt()
                info[j] +=input[i][j]
            }
            if(input[i][1]>0) drawCnt++
        }
        if (info[0] != info[2] || drawCnt == 1 || info[0] + info[1] + info[2] != 30) {
            write("0 ")
            continue
        }
        canMatch = 0
        //solve
        backTracking(0)
        //output
        write("$canMatch ")
    }
    close()
}
