//https://www.acmicpc.net/problem/9084
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){

    repeat(getInt()){
        //input
        val n = getInt()
        val coins = getIntList()
        val dest = getInt()
        //solve
        val dp = Array(coins.size){
            IntArray(dest+1){
                if(it==0) 1 else 0
            }
        }
        for(i in coins.indices){
            val coin = coins[i]
            for(money in 1..dest){
                if(i-1 >=0){
                    dp[i][money] += dp[i-1][money]
                }
                if(money - coin >=0){
                    dp[i][money] += dp[i][money-coin]
                }
            }
        }
        //output
        write("${dp[coins.size-1][dest]}\n")
    }

    close()
}
