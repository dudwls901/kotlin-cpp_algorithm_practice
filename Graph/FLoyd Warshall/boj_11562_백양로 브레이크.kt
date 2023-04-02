//https://www.acmicpc.net/problem/11562
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){
    //input
    val (n,m) = getIntList()
    val dp = Array(n+1){ r->
        IntArray(n+1){c->
            if(r == c) 0 else 987654321
        }
    }
    repeat(m){
        val (s,e,v) = getIntList()
        dp[s][e] = 0
        if(v == 1){
            dp[e][s] = 0
        }else{
            dp[e][s] = 1
        }
    }
    //solve
    for(k in 1 .. n){
        for(i in 1 .. n){
            for(j in 1 .. n){
                dp[i][j] = dp[i][j].coerceAtMost(dp[i][k] + dp[k][j])
            }
        }
    }
    repeat(getInt()){
        val (s,e) = getIntList()
        //output
        write("${dp[s][e]}\n")
    }
    close()
}
