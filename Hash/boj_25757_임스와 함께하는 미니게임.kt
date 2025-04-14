//https://www.acmicpc.net/problem/25757
val br = System.`in`.bufferedReader()
fun getStr() = br.readLine().trim()

fun main() = with(System.out.bufferedWriter()) {
    getStr()
        .split(' ')
        .let { (n, ch) ->
            val players = mutableSetOf<String>()
            repeat(n.toInt()) { players.add(getStr()) }
            val answer = when (ch) {
                "Y" -> players.size / 1
                "F" -> players.size / 2
                "O" -> players.size / 3
                else -> 0
            }
            write("$answer")
        }
    close()
}
