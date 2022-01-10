//https://www.acmicpc.net/problem/4690
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    for(a in 2 .. 100) {
        val left = a * a * a
         for (b in 2..100) {
             for (c in b + 1..100) {
                for (d in c + 1..100) {
                    val right = b * b * b + c * c * c + d * d * d
                    if (left < right) break
                    if (left == right) {
                        write("Cube = $a, Triple = ($b,$c,$d)\n")
                        break
                    }
                }
            }
        }
    }
    close()
}

