//https://www.acmicpc.net/problem/14621
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

var n = 0
var m = 0
lateinit var parent: IntArray

fun getParent(x: Int): Int {
    return if (parent[x] == x) x else getParent(parent[x]).also { parent[x] = it }
}

fun unionParent(x: Int, y: Int) {
    val xx = getParent(x)
    val yy = getParent(y)
    if (xx < yy) {
        parent[yy] = xx
    } else {
        parent[xx] = yy
    }
}

fun isSameParent(x: Int, y: Int) = getParent(x) == getParent(y)

fun main() = with(System.out.bufferedWriter()) {
    //input
    getIntList().also {
        n = it[0]
        m = it[1]
    }
    val sex = br.readLine().split(" ")
    val input = Array(m){ getIntList()}
    var answer = 0
    parent = IntArray(n + 1) { it }
    input.sortBy { it[2] }

    //Kruskal
    for ((u, v, d) in input) {
        //성별이 다른 경우만 (1번 조건)
        if (sex[u - 1] != sex[v - 1]) {
            if (!isSameParent(u, v)) {
                unionParent(u, v)
                answer += d
            }
        }
    }
    //output
    //하나라도 연결되지 않은 경우 -1
    val first = getParent(1)
    for(i in 2 .. n){
        if(first != getParent(i)){
            write("-1")
            close()
            return
        }
    }
    write("$answer")
    close()
}
