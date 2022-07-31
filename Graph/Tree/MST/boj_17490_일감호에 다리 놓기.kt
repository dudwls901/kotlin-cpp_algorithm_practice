//https://www.acmicpc.net/problem/17490
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var destroyed: BooleanArray
lateinit var parent: IntArray
lateinit var costs: List<Int>
fun getParent(x: Int): Int {
    return if (x != parent[x]) getParent(parent[x]).also { parent[x] = it } else x
}

fun unionParent(x: Int, y: Int) {
    val xx = getParent(x)
    val yy = getParent(y)
    if (costs[xx] > costs[yy]) {
        parent[xx] = yy
    } else {
        parent[yy] = xx
    }
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    var tk = StringTokenizer(br.readLine())
    val n = tk.nextToken().toInt()
    val m = tk.nextToken().toInt()
    val k = tk.nextToken().toLong()
    parent = IntArray(n + 1) { it }
    destroyed = BooleanArray(n + 1)
    tk = StringTokenizer(br.readLine())
    costs = List(n + 1) { if (it == 0) 0 else tk.nextToken().toInt() }

    for(i in 0 until m) {
        tk = StringTokenizer(br.readLine())
        val (a, b) = List(2){tk.nextToken().toInt()}
        val large = a.coerceAtLeast(b)
        val small = a.coerceAtMost(b)
        if (large == n && small == 1) {
            destroyed[1] = true
        } else {
            destroyed[large] = true
        }
    }
    //solve
    //makeUnion
    for (i in 1..n) {
        var j = (i + 1) % (n + 1)
        if (j == 0) j = 1
        if(destroyed[j]) continue
        unionParent(i,j)
    }
    //check
    var answer = 0L
    var unionCnt=0
    for(i in 1 .. n){
        if(getParent(i) == i){
            answer += costs[i]
            unionCnt++
        }
    }
    //output
    write(if (answer <= k || unionCnt <= 1) "YES" else "NO")
    close()
}
