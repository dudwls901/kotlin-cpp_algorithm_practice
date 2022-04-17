//https://www.acmicpc.net/problem/16235
import java.util.*

val br = System.`in`.bufferedReader()

//1<=n<=10 그래픜크기
//1<=m<=n^2 나무 개수
//1<=k<=1000 k년 후

data class Tree(
    var r: Int,
    var c: Int,
    var age: Int
)

lateinit var energy: Array<IntArray>
lateinit var A: Array<IntArray>

val tree= ArrayDeque<Tree>()
val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0),
    arrayOf(1, 1),
    arrayOf(1, -1),
    arrayOf(-1, 1),
    arrayOf(-1, -1),
)

fun getIntGraph() = br.readLine().split(' ').map { it.toInt() }

fun simulation(n: Int, m: Int, k: Int) {

    var year = 0
    while (year < k) {
        val tempTree = ArrayList<Tree>()
        //봄
        var size = tree.size
        for(i in 0 until size){
            val t = tree.pollFirst()
            //die
            if (energy[t.r][t.c] < t.age) {
                tempTree.add(t)
            } else {
                energy[t.r][t.c] -= t.age
                tree.addLast(Tree(t.r,t.c,t.age+1))
            }
        }
        //여름
        for (dt in tempTree) {
            energy[dt.r][dt.c] += dt.age / 2
        }
        tempTree.clear()
        //가을
        for (t in tree) {
            if (t.age % 5 != 0) continue
            for (i in 0 until 8) {
                val nr = t.r + dir[i][0]
                val nc = t.c + dir[i][1]
                if (nr !in 0 until n || nc !in 0 until n) continue
                tempTree.add(Tree(nr, nc, 1))
            }
        }
        for (tt in tempTree) {
            tree.addFirst(tt)
        }
        //겨울
        for (r in 0 until n) {
            for (c in 0 until n) {
                energy[r][c] += A[r][c]
            }
        }
        year++
    }
}


fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, m, k) = getIntGraph()
    energy = Array(n) { IntArray(n) { 5 } }
    A = Array(n) { getIntGraph().toIntArray() }

    repeat(m) {
        val (r, c, age) = getIntGraph()
        tree.add(Tree(r - 1, c - 1, age))
    }

    tree.sortedBy { it.age }
    //solve
    simulation(n, m, k)

    //output
    write("${tree.size}")
    close()
}ㅠ
