//https://www.acmicpc.net/problem/20444
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    //input
    val (n,k) = br.readLine().split(" ").map{it.toLong()}

    //solve, output
    //x를 기준으로 이분 탐색
    var s = 0
    var e = n.toInt()/2
    while(s<=e){
        val mid = (s+e)/2
        val result = (mid+1) * (n-mid+1)
        if(result == k){
            write("YES")
            close()
            return
        }
        else if(result <k){
            s = mid+1
        }
        else{
            e = mid-1
        }
    }
    write("NO")

    close()
}
