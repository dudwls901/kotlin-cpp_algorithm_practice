//https://www.acmicpc.net/problem/2011
val br = System.`in`.bufferedReader()
const val MOD = 1000000
fun main() = with(System.out.bufferedWriter()) {

    br.readLine().let{
        if(it[0]=='0'){
            write("0")
            close()
            return@with
        }
        val dp = LongArray(it.length + 1)
        dp[0] = 1
        dp[1] = 1
        for (i in 2 until dp.size) {
            if(it[i-1]=='0'){
                if(it.substring(i-2,i).toInt() in 1.. 26){
                    dp[i] +=dp[i - 2]
                    dp[i] = dp[i] % MOD
                }
            }
            else{
                dp[i] = dp[i - 1]
                dp[i] = dp[i] % MOD
                if (it.substring(i - 2, i).toInt() in 11..26) {
                    dp[i] += dp[i - 2]
                    dp[i] = dp[i] % MOD
                }
            }
        }
        write("${dp[dp.size-1]}")
    }
    close()
}
