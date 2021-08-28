//https://www.acmicpc.net/problem/2003
import java.util.StringTokenizer

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var tk = StringTokenizer(br.readLine())
    val (n,m) = List(2){ Integer.parseInt(tk.nextToken())};
    tk = StringTokenizer(br.readLine())
    val arr = IntArray(n)
    for(i in 0 until n){
        arr[i]= Integer.parseInt(tk.nextToken())
    }
    var s=0
    var e=0
    var sum =0
    var answer=0

    while(s<n){
        if(sum>m){
            sum -=arr[s++]
        }
        else if(sum==m){
            sum-=arr[s++]
            answer++
        }
        else{
            if(e <n){
                sum += arr[e++]
            }
            else {
                sum -= arr[s++]
            }
        }
    }
    write("$answer")
    close()
}
