//https://www.acmicpc.net/problem/3687
import kotlin.math.*
fun main() =with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    val minDP = LongArray(101){Long.MAX_VALUE}
    val maxDP = Array<String>(101){""}
    val arr = IntArray(8)
    arr[2] =1
    arr[3] =7
    arr[4] =4
    arr[5] =2
    arr[6] =0
    arr[7] =8
    minDP[2]=1
    minDP[3]=7
    minDP[4]=4
    minDP[5]=2
    minDP[6]=6
    minDP[7]=8
    minDP[8]=10
    for(i in  9 .. 100){
        for(j in 2 .. 7){
            minDP[i] = min(minDP[i],minDP[i-j]*10+arr[j])
        }
    }

    minDP[6]=6
    maxDP[2] = "1"
    maxDP[3] = "7"
    for(i in 4 ..100){
        maxDP[i] = maxDP[i-2]+"1"
    }

    for(i in 0 until n){
        val num = Integer.parseInt(br.readLine())
        write("${minDP[num]} ${maxDP[num]}\n")
    }
    close()
}
