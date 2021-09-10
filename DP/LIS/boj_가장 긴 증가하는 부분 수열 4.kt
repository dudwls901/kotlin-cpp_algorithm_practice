//https://www.acmicpc.net/problem/14002
import kotlin.math.*
import java.util.*

fun main() = with(System.out.bufferedWriter()){
    val br= System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    val arr = IntArray(n)
    val dp = IntArray(n)
    val tk = StringTokenizer(br.readLine())
    val lis = Array<ArrayList<Int>>(n){ArrayList()}
    arr[0] = Integer.parseInt(tk.nextToken())
    dp[0]=1
    lis[0].add(arr[0])
    var answer=0
    var idx=0
    for(i in 1 until n) {
        arr[i] = Integer.parseInt(tk.nextToken())
        dp[i]=1
        for(j in 0 until i){
            if(arr[i]>arr[j]){
                if(dp[i]<dp[j]+1){
                    lis[i]= ArrayList()
                    for(item in lis[j]){
                        lis[i].add(item)
                    }
                    dp[i]=dp[j]+1
                    if(answer<dp[i]){
                        answer = dp[i]
                        idx=i
                    }
                }
            }
        }
        lis[i].add(arr[i])
    }
    if(answer==0){
        write("1\n${arr[0]}")
    }
    else {
        write("$answer\n")
        for (i in lis[idx].indices) {
            write("${lis[idx][i]} ")
        }
    }
    close()
}
