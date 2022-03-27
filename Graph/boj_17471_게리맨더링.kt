//https://www.acmicpc.net/problem/17471
import kotlin.math.abs
import java.util.*

var population = IntArray(11)
var visited = BooleanArray(11)
val edge = Array(11) { BooleanArray(11) }
var n = 0
lateinit var picked1: IntArray
val picked2 = ArrayList<Int>()
var answer = Int.MAX_VALUE
fun isConnected(picked: IntArray, len: Int, type: Int): Boolean {
    val q: Queue<Int> = LinkedList()
    val connectCheck = BooleanArray(11)
    q.add(picked[0])
    connectCheck[picked[0]] = true
    while (q.isNotEmpty()) {
        val cur = q.poll()
        for (i in 1..n) {
            //1그룹
            if(type==1) {
                //1그룹에 속하지 않으면 탐색 금지
                if (!visited[i]) continue
            }
            //2그룹
            else{
                //2그룹에 속하지 않으면 탐색 금지
                if(visited[i]) continue
            }
            if (edge[cur][i]) {
                if (connectCheck[i]) continue
                connectCheck[i] = true
                q.add(i)
            }
        }
    }
    for (i in 0 until len) {
        if (!connectCheck[picked[i]]) return false
    }
    return true

}

fun garrymend(len: Int) {
    //지역구1 검사
    if (!isConnected(picked1, len,1))
        return
    //지역구1 완성

    //지역구2  검사
    picked2.clear()
    for (i in 1..n) {
        if (visited[i]) continue
        picked2.add(i)
    }
    if (!isConnected(picked2.toIntArray(), picked2.size,2))
        return

    var sum1 = 0
    var sum2 = 0
    for (i in 0 until len) {
        sum1 += population[picked1[i]]
    }
    for (idx in picked2) {
        sum2 += population[idx]
    }
    answer = answer.coerceAtMost(Math.abs(sum1 - sum2))
}

fun combination(idx: Int, len: Int) {

    if (len > 0) {
        garrymend(len)
    }
    if (len == n / 2) {
        return
    }

    for (i in idx..n) {
        picked1[len] = i
        visited[i] = true
        combination(i + 1, len + 1)
        visited[i] = false
    }

}

//2<=n<=10
fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    //input
    n = br.readLine().toInt()
    picked1 = IntArray(n / 2)
    val tk = StringTokenizer(br.readLine())
    for (i in 1..n) {
        population[i] = tk.nextToken().toInt()
    }
    for (i in 1..n) {
        val tk = StringTokenizer(br.readLine())
        tk.nextToken()
        while (tk.hasMoreTokens()) {
            val num = tk.nextToken().toInt()
            edge[i][num] = true
            edge[num][i] = true
        }
    }

    //solve
    combination(1, 0)

    //output
    if(answer==Int.MAX_VALUE)
        answer=-1

    write("$answer")

    close()
}
