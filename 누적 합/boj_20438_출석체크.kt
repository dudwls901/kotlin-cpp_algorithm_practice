//https://www.acmicpc.net/problem/20438
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()){

    //input
    val (n,k,q,m) = getIntList()
    val sleep = BooleanArray(n+3)
    val pSum = IntArray(n+3){1}
    pSum[0] = 0
    pSum[1] = 0
    pSum[2] = 0
    getIntList().forEach {
        sleep[it] = true
    }
    //solve
    getIntList().apply {
        for(origin in this) {
            if(sleep[origin]) continue
            var num = origin
            while(num in pSum.indices) {
                if (sleep[num]) {
                    num+=origin
                    continue
                }
                pSum[num] = 0
                num+=origin
            }
        }
    }
    for(i in 4 until pSum.size){
        pSum[i] += pSum[i-1]
    }
    //output
    repeat(m) {
        getIntList().apply {
            write("${pSum[this[1]] - pSum[this[0]-1]}\n")
        }
    }

    close()
}
