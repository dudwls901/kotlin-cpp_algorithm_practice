//https://www.acmicpc.net/problem/12738

import java.util.*
fun biSearch(dp : IntArray ,find : Int, start : Int, end : Int) : Int{
    var mid = (start+end)/2
    if(start==end){
        return mid
    }
    if(find>dp[mid]){
        return biSearch(dp,find,mid+1,end)
    }
    else if(find==dp[mid]){
        return mid
    }
    else{
        return biSearch(dp,find,start,mid)
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    val arr = IntArray(n)
    val dp = IntArray(n)
    val tk = StringTokenizer(br.readLine())
    var idx=0
    arr[0] = Integer.parseInt(tk.nextToken())
    dp[0]=arr[0]
    for(i in 1 until n){
        arr[i] = Integer.parseInt(tk.nextToken())
        if(dp[idx]<arr[i]){
            dp[++idx]=arr[i]
        }
        else {
            dp[biSearch(dp, arr[i], 0, idx)] = arr[i]
        }
    }
    var answer = dp.indexOfFirst { it==0 }
    if(answer==-1){
        write("${dp.size}")
    }
    else{
        write("$answer")
    }
    close()
}
