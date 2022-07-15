//https://www.acmicpc.net/problem/20061
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

val blue = Array(6) { IntArray(4) }
val green = Array(6) { IntArray(4) }
var answer = 0
var sumAnswer = 0
fun changeRC(r: Int, c: Int): Pair<Int, Int> {
    val rr = c
    val cc = 3 - r
    return Pair(rr, cc)
}

lateinit var temp: Array<IntArray>

fun makeBlock(t: Int, x: Int, y: Int): Array<IntArray> {
    if (t == 1) {
        temp = Array(1) { intArrayOf(x, y) }
    } else if (t == 2) {
        temp = Array(2) { IntArray(2) }
        temp[0] = intArrayOf(x, y)
        temp[1] = intArrayOf(x, y + 1)
    } else {
        temp = Array(2) { IntArray(2) }
        temp[0] = intArrayOf(x, y)
        temp[1] = intArrayOf(x + 1, y)
    }
    return temp
}

fun move(color: String, horizon: Boolean, block: Array<IntArray>) {
    val y = block[0][1]
    when (color) {
        "green" -> {
            for (r in 0..5) {
                if (horizon) {
                    val y2 = block[1][1]
                    if (green[r][y] + green[r][y2] != 0) {
                        if (r - 1 >= 0) {
                            green[r - 1][y] = 1
                            green[r - 1][y2] = 1
                        }
                        break
                    }
                    if (r == 5) {
                        green[r][y] = 1
                        green[r][y2] = 1
                    }
                } else {
                    if (green[r][y] == 1) {
                        if (r - 1 >= 0) green[r - 1][y] = 1
                        if (r - 2 >= 0 && block.size > 1) green[r - 2][y] = 1
                        break
                    }
                    if (r == 5) {
                        green[r][y] = 1
                        if (block.size > 1) green[r - 1][y] = 1
                    }
                }
            }
        }
        "blue" -> {
            for (r in 0..5) {
                if (horizon) {
                    val y2 = block[1][1]
                    if (blue[r][y] + blue[r][y2] != 0) {
                        if (r - 1 >= 0) {
                            blue[r - 1][y] = 1
                            blue[r - 1][y2] = 1
                        }
                        break
                    }
                    if (r == 5) {
                        blue[r][y] = 1
                        blue[r][y2] = 1
                    }
                } else {
                    if (blue[r][y] == 1) {
                        if (r - 1 >= 0) blue[r - 1][y] = 1
                        if (r - 2 >= 0 && block.size > 1) blue[r - 2][y] = 1
                        break
                    }
                    if (r == 5) {
                        blue[r][y] = 1
                        if (block.size > 1) blue[r - 1][y] = 1
                    }
                }
            }
        }
        else -> {
        }
    }
}

fun bomb() {
    var greenScore = 0
    //점수 획득
    var r = 5
    while (r >= 2) {
        var sum = green[r].sum()
        if (sum == 4) {
            greenScore++
            green[r][0] = 0
            green[r][1] = 0
            green[r][2] = 0
            green[r][3] = 0
            for (c in 0..3) {
                for (r1 in r downTo 1) {
                     green[r1][c] = green[r1 - 1][c].also { green[r1 - 1][c] = 0 }
                }
            }
            r++
        }
        r--
    }
    var downCnt = 0
    for (rr in 0..1) {
        if (green[rr].sum() > 0) {
            downCnt++
        }
    }
    if (downCnt > 0) {
        for (r in 5 downTo 0) {
            for (c in 0..3) {
                if (r - downCnt < 0) {
                    green[r][c] = 0
                } else {
                    green[r][c] = green[r - downCnt][c]
                }
            }
        }
    }
    var blueScore = 0
    //점수 획득
    r = 5
    while (r >= 2) {
        var sum = blue[r].sum()
        if (sum == 4) {
            blueScore++
            blue[r][0] = 0
            blue[r][1] = 0
            blue[r][2] = 0
            blue[r][3] = 0
            for (c in 0..3) {
                for (r1 in r downTo 1) {
                    blue[r1][c] = blue[r1 - 1][c].also { blue[r1 - 1][c] = 0 }
                }
            }
            r++
        }
        r--
    }
    downCnt = 0
    for (rr in 0..1) {
        if (blue[rr].sum() > 0) {
            downCnt++
        }
    }
    if (downCnt > 0) {
        for (r in 5 downTo 0) {
            for (c in 0..3) {
                if (r - downCnt < 0) {
                    blue[r][c] = 0
                } else {
                    blue[r][c] = blue[r - downCnt][c]
                }
            }
        }
    }
    answer += greenScore + blueScore
}

fun simulation(t: Int, x: Int, y: Int) {
    val block = makeBlock(t, x, y)
    var horizon = false
    if (t == 2) horizon = true
    //한 블럭 이동
    move("green", horizon, block)
    for (i in block.indices) {
        val (r, c) = changeRC(block[i][0], block[i][1])
        block[i][0] = r
        block[i][1] = c
    }
    horizon = false
    if (t == 3) horizon = true
    move("blue", horizon, block)
    bomb()
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    //solve
    repeat(n) {
        val (t, x, y) = getIntList()
        simulation(t, x, y)
    }
    for (r in 2..5) {
        for (c in 0..3) {
            sumAnswer += green[r][c] + blue[r][c]
        }
    }
    //output
    write("$answer\n")
    write("$sumAnswer")

    close()
}
