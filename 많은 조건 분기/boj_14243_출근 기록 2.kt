//https://www.acmicpc.net/problem/14243
val br = System.`in`.bufferedReader()
fun main() = with(System.out.bufferedWriter()) {
    //input
    val input = br.readLine()
    var a = 0
    var b = 0
    var c = 0
    val size = input.length
    var answer = CharArray(size)
    for (ch in input) {
        when (ch) {
            'A' -> a++
            'B' -> b++
            else -> c++
        }
    }
    //solve
    var prev = 0
    var pprev = 0
    for (i in 0 until size) {
        if (b - 1 == a + c && b > 0 && prev != 2) {
            pprev = prev.also { prev = 2 }
            answer[i] = 'B'
            b--
        } else if (2 * (c - 1) == a + b && c > 0 && prev != 3 && pprev != 3) {
            pprev = prev.also { prev = 3 }
            answer[i] = 'C'
            c--
        } else {
            if (b > 0 && prev != 2) {
                pprev = prev.also { prev = 2 }
                answer[i] = 'B'
                b--
            } else if (c > 0 && prev != 3 && pprev != 3) {
                pprev = prev.also { prev = 3 }
                answer[i] = 'C'
                c--
            } else if (a > 0) {
                pprev = prev.also { prev = 1 }
                answer[i] = 'A'
                a--
            } else {
                write("-1")
                close()
                return
            }
        }
    }
    //output
    for (i in 0 until size) {
        write("${answer[i]}")
    }
    close()
}
