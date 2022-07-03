//https://www.acmicpc.net/problem/14891
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

val wheel = Array<String>(4) { "" }
val wheelState = BooleanArray(3)
var answer = 0

fun cal() {

    for (i in wheel.indices) {
        val score = Math.pow(2.0, i.toDouble())
        if (wheel[i][0] == '1') {
            answer += score.toInt()
        }
    }
}

fun rotate(i: Int, dir: Int) {
    when (dir) {
        //시계
        1 -> {
            wheel[i] =
                wheel[i][wheel[i].lastIndex].toString() + wheel[i].substring(0, wheel[i].lastIndex)
        }
        //반시계
        else -> {
            wheel[i] = wheel[i].substring(1) + wheel[i][0].toString()
        }
    }
}

fun simulation(num: Int, dir: Int) {
    for (i in 0 until wheel.size - 1) {
        val left = wheel[i][2]
        val right = wheel[i + 1][6]
        wheelState[i] = left == right //false면 맞물린 상태
    }
    //0,1,2에 맞물린 상태 저장되어 있음

    //본인 rotate
    rotate(num, dir)

    //왼 쪽
    var newDir = dir
    var curNum = num-1

    while (curNum >= 0) {
        if (!wheelState[curNum]) {
            newDir = if (newDir == -1) 1 else -1
            rotate(curNum, newDir)
        } else break
        curNum--
    }
    //오른 쪽
    newDir = dir
    curNum = num+1
    while (curNum <= 3) {
        if (!wheelState[curNum-1]) {
            newDir = if (newDir == -1) 1 else -1
            rotate(curNum, newDir)
        } else break
        curNum++
    }

}

fun main() = with(System.out.bufferedWriter()) {

    for (i in 0 until 4) {
        wheel[i] = br.readLine()
    }
    val k = getInt()
    repeat(k) {
        val query = getIntList()
        simulation(query[0] - 1, query[1])
    }

    cal()
    write("${answer}")
    close()
}
