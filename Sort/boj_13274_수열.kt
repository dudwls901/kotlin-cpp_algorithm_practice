//https://www.acmicpc.net/problem/13274
import java.util.*
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val tk = StringTokenizer(br.readLine())
    val arr = LongArray(n){tk.nextToken().toLong()}
    val temp = LongArray(n)
    arr.sort()
    for(i in 0 until k){
        var idx=0
        var (l,r,x) = br.readLine().split(' ').map{it.toInt()}
        l--
        var it =l
        for(i in 0 until l){
            while(it<r && arr[it]+x<=arr[i]){
                temp[idx++]=arr[it++]+x
            }
            temp[idx++]=arr[i]
        }
        for(i in r until n){
            while(it<r && arr[it]+x <=arr[i]){
                temp[idx++]=arr[it++]+x
            }
            temp[idx++]=arr[i]
        }
        while(it<r){
            temp[idx++]=arr[it++]+x
        }
        for(j in 0 until n){
            arr[j] = temp[j]
        }
    }
    for(i in 0 until n){
        write("${arr[i]} ")
    }
    close()
}
