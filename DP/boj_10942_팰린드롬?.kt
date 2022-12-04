//https://www.acmicpc.net/problem/10942
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    val arr = getIntList()
    val m = getInt()

    //solve
    val dp = Array(n+1){ i->
        BooleanArray(n+1){ j->
            i==j
        }
    }
    for(i in 1 until n){
        for(j in 0 until n-i){
            dp[j][j+i] = arr[j] == arr[j+i] && (dp[j+1][j+i-1] || j+1 > j+i-1)
       }
    }
    repeat(m){
        val (s,e) = getIntList().map { it-1 }
        write("${if(dp[s][e]) 1 else 0}\n")
    }
    close()
}
