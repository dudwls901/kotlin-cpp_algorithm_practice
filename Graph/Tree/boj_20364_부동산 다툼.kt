//https://www.acmicpc.net/problem/20364
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, q) = getIntList()
    val se = mutableSetOf<Int>()
    //solve
    repeat(q) {
        val origin = getInt()
        var num = origin
        var answer = 0
        while (num > 1) {
            if (se.contains(num)) answer = num
            num /= 2
        }
        write("$answer\n")
        if(answer==0) se.add(origin)
    }


    close()
}
