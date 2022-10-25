//https://www.acmicpc.net/problem/13424
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()) {

    repeat(getInt()) {
        val (n, m) = getIntList()
        val dp = Array(n + 1) { r ->
            IntArray(n + 1) { c ->
                if (r == c) 0
                else 987654321
            }
        }
        repeat(m){
            val (from, to, dis) = getIntList()
            dp[from-1][to-1] = dis
            dp[to-1][from-1] = dis
        }
        //floyd warshall
        for(k in 0 until n){
            for(i in 0 until n){
                for(j in 0 until n){
                    dp[i][j] = dp[i][j].coerceAtMost(dp[i][k] + dp[k][j])
                }
            }
        }
        getInt()
        val positions = getIntList().map{it-1}
        var minSum = Int.MAX_VALUE
        var answer = -1
        for(to in 0 until n){
            var sum = 0
            for(from in positions){
                sum += dp[from][to]
            }
            if(minSum > sum){
                minSum = sum
                answer = to+1
            }
        }
        write("$answer\n")
    }

    close()
}
