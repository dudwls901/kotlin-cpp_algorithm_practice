//https://www.acmicpc.net/problem/1940
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    val m = getInt()
    val input = getIntList().toIntArray()
    var answer = 0
    input.sort()
    var s = 0
    var e = input.size - 1

    //two pointer
    while (s < e) {
        val sum = input[s] + input[e]
        if (sum < m) {
            s++
        } else if (sum > m) {
            e--
        } else {
            var ns = s
            var ne = e
            while (ns < e && input[s] == input[ns]) {
                ns++
            }
            while (ne > s && input[e] == input[ne]) {
                ne--
            }
            answer += (ns - s) * (e - ne)
            s = ns
            e = ne
        }
    }
    //output
    write("$answer")
    close()
}
