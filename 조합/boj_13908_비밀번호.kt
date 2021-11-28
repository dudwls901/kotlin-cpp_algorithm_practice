//https://www.acmicpc.net/problem/13908
import java.util.*
var answer=0
val toUse = BooleanArray(10)
fun permutation(len : Int, end : Int, m : Int, cnt : Int){
    if(len==end){
        if(cnt==m)answer++
        return
    }
    for(i in 0 .. 9){
        if(toUse[i]){
            toUse[i]=false
            permutation(len+1, end,m, cnt+1)
            toUse[i]=true
        }
        else{
            permutation(len+1,end,m,cnt)
        }

    }
}
fun main() =with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    if(m!=0){
        val tk =StringTokenizer(br.readLine())
        while(tk.hasMoreTokens()){
            toUse[tk.nextToken().toInt()]=true
        }
    }
    permutation(0,n,m,0)
    write("$answer")
    close()
}
