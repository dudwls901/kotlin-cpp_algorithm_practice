//https://www.acmicpc.net/problem/10427
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()


fun main() = with(System.out.bufferedWriter()){

    repeat(getInt()){
        getIntList().apply {
            val n = this[0]
            val origin = List(this.size-1){this[it+1].toLong()}.sorted()
            val preSum = LongArray(this.size)
            for(i in 1 until preSum.size){
                preSum[i] = preSum[i-1] + origin[i-1]
            }
            var answer = 0L
            for(m in 2 .. n){
                var min = Long.MAX_VALUE
                for(i in 0 .. n-m){
                    min = min.coerceAtMost(origin[i+m-1]*m - (preSum[i+m]-preSum[i]))
                }
                answer += min
            }
            write("$answer\n")
        }
    }

    close()
}
