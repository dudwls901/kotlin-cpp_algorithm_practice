//https://www.acmicpc.net/problem/1720
val br = System.`in`.bufferedReader()

//1<=n<=30
fun main() = with(System.out.bufferedWriter()){
    val n = br.readLine().toInt()
    val dp = IntArray(31)
    dp[0] = 1
    dp[1] = 1
    dp[2] = 3
    for(i in 3 .. n){
        dp[i] = dp[i-1]+dp[i-2]*2
    }
    //짝수인 경우
    if(n%2==0){
        write("${(dp[n]+(dp[n/2]+dp[n/2-1]*2))/2}")
    }
    else{
        write("${(dp[n]+dp[n/2])/2}")
    }

    close()
}
