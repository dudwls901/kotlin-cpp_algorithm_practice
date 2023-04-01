//https://www.acmicpc.net/problem/7490
import java.io.BufferedWriter
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

val operators = arrayOf(
    ' ',
    '+',
    '-'
)

fun main() {
    val bw = System.out.bufferedWriter()
    repeat(getInt()){
        val n = getInt()
        backTracking(1,CharArray(n-1){' '}, n, bw)
        bw.newLine()
    }
    bw.close()
}

fun backTracking(num: Int, opArr: CharArray, n: Int, bw: BufferedWriter) {
    if (num == n) {
        if(cal(opArr,n)) {
            for (i in 0 until n) {
                bw.write("${i+1}")
                if (i in opArr.indices)
                    bw.write("${opArr[i]}")
            }
            bw.newLine()
        }
        return
    }
    for (i in 0..2) {
        opArr[num-1] = operators[i]
        backTracking(num+1, opArr, n,bw)
    }
}

fun cal(opArr: CharArray, n: Int): Boolean {
    val numArr = IntArray(n){it+1}
    for(i in opArr.indices){
        when(opArr[i]){
            ' '->{
                numArr[i] = numArr[i]*10 + numArr[i+1]
                numArr[i+1] = 0
            }
        }
    }
    val compressedNumArr = numArr.filter { it != 0 }.toMutableList()
    val compressedOpArr = opArr.filter { it!=' ' }
    for(i in compressedOpArr.indices){
        when(compressedOpArr[i]){
            '+' ->{
                compressedNumArr[i+1] = compressedNumArr[i] + compressedNumArr[i+1]
            }
            '-' ->{
                compressedNumArr[i+1] = compressedNumArr[i] - compressedNumArr[i+1]
            }
        }
    }
    return compressedNumArr[compressedNumArr.size-1] == 0
}
