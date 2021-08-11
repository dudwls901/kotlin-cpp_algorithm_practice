//https://www.acmicpc.net/problem/1546
import java.util.StringTokenizer
fun main()=with(System.`in`.bufferedReader()){
    with(System.out.bufferedWriter()){

        var t = Integer.parseInt(readLine())
        val arr = ArrayList<Double>()
        val tk = StringTokenizer(readLine())
        for(i in 0 until t){
            arr.add(tk.nextToken().toDouble())
        }
        val max = arr.maxOrNull()
        for(i in arr.indices){
            arr[i] /=max!!
        }
        write("${arr.average()*100}")

        close()
    }
    close()
}
