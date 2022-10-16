//https://www.acmicpc.net/problem/14675
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){
    val n = getInt()
    val cnt = IntArray(n+1)
    repeat(n-1){
        val (from, to) = getIntList()
        cnt[from]++
        cnt[to]++
    }
    repeat(getInt()){
        val (k,t) = getIntList()
        if(k==2) write("yes\n")
        else{
            if(cnt[t]<2) write("no\n")
            else write("yes\n")
        }
    }
    close()
}
