//https://www.acmicpc.net/problem/27210
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    val input = getIntList()
    var cnt1 = 0
    var cnt2 = 0
    var maxCnt = 0
    //solve
    for(dir in input){
        cnt1 = if(dir == 1) cnt1 + 1 else 0.coerceAtLeast(cnt1-1)
        cnt2 = if(dir == 2) cnt2 + 1 else 0.coerceAtLeast(cnt2-1)
        maxCnt = maxCnt.coerceAtLeast(cnt1.coerceAtLeast(cnt2))
    }
    //output
    write("$maxCnt")
    close()
}
