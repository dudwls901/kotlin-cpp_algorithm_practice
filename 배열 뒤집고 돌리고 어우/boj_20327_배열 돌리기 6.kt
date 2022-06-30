//https://www.acmicpc.net/problem/20327
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }

lateinit var graph: Array<IntArray>
var N = 0
fun op1(x: Int, y: Int, size: Int) {
    for (r in 0 until size / 2) {
        for (c in 0 until size) {
            graph[x + r][y + c] = graph[x + size - r - 1][y + c].also {
                graph[x + size - r - 1][y + c] = graph[x + r][y + c]
            }
        }
    }
}

fun op2(x: Int, y: Int, size: Int) {
    for (c in 0 until size / 2) {
        for (r in 0 until size) {
            graph[x + r][y + c] = graph[x + r][y + size - c - 1].also {
                graph[x + r][y + size - c - 1] = graph[x + r][y + c]
            }
        }
    }
}

fun op3(x: Int, y: Int, size: Int) {
    val tempArr = Array(size) { IntArray(size) }
    for (r in 0 until size) {
        for (c in 0 until size) {
            tempArr[r][c] = graph[x + size - c - 1][y + r]
        }
    }
    for (r in 0 until size) {
        for (c in 0 until size) {
            graph[x + r][y + c] = tempArr[r][c]
        }
    }
}

fun op4(x: Int, y: Int, size: Int) {
    val tempArr = Array(size) { IntArray(size) }
    for (r in 0 until size) {
        for (c in 0 until size) {
            tempArr[r][c] = graph[x + c][y + size - r - 1]
        }
    }
    for (r in 0 until size) {
        for (c in 0 until size) {
            graph[x + r][y + c] = tempArr[r][c]
        }
    }
}

fun op5(n: Int, size: Int) {
    for (x in 0 until n / 2 step size) {
        for (r in 0 until size) {
            for (c in 0 until n) {
                graph[x + r][c] =
                    graph[n - x - size + r][c].also { graph[n - x - size + r][c] = graph[x + r][c] }
            }
        }
    }
}

fun op6(n: Int, size: Int) {
    for (x in 0 until n / 2 step size) {
        for (c in 0 until size) {
            for (r in 0 until n) {
                graph[r][x + c] =
                    graph[r][n - x - size + c].also { graph[r][n - x - size + c] = graph[r][x + c] }
            }
        }
    }
}

fun op7(n: Int, size: Int) {
    val temp = Array(n) { IntArray(n) }
    for (x in 0 until n step size) {
        for (y in 0 until n step size) {
            val x2 = n - y - size
            val y2 = x
            for (r in 0 until size) {
                for (c in 0 until size) {
                    temp[x + r][y + c] = graph[x2 + r][y2 + c]
                }
            }
        }
    }
    for (r in 0 until n) {
        for (c in 0 until n) {
            graph[r][c] = temp[r][c]
        }
    }
}

fun op8(n: Int, size: Int) {
    val temp = Array(n) { IntArray(n) }
    for (x in 0 until n step size) {
        for (y in 0 until n step size) {
            val x2 = y
            val y2 = n - x - size
            for (r in 0 until size) {
                for (c in 0 until size) {
                    temp[x + r][y + c] = graph[x2 + r][y2 + c]
                }
            }
        }
    }
    for (r in 0 until n) {
        for (c in 0 until n) {
            graph[r][c] = temp[r][c]
        }
    }
}

fun Int.toSizeInt() = Math.pow(2.0, this.toDouble()).toInt()

fun main() = with(System.out.bufferedWriter()) {
    var R = 0
    getIntList().apply {
        N = this[0]
        R = this[1]
    }
    val n = N.toSizeInt()
    graph = Array(n) { getIntList().toIntArray() }
    repeat(R) {
        val (k, l) = getIntList()
        val minSize = l.toSizeInt()
        if (k <= 4) {
            for (r in 0 until n step minSize) {
                for (c in 0 until n step minSize) {
                    when (k) {
                        1 -> {
                            op1(r, c, minSize)
                        }
                        2 -> {
                            op2(r, c, minSize)
                        }
                        3 -> {
                            op3(r, c, minSize)
                        }
                        4 -> {
                            op4(r, c, minSize)
                        }
                    }
                }
            }
        } else {
            when (k) {
                5 -> {
                    op5(n, minSize)
                }
                6 -> {
                    op6(n, minSize)
                }
                7 -> {
                    op7(n, minSize)
                }
                8 -> {
                    op8(n, minSize)
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            write("${graph[i][j]} ")
        }
        write("\n")
    }
    close()
}
