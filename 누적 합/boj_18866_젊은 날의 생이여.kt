//https://www.acmicpc.net/problem/18866
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getStr() = br.readLine().trim()
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){
    val n = getInt()
    val good = IntArray(n)
    val bad = IntArray(n)
    for(i in 0 until n){
        val (g,b) = getIntList()
        good[i] = g
        bad[i] = b
    }
    val youngMinGood = IntArray(n+2){Int.MAX_VALUE}
    val youngMaxBad = IntArray(n+2){0}
    val oldMaxGood = IntArray(n+2){0}
    val oldMinBad = IntArray(n+2){Int.MAX_VALUE}
    for(i in 1 .. n){
        youngMinGood[i] = if(good[i-1]==0) youngMinGood[i-1] else youngMinGood[i-1].coerceAtMost(good[i-1])
        youngMaxBad[i] = if(bad[i-1]==0) youngMaxBad[i-1] else youngMaxBad[i-1].coerceAtLeast(bad[i-1])
    }
    for(i in n downTo 1){
        oldMaxGood[i] = if(good[i-1]==0) oldMaxGood[i+1] else oldMaxGood[i+1].coerceAtLeast(good[i-1])
        oldMinBad[i] = if(good[i-1]==0) oldMinBad[i+1] else oldMinBad[i+1].coerceAtMost(bad[i-1])
    }
    var answer = -1
    for(i in 1 until n){
        if(youngMinGood[i] >= oldMaxGood[i+1] && youngMaxBad[i] <= oldMinBad[i+1]){
            answer = i
        }
    }
    //없는 경우
    write("$answer")
    close()
}
