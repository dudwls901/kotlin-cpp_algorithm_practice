//https://www.acmicpc.net/problem/5073
val br = System.`in`.bufferedReader()
fun getIntArray() = br.readLine().trim().split(' ').map { it.toInt() }.toIntArray()

fun main() = with(System.out.bufferedWriter()) {
    while (true) {
        val arr = getIntArray().sortedDescending()
        val distinguished = arr.distinct()
        if (distinguished.size == 1) {
            if (distinguished[0] == 0) break
            else write("Equilateral\n")
        } 
        else {
            if (arr[0] < arr[1] + arr[2]) {
                if(distinguished.size == 2) write("Isosceles\n")
                else write("Scalene\n")
            }
            else write("Invalid\n")
        }
    }
    close()
}
