//https://www.acmicpc.net/problem/21277
val br = System.`in`.bufferedReader()
fun getIntGraph() = br.readLine().split(' ').map { it.toInt() }

val puzzle1 = Array(150) { IntArray(150) }
lateinit var puzzle2: Array<Array<IntArray>>
var answer = Int.MAX_VALUE
fun simulation(i: Int, j: Int, n1: Int, m1: Int, pzl2: Array<IntArray>): Int {
    //i==0~100
    //j==0~100
    val n2 = pzl2.size
    val m2 = pzl2[0].size
    for (r in pzl2.indices) {
        for (c in pzl2[r].indices) {
            //겹치면 리턴
            if (puzzle1[i + r][j + c] and pzl2[r][c] == 1) return Int.MAX_VALUE
        }
    }
    //안 겹치면 계산
    val minR = i.coerceAtMost(50)
    val maxR = (50+n1).coerceAtLeast(i+n2)
    val minC = j.coerceAtMost(50)
    val maxC = (50+m1).coerceAtLeast(j+m2)
    return (maxR-minR)*(maxC-minC)
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n1, m1) = getIntGraph()
    for (i in 0 until n1) {
        val line = br.readLine()
        for (j in 0 until m1) {
            puzzle1[50 + i][50 + j] = Character.getNumericValue(line[j])
        }
    }
    val (n2, m2) = getIntGraph()
    val temp = Array(n2) {
        val line = br.readLine()
        IntArray(m2) {
            Character.getNumericValue(line[it])
        }
    }

    //5,3
    puzzle2 = Array(4) {
        when (it) {
            0 -> {
                Array(n2) { r ->
                    IntArray(m2) { c ->
                        temp[r][c]
                    }
                }
            }
            1 -> {
                Array(m2) { r ->
                    IntArray(n2) { c ->
                        temp[n2 - c - 1][r]
                    }
                }
            }
            2 -> {
                Array(n2) { r ->
                    IntArray(m2) { c ->
                        temp[n2 - r - 1][m2-c-1]
                    }
                }
            }
            else -> {
                Array(m2) { r ->
                    IntArray(n2) { c ->
                        temp[c][m2 - r - 1]
                    }
                }
            }
        }
    }

    //solve
    for (r in 0..100) {
        for (c in 0..100) {
            for(i in 0 until 4) {
                answer = answer.coerceAtMost(simulation(r, c, n1, m1,puzzle2[i]))
            }
        }
    }

    //output
    write("$answer")
    close()
}
