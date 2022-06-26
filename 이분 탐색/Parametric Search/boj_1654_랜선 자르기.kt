//https://www.acmicpc.net/problem/1654
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
lateinit var kArr: IntArray

fun check(search: Long): Long = kArr.sumOf { it/search }

fun main() = with(System.out.bufferedWriter()){
    //input
    val (k,n) = getIntList()
    var maxLen = 0
    kArr = IntArray(k){ getInt().apply { maxLen = maxLen.coerceAtLeast(this) }}
    //solve
    var s: Long = 1L
    var e: Long = maxLen.toLong()
    var answer =0L
    while(s<=e){
        val mid: Long = (s+e)/2
        //가능하면 더 늘려보기
        if(check(mid)>=n){
            s= mid+1
            answer = answer.coerceAtLeast(mid)
        }
        else{
            e = mid-1
        }
    }

    write("$answer")
    close()
}
