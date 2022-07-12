//https://www.acmicpc.net/problem/1976
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {

    val n = getInt()
    val m = getInt()
    val edge = Array(n){ getIntList().toIntArray()}
    val arrival = getIntList().map { it-1 }
    for (k in 0 until n) {
        for (from in 0 until n) {
            for (to in 0 until n) {
                if(from==to){
                    edge[from][to] = 1
                    continue
                }
                if (edge[from][to] == 1) continue
                edge[from][to] = edge[from][k] and edge[k][to]
            }
        }
    }
    for (i in 0 until m-1) {
        if (edge[arrival[i]][arrival[i + 1]] == 0) {
            write("NO")
            close()
            return
        }
    }
    write("YES")

    close()
}
