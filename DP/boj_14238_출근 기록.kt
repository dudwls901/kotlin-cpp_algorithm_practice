//https://www.acmicpc.net/problem/14238
import java.util.*
val br = System.`in`.bufferedReader()

val dp = Array(50) { Array(50) { Array(50){Array(4){BooleanArray(4) } } } }
var isFinish = false
fun makeDP(a: Int, b: Int, c: Int, prev: Int, pprev: Int, ans: StringBuilder) {
    if(ans.length>50) return
    if (a == 0 && b == 0 && c == 0) {
        println(ans)
        isFinish = true
        return
    }
    if(isFinish) return
    if(dp[a][b][c][prev][pprev]) return
    dp[a][b][c][prev][pprev] = true
    if (a > 0) {
        ans.append('A')
        makeDP(a - 1, b, c, 1, prev,ans)
        ans.deleteCharAt(ans.lastIndex)
    }
    if (b > 0 && prev != 2) {
        ans.append('B')
        makeDP(a, b-1, c, 2, prev,ans)
        ans.deleteCharAt(ans.lastIndex)
    }
    if (c > 0 && prev != 3 && pprev != 3) {
        ans.append('C')
        makeDP(a, b, c - 1, 3, prev,ans)
        ans.deleteCharAt(ans.lastIndex)
    }
}

fun main(){
    val input = br.readLine()
    val cnt = IntArray(4)
    for (ch in input) {
        when (ch) {
            'A' -> cnt[1]++
            'B' -> cnt[2]++
            else -> cnt[3]++
        }
    }
    makeDP(cnt[1], cnt[2], cnt[3], 0, 0,StringBuilder())
    if (!isFinish) {
        println(-1)
    }
}
