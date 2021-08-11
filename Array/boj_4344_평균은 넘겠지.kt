//https://www.acmicpc.net/problem/4344

import java.util.StringTokenizer
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(System.out.bufferedWriter()) {
 
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = Integer.parseInt(br.readLine())

    for(i in 0 until t) {
        val tk = StringTokenizer(br.readLine())
        val n = Integer.parseInt(tk.nextToken())
        val arr = DoubleArray(n)
        for (j in 0 until n) {
            arr[j] = tk.nextToken().toDouble()
        }
        val avg = arr.average()
        var cnt = 0.0
        for(j in arr){
            if(j>avg)
                cnt++
        }
        write("${String.format("%.3f", cnt / n*100)}%\n")
    }
    close()
}
