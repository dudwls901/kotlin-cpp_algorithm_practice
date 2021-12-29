//https://www.acmicpc.net/problem/16288
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val arr = br.readLine().split(' ').map{it.toInt()}.toIntArray()
    var cnt=0
    for(i in 0 until n){
        if(arr[i]==0) continue
        var pre = arr[i]
        arr[i]=0
        for(j in i+1 until n){
            if(pre<arr[j]){
                pre=arr[j]
                arr[j]=0
            }
        }
        cnt++
    }
    if(cnt<=k) write("YES") else write("NO")
    close()
}
