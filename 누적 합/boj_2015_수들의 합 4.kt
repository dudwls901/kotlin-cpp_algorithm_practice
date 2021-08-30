//https://www.acmicpc.net/problem/2015
import java.util.StringTokenizer
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var tk = StringTokenizer(br.readLine())
    val (N,K) = List(2){Integer.parseInt(tk.nextToken())}
    //누적합(부분합)
    val pSum = LongArray(N+1)
    var answer=0L
    val map = mutableMapOf<Long,Long>()
    tk = StringTokenizer(br.readLine())

    for(i in 1 .. N){
        pSum[i] = pSum[i-1]+Integer.parseInt(tk.nextToken())
        if(pSum[i]==K.toLong()){
            answer++
        }
        answer += map.getOrDefault(pSum[i]-K,0)
        map.put(pSum[i],map.getOrDefault(pSum[i],0)+1)
    }
    write("$answer")
    close()
}
