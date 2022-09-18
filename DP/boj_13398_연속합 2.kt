//https://www.acmicpc.net/problem/13398
//2차원 dp
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){
    //input
    val INF = 1_000_000_000
    val n = getInt()
    val arr = getIntList()
    val dp = Array(n+1){IntArray(2){-INF} }
    var answer = -INF
    for(i in 1 .. arr.size){
        dp[i][0] = (dp[i-1][0] + arr[i-1]).coerceAtLeast(arr[i-1])
        dp[i][1] = dp[i-1][0].coerceAtLeast(dp[i-1][1]+arr[i-1])
        answer = answer.coerceAtLeast(dp[i][0].coerceAtLeast(dp[i][1]))
    }
    write("$answer")

    close()
}
//1차원 dp
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){
    //input
    val INF = 1_000_000_000
    val n = getInt()
    val arr = getIntList()
    val dp1 = IntArray(n){-INF}
    val dp2 = IntArray(n){-INF}
    dp1[0] = arr[0]
    dp2[n-1] = arr[n-1]
    var answer = dp1[0]
    for(i in 1 until n){
        dp1[i] = arr[i].coerceAtLeast(dp1[i-1]+arr[i])
        dp2[n-i-1] = arr[n-i-1].coerceAtLeast(dp2[arr.size-i] + arr[arr.size-i-1])
        answer = answer.coerceAtLeast(dp1[i])
    }
    for(i in 1 until n-1){
        answer = answer.coerceAtLeast(dp1[i-1] + dp2[i+1])
    }
    
    write("$answer")

    close()
}
