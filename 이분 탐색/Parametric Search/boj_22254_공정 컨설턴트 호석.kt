//https://www.acmicpc.net/problem/22254
import kotlin.math.*
import java.util.*

//1<= n <=100000 선물 주문의 개수
//1<=x<=1000000000 완료까지 남은 시간
//공정 개수를 구해야 함
//공정 개수 하나부터 다 검사
//그냥 검사하면 n^2
//이분 탐색하면 nlogn*logn
//우선순위큐 logn

fun check( mid : Int, input : LongArray, limit : Int):Boolean{
    val pq =PriorityQueue<Long>()
    for(i in 0 .. mid){
        pq.add(input[i])
    }
    for(i in mid+1 until input.size){
        val cur = pq.poll()
        if(cur+input[i]>limit){
            return false
        }
        pq.add(cur+input[i])
    }
    return true
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,x) = br.readLine().split(' ').map{it.toInt()}
    val input = br.readLine().split(' ').map{it.toLong()}.toLongArray()

    var s = 0
    var e = n
    while(s<e){
        val mid = (s+e)/2
        if(check(mid,input,x)) {
            e=mid
        }
        else
            s = mid+1
    }
    write("${e+1}")
    close()
}
/*
import kotlin.math.*
import java.util.*

//1<= n <=100000 선물 주문의 개수
//1<=x<=1000000000 완료까지 남은 시간
//공정 개수를 구해야 함
//공정 개수 하나부터 다 검사
//그냥 검사하면 n^2
//이분 탐색하면 nlogn*logn
//우선순위큐 logn
var answer=987654321
fun biSearch(start : Int, end : Int, limit : Long, input : LongArray ){

    if(start>=end){
        return
    }
    val mid = (start+end)/2
    val pq = PriorityQueue<Long>()
    var idx=0
    while(idx<=mid && mid<input.size){
        pq.add(input[idx++])
    }
    var skip =false
    while(idx< input.size){
        val cur = pq.poll()
        if(cur+input[idx]>limit){
            skip =true
            break
        }
        pq.add(cur+input[idx++])
    }
    if(!skip) {
        if(pq.isNotEmpty())
            answer = min(answer, mid+1)
        biSearch(start,mid,limit,input)
    }
    else {
        biSearch(mid + 1, end, limit, input)
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,x) = br.readLine().split(' ').map{it.toInt()}
    val input = br.readLine().split(' ').map{it.toLong()}.toLongArray()

    biSearch(0,n,x.toLong(),input)
    write("$answer")
    close()
}
*/
