//https://www.acmicpc.net/problem/21758
import kotlin.math.*
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(' ').map{it.toLong()}
    val leftSum = LongArray(n)
    val rightSum = LongArray(n)
    leftSum[0] = arr[0]
    rightSum[n-1] = arr[n-1]
    for(i in 1 until n){
        leftSum[i] += leftSum[i-1]+arr[i]
        rightSum[n-i-1] +=rightSum[n-i]+arr[n-i-1]
    }
    rightSum[0] = rightSum[1]+arr[0]

    var answer=0L
    val left = leftSum[n-2]-arr[0]
    val right = rightSum[0]-arr[n-1]
    for(i in 1 until n-1){
        //벌통이 우측인 경우
        answer = max(answer,left + (leftSum[n-1]-leftSum[i])-arr[i]+arr[n-1])
        //벌통이 좌쪽인 경우
        answer = max(answer, right + (rightSum[1]-rightSum[i])-arr[i] +arr[0])
        //벌통이 가운데(1~n-2)인 경우
        answer = max(answer, leftSum[i]+rightSum[i]-arr[0]-arr[n-1])
    }

    write("$answer")
    close()
}
