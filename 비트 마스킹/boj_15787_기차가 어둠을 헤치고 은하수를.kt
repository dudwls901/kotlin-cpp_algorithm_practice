//https://www.acmicpc.net/problem/15787
import java.util.*
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
//1<=n<=10만 기차 수
//1<=m<=10만 명령 수

lateinit var train: IntArray

fun move(order: Int, vararg num: Int) {
    train[num[0]] = when (order) {
        //상차
        1 -> {
              train[num[0]] or (1 shl num[1])
        }
        //하차
        2 -> {
              train[num[0]] and (1 shl num[1]).inv()
        }
        // 뒤로 땡기기
        3 -> {
            (train[num[0]] shl 1) and ((1 shl 21) -1)
        }
        //앞으로 땡기기
        else -> {
            (train[num[0]] shr 1) and (1.inv())
        }
    }
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n, m) = getIntList()
    train = IntArray(n + 1)
    //solve
    repeat(m) {
        val input =getIntList()
        //3,4 order
        if (input.size == 2) {
            move(input[0], input[1])
        }
        //1,2 order
        else {
            move(input[0], input[1], input[2])
        }
    }
    //output
    val set = mutableSetOf<Int>()
    for(i in 1 .. n){
        set.add(train[i])
    }
    write("${set.size}")
    close()
}
