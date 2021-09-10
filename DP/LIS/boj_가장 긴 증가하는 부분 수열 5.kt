//https://www.acmicpc.net/problem/14003
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
    val br =System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    val arr = IntArray(n)
    val dp = IntArray(n)
    val tk = StringTokenizer(br.readLine())
    var idx=0
    val idxArr=IntArray(n)
    arr[0] = Integer.parseInt(tk.nextToken())
    dp[0]=arr[0]
    idxArr[0]=0
    for(i in 1 until n){
        arr[i] = Integer.parseInt(tk.nextToken())
        if(dp[idx]<arr[i]){
            idx++
            dp[idx]=arr[i]
            idxArr[i]=idx
        }
        else {
            val findIdx = biSearch(dp, arr[i], 0, idx)
            idxArr[i]=findIdx
            dp[findIdx] = arr[i]
        }
    }

    var len = dp.indexOfFirst { it==0 }
    if(len==-1){
        write("${dp.size}\n")
        for(i in dp.indices){
            write("${dp[i]} ")
        }
    }
    else{
        write("$len\n")
        val answer = IntArray(len)
        var dpIdx=len-1
        for(i in idxArr.size-1 downTo 0){
            if(idxArr[i]==dpIdx){
                answer[dpIdx--]=arr[i]
            }
        }
        for(i in answer.indices){
            write("${answer[i]} ")
        }
    }

    close()
}
