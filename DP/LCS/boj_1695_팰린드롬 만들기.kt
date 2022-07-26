//https://www.acmicpc.net/problem/1695
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    val input = getIntList()
    val reverseInput = input.reversed()
    val dp = Array(n+1){IntArray(n+1)}

    //solve
    //input과 reverseInput의 LCS구해서 전체 사이즈에서 빼기
    for(i in 1 .. n){
        for(j in 1 .. n){
            if(input[i-1] == reverseInput[j-1]){
                dp[i][j] = dp[i-1][j-1]+1
            }
            else{
                dp[i][j] = dp[i-1][j].coerceAtLeast(dp[i][j-1])
            }
        }
    }
    //output
    write("${input.size -dp[n][n]}")
    close()
}
