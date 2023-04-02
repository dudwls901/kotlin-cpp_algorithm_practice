//https://www.acmicpc.net/problem/19951
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){

    //input
    val (n,m) = getIntList()
    //solve
    val ground = getIntList().toMutableList()
    val pSum = IntArray(n+1)
    repeat(m){
        val (s,e,k) = getIntList()
        pSum[s-1] += k
        pSum[e] += -k
    }
    for(i in 1 until n){
        pSum[i] += pSum[i-1]
        ground[i-1] += pSum[i-1]
    }
    ground[n-1] += pSum[n-1]
    //output
    write(ground.joinToString(" "))
    close()
}
