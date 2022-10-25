//https://www.acmicpc.net/problem/6986
import kotlin.math.roundToInt

val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }

fun Double.formatter() = String.format("%.2f", (this * 100).roundToInt() /100.0)

fun main() = with(System.out.bufferedWriter()){

    //input
    val (n,k) = getIntList()
    val scoreArr = DoubleArray(n){br.readLine().toDouble()}
    //solve
    scoreArr.sort()
    for(i in 0 until k){
        scoreArr[i] = scoreArr[k]
    }
    for(i in n-1 downTo n-1-k){
        scoreArr[i] = scoreArr[n-1-k]
    }
    //output
    write("${scoreArr.slice(k until n-k).average().formatter()}\n")
    write(scoreArr.average().formatter())


    close()
}
