//https://www.acmicpc.net/problem/20040
val br = System.`in`.bufferedReader()
fun getIntArray() = br.readLine().trim().split(' ').map { it.toInt() }.toIntArray()

lateinit var parent: IntArray

fun getParent(x: Int): Int = if (x == parent[x]) x else getParent(parent[x]).also { parent[x] = it }

fun unionParent(x: Int, y: Int) {
    val xx = getParent(x)
    val yy = getParent(y)
    if (xx < yy) parent[yy] = xx
    else parent[xx] = yy
}

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = getIntArray()
    parent = IntArray(n) { it }
    var answer = 0
    for (i in 1..m) {
        val (x, y) = getIntArray()
        if(getParent(x) == getParent(y)){
            answer = i
            break
        }
        unionParent(x, y)
    }
    write("$answer")
    close()
}
