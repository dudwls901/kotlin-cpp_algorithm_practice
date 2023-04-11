//https://www.acmicpc.net/problem/13422
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getStr() = br.readLine().trim()
fun getInt() = br.readLine().trim().toInt()


fun main() = with(System.out.bufferedWriter()){

    repeat(getInt()) {
        //input
        val (n, m, k) = getIntList()
        val village = getIntList()
        val circleVillageSum = LongArray(n * 2 + 1)
        for (i in 1 until circleVillageSum.size) {
            circleVillageSum[i] = circleVillageSum[i - 1] + village[(i - 1) % n]
        }
        var answer = 0
        for (i in 0 until n) {
            if (circleVillageSum[i + m] - circleVillageSum[i] < k) answer++
            if(n==m) break
        }
        write("$answer\n")
    }
    close()
}
