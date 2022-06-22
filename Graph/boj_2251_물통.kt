//https://www.acmicpc.net/problem/2251
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var visited: Array<Array<BooleanArray>>
val answer = ArrayList<Int>()

data class State(
    val a: Int,
    val b: Int,
    val c: Int
)

fun bfs(A: Int, B: Int, C: Int) {
    val q: Queue<State> = LinkedList()
    q.add(State(0, 0, C))

    while (q.isNotEmpty()) {
        val (a, b, c) = q.poll()
        if (visited[a][b][c]) continue
        visited[a][b][c] = true
        if (a == 0) {
            answer.add(c)
        }
        //a->b
        if (a + b > B) q.add(State(a + b - B, B, c))
        else q.add(State(0, a + b, c))
        //a->c
        if (a + c > C) q.add(State(a + c - C, b, C))
        else q.add(State(0, b, a + c))
        //b->a
        if (a + b > A) q.add(State(A, a + b - A, c))
        else q.add(State(a + b, 0, c))
        //b->c
        if (b + c > C) q.add(State(a, b + c - C, C))
        else q.add(State(a, 0, b + c))
        //c->a
        if (a + c > A) q.add(State(A, b, a + c - A))
        else q.add(State(a + c, b, 0))
        //c->b
        if (b + c > B) q.add(State(a, B, b + c - B))
        else q.add(State(a, b + c, 0))
    }
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (A, B, C) = getIntList()
    visited = Array(201) { Array(201) { BooleanArray(201) } }
    //solve
    bfs(A, B, C)
    //output
    write(answer.sorted().joinToString(" "))
    close()
}
