//https://www.acmicpc.net/problem/10819
import kotlin.math.*
var answer= 0
fun permutation(len : Int, result : IntArray, n : Int, arr : IntArray,visited : BooleanArray){

    if(len == n){
        var sum=0
        for(i in 0 until n-1){
            sum += abs(result[i]-result[i+1])
        }
        answer = max(answer,sum)
        return
    }
    for(i in 0 until n){
        if(visited[i]) continue
        result[len]=arr[i]
        visited[i]=true
        permutation(len+1,result,n,arr,visited)
        visited[i]=false
    }

}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(' ').map{it.toInt()}.toIntArray()
    val visited= BooleanArray(n)

    permutation(0,IntArray(n),n,arr,visited)
    write("$answer")
    close()
}
